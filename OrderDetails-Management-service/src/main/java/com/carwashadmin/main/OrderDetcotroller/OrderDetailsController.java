package com.carwashadmin.main.OrderDetcotroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static Logger LOGGER = LoggerFactory.getLogger(OrderDetailsController.class);
	
	@GetMapping("/getorders")
	public List<OrderDetails> GetAllOrders() throws IOException{
		List<OrderDetails> orders= new ArrayList<OrderDetails>();
		try {
		orders= orderRepo.findAll();
	 } catch (Exception e) {
   		 LOGGER.error(e.getMessage(), e);
   		 LOGGER.error(e.getMessage(), "Error Occured in getOrders");
   		 LOGGER.error(e.getMessage(), "Error Occured in getOrders");
   		 LOGGER.error(e.getMessage(), "Error Occured in getOrders");
   	 }
		return orders;
		
	}
	
	
	@GetMapping("/getbyId/{orderId}")
	public OrderDetails GetbyId(@PathVariable int orderId) throws IOException{
		System.out.println(orderId);
		OrderDetails  det = new OrderDetails();
		try {
		det = orderRepo.findByOrderId(orderId);
	 } catch (Exception e) {
   		 LOGGER.error(e.getMessage(), e);
   		 LOGGER.error(e.getMessage(), "Error Occured in GetbyId");
   		 LOGGER.error(e.getMessage(), "Error Occured in GetbyId");
   		 LOGGER.error(e.getMessage(), "Error Occured in GetbyId");
   	 }
		return det;
	}
	
	@PostMapping("/createorder")
	public OrderDetails CreateOrder(@RequestBody OrderDetails data) throws IOException{
		byte[] pic;
		OrderDetails order = new OrderDetails();
		data.setOrderId(service.getNextSequence("customSequences"));
		try {
		System.out.println("ORDER ID IS************"+data.getOrderId());
		order = orderRepo.save(data);
	 } catch (Exception e) {
   		 LOGGER.error(e.getMessage(), e);
   		 LOGGER.error(e.getMessage(), "Error Occured in createOrder");
   		 LOGGER.error(e.getMessage(), "Error Occured in createOrder");
   		 LOGGER.error(e.getMessage(), "Error Occured in createOrder");
   	 }
		return order;
	}
	
	@PostMapping("/upload")
	public BodyBuilder UploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		try {
		//String response=null;
		service.UploadImage(file);
	 } catch (Exception e) {
   		 LOGGER.error(e.getMessage(), e);
   		 LOGGER.error(e.getMessage(), "Error Occured in UploadImage");
   		 LOGGER.error(e.getMessage(), "Error Occured in UploadImage");
   		 LOGGER.error(e.getMessage(), "Error Occured in UploadImage");
   	 }
		return ResponseEntity.status(HttpStatus.OK);
	}
	
	@GetMapping(path = { "/get/{imageName}" })
	public Images getImage(@PathVariable("imageName") String imageName) throws IOException {
		Images img= new Images();
		try {	
		 img= service.getImage(imageName);
	 } catch (Exception e) {
   		 LOGGER.error(e.getMessage(), e);
   		 LOGGER.error(e.getMessage(), "Error Occured in getImage");
   		 LOGGER.error(e.getMessage(), "Error Occured in getImage");
   		 LOGGER.error(e.getMessage(), "Error Occured in getImage");
   	 }
		return img;
	}
	
	@PutMapping("/updateorder")
	public OrderDetails UpdateOrder(@RequestBody OrderDetails data) throws IOException{
		OrderDetails updatedOrder=  new OrderDetails();
		try {
		 updatedOrder = service.updateOrder(data);
	 } catch (Exception e) {
   		 LOGGER.error(e.getMessage(), e);
   		 LOGGER.error(e.getMessage(), "Error Occured in UpdateOrder");
   		 LOGGER.error(e.getMessage(), "Error Occured in UpdateOrder");
   		 LOGGER.error(e.getMessage(), "Error Occured in UpdateOrder");
   	 }
		return updatedOrder;
	}
	
	@GetMapping("/getbycustomer/{customer}")
	public List<OrderDetails> GetByCustomer(@PathVariable String customer) throws IOException{
		List<OrderDetails> list=new ArrayList<OrderDetails>();
		try {
		 list = service.getbyCustomer(customer);
	 } catch (Exception e) {
   		 LOGGER.error(e.getMessage(), e);
   		 LOGGER.error(e.getMessage(), "Error Occured in GetbyCustomer");
   		 LOGGER.error(e.getMessage(), "Error Occured in GetbyCustomer");
   		 LOGGER.error(e.getMessage(), "Error Occured in GetbyCustomer");
   	 }
		return list;
	}
	
	@GetMapping("getbywasher/{washer}")
	public List<OrderDetails> GetByWasher(@PathVariable String washer) throws IOException{
		List<OrderDetails> list=new ArrayList<OrderDetails>();
		try {
		list = service.getbyWasher(washer);
	 } catch (Exception e) {
   		 LOGGER.error(e.getMessage(), e);
   		 LOGGER.error(e.getMessage(), "Error Occured in GetbyCustomer");
   		 LOGGER.error(e.getMessage(), "Error Occured in GetbyCustomer");
   		 LOGGER.error(e.getMessage(), "Error Occured in GetbyCustomer");
   	 }
		return list;
		
	}
}
