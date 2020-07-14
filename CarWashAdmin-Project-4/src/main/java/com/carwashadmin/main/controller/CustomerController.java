package com.carwashadmin.main.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.carwashadmin.main.bean.CustomerDetails;
import com.carwashadmin.main.bean.Details;
import com.carwashadmin.main.bean.Test;
import com.carwashadmin.main.repository.DetRepo;
import com.carwashadmin.main.repository.TestRepo;
import com.carwashadmin.main.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	DetRepo detRepo;

	@Autowired
	TestRepo testRepo;

	@Autowired
	CustomerService cutomerService;

	private static Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@GetMapping("/getCustomers")
	public List<Details> getCustomers() throws IOException{
		return testRepo.findAll();
	}
	
	 @PostMapping("/AddDetails")
	  public Details addcustomer(@RequestBody Details customer) throws IOException{ 
		 System.out.println("******************JSON**************"+customer);
		 Details list= new Details(); 
	   try {
		list =cutomerService.AddDetails(customer);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	   return list;
	 
	  }
	 
	 @GetMapping("/getbyEmail/{email}")
	 public Details getbyEmail(@PathVariable String email) throws IOException{
		Details response= new Details();
		 try {
		  response = cutomerService.loginValidate(email);
	 } catch (Exception e) {
   		 LOGGER.error(e.getMessage(), e);
   		 LOGGER.error(e.getMessage(), "Error Occured in getbyEmail");
   		 LOGGER.error(e.getMessage(), "Error Occured in getbyemail");
   		 LOGGER.error(e.getMessage(), "Error Occured in getbyemail");
   	 }
		 
		 return response;
	 }
	 
	 @GetMapping("/getbyrole/{role}")
	 public List<Details> GetbyRole(@PathVariable String role) throws IOException{
		 List<Details> list = new ArrayList<Details>();
		try{
		 System.out.println(role);
		list = testRepo.findByRole(role);
		 System.out.println(list);
	 } catch (Exception e) {
   		 LOGGER.error(e.getMessage(), e);
   		 LOGGER.error(e.getMessage(), "Error Occured in gtbyRole");
   		 LOGGER.error(e.getMessage(), "Error Occured in getbyRole");
   		 LOGGER.error(e.getMessage(), "Error Occured in getbyRole");
   	 }
		 return list;
	 }
		
	 
		
		  @DeleteMapping("/customerdelete/{email}")
		  public BodyBuilder CustomerDelete(@PathVariable String email){ 
			  Details result= testRepo.findByEmail(email); 
			  System.out.println(result);
			  System.out.println(result.getId());
			  String id= result.getId();
			  try {
			  testRepo.deleteById(id);
		  } catch (Exception e) {
		   		 LOGGER.error(e.getMessage(), e);
		   		 LOGGER.error(e.getMessage(), "Error Occured in CustomerDelete");
		   		 LOGGER.error(e.getMessage(), "Error Occured in CustomerDelete");
		   		 LOGGER.error(e.getMessage(), "Error Occured in CustomerDelete");
		   	 }
			  return ResponseEntity.status(HttpStatus.OK);
			  }
		 
	
		
		  @PutMapping("/updatecustomer")
		  public Details updatecustomer(@RequestBody Details updatedDet) throws IOException {
			  System.out.println(updatedDet);
			  Details data = new Details();
			  try {
		   data = cutomerService.UpdateDetails(updatedDet); 
		  } catch (Exception e) {
		   		 LOGGER.error(e.getMessage(), e);
		   		 LOGGER.error(e.getMessage(), "Error Occured in UpdateCustomer");
		   		 LOGGER.error(e.getMessage(), "Error Occured in UpdateCustomer");
		   		 LOGGER.error(e.getMessage(), "Error Occured in UpdateCustomer");
		   	 }
		  return data;
		  
		  }
		 
	

}
