package com.carwashadmin.main.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

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

	/*
	 * @RequestMapping(value = "/{userdet}", method = RequestMethod.POST) public
	 * CustomerDetails addNewUsers(@RequestBody CustomerDetails detail) {
	 * System.out.println("Saving user." + detail); return detRepo.save(detail); }
	 */
	@GetMapping("/getCustomers")
	public List<Details> getCustomers(){
		return testRepo.findAll();
	}
	
	 @PostMapping("/AddDetails")
	  public Details addcustomer(@RequestBody Details customer) { 
		 System.out.println("******************JSON**************"+customer);
		 Details list= null; 
	   try {
		list =cutomerService.AddDetails(customer);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	   return list;
	 
	  }
	 
	 @GetMapping("/getbyEmail/{email}")
	 public Details getbyEmail(@PathVariable String email) {
		
		 Details response = cutomerService.loginValidate(email);
		 return response;
	 }
	 
	 @GetMapping("/getbyrole/{role}")
	 public List<Details> GetbyRole(@PathVariable String role) {
		 System.out.println(role);
		 List<Details> list = testRepo.findByRole(role);
		 System.out.println(list);
		 return list;
	 }
		/*
		 * @GetMapping("/delete/{id}") public Details delete(@PathVariable String id) {
		 * 
		 * int i=0; System.out.println(id);
		 * System.out.println(testRepo.findByfirstName(id)); List<Details>
		 * det=testRepo.findByfirstName(id); System.out.println("det value"+det); return
		 * det.get(i);
		 * 
		 * 
		 * }
		 */
	 
		
		  @DeleteMapping("/customerdelete/{email}")
		  public String CustomerDelete(@PathVariable String email){ 
			  Details result= testRepo.findByEmail(email); 
			  int i=1;
			  System.out.println(result);
			  System.out.println(result.getId());
			  String id= result.getId();
			  testRepo.deleteById(id);
			  return "deleted";
			  }
		 
	
		
		  @PutMapping("/updatecustomer")
		  public Details updatecustomer(@RequestBody Details updatedDet) throws IOException {
			  System.out.println(updatedDet);
		  Details data = cutomerService.UpdateDetails(updatedDet); 
		  return data;
		  
		  }
		 
	
	/*
	 * @RequestMapping(value = "/getcustomer/{cutomerId}") public CustomerDetails
	 * getcustomer(@PathVariable String Id) throws IOException { CustomerDetails
	 * Detailslist= null; Detailslist = cutomerService.getDetails(Id); return
	 * Detailslist;
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/upload") public BodyBuilder
	 * uplaodImage(@RequestParam("imageFile") MultipartFile file) {
	 * 
	 * System.out.println("Original Image Byte Size - " + file.getBytes().length);
	 * 
	 * return ResponseEntity.status(HttpStatus.OK); }
	 */
}
