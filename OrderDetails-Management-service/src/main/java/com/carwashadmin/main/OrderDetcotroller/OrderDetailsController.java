package com.carwashadmin.main.OrderDetcotroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.carwashadmin.main.bean.Images;
import com.carwashadmin.main.bean.OrderDetails;
import com.carwashadmin.main.image.ImageCompress;
import com.carwashadmin.main.orderRepository.ImagesRepository;
import com.carwashadmin.main.orderRepository.OrderDetailsRepository;
import com.carwashadmin.main.orderService.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderDetailsController {

	@Autowired
	OrderDetailsRepository orderRepo;
	
	@Autowired
	OrderService service;
	
	@Autowired
	ImagesRepository imgRepo;
	
	
	ImageCompress img;
	
	@GetMapping("/getorders")
	public List<OrderDetails> GetAllOrders() {
		List<OrderDetails> orders= orderRepo.findAll();
		return orders;
		
	}
	
	
	@GetMapping("/getbyId/{orderId}")
	public OrderDetails GetbyId(@PathVariable int orderId) {
		System.out.println(orderId);
		OrderDetails  det = orderRepo.findByOrderId(orderId);
		return det;
	}
	
	@PostMapping("/createorder")
	public OrderDetails CreateOrder(@RequestBody OrderDetails data){
		byte[] pic;
		OrderDetails order = new OrderDetails();
		data.setOrderId(service.getNextSequence("customSequences"));
		System.out.println("ORDER ID IS************"+data.getOrderId());
		/*
		 * pic = img.compressBytes(data.getPhoto()); data.setPhoto(pic);
		 */
		order = orderRepo.save(data);
		return order;
	}
	
	@PostMapping("/upload")
	public BodyBuilder UploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		//String response=null;
		service.UploadImage(file);
		return ResponseEntity.status(HttpStatus.OK);
	}
	
	@GetMapping(path = { "/get/{imageName}" })
	public Images getImage(@PathVariable("imageName") String imageName) throws IOException {
		
		Images img= service.getImage(imageName);
		return img;
	}
	
	@PutMapping("/updateorder")
	public OrderDetails UpdateOrder(@RequestBody OrderDetails data) {
		OrderDetails updatedOrder = service.updateOrder(data);
		return updatedOrder;
	}
	
	@GetMapping("/getbycustomer/{customer}")
	public List<OrderDetails> GetByCustomer(@PathVariable String customer){
		List<OrderDetails> list = service.getbyCustomer(customer);
		return list;
	}
	
	@GetMapping("getbywasher/{washer}")
	public List<OrderDetails> GetByWasher(@PathVariable String washer){
		List<OrderDetails> list = service.getbyWasher(washer);
		return list;
		
	}
}
