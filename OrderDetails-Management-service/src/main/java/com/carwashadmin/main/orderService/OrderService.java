package com.carwashadmin.main.orderService;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.carwashadmin.main.bean.Images;
import com.carwashadmin.main.bean.OrderDetails;

@Service
public interface OrderService {

	public OrderDetails updateOrder(OrderDetails data);

	public List<OrderDetails> getbyCustomer(String email);

	public List<OrderDetails> getbyWasher(String washer);
	
	 public int getNextSequence(String seqName);

	public Images UploadImage(MultipartFile file) throws IOException;

	public Images getImage(String imageName);
	    

}