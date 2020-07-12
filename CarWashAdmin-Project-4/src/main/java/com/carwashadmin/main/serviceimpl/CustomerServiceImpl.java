package com.carwashadmin.main.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.carwashadmin.main.bean.CustomerDetails;
import com.carwashadmin.main.bean.Details;
import com.carwashadmin.main.bean.ImageData;
import com.carwashadmin.main.bean.Test;
import com.carwashadmin.main.image.ImageClass;
import com.carwashadmin.main.repository.DetRepo;
import com.carwashadmin.main.repository.TestRepo;
import com.carwashadmin.main.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	DetRepo detRepo;

	@Autowired
	TestRepo test;	
	
	ImageClass img;
	
	

	@SuppressWarnings("unchecked")
	public Details AddDetails(Details details) throws IOException {

		/*
		 * ArrayList<CustomerDetails> det = new ArrayList<CustomerDetails>();
		 * det.addAll(details);
		 */
		return test.save(details);
	}

	@Override
	public Details UpdateDetails(Details details) throws IOException {

		String email = details.getEmail();
		byte[] picture;
		Details dbData = test.findByEmail(email);
		int i = 0;
		System.out.println(dbData == null);
		if (dbData != null) {

			dbData.setFirstName(details.getFirstName());
			dbData.setMiddleName(details.getMiddleName());
			dbData.setLastName(details.getLastName());
			dbData.setEmail(details.getEmail());
			dbData.setPhone_no(details.getPhone_no());
			dbData.setAddress(details.getAddress());
			dbData.setPassword(details.getPassword());
			if (details.getImage() != null) {
				picture = img.compressBytes(details.getImage());
				dbData.setImage(picture);
			}

		}
		Details NewData = test.save(dbData);
		return NewData;
	}

	/*
	 * @Override public CustomerDetails getDetails(String Id) throws IOException{
	 * 
	 * Optional<CustomerDetails> details = null; CustomerDetails det = null;
	 * details= detRepo.findById(Id); byte[] img=null; if(details.isPresent() ==
	 * true) {
	 * 
	 * img=ImageClass.decompressBytes(details.get().getPhoto());
	 * details.get().setPhoto(img);
	 * 
	 * det= details.get(); return det; } return det; }
	 */
	/*
	 * @Override public BodyBuilder UploadFile(MultipartFile file) throws
	 * IOFileUploadException { // TODO Auto-generated method stub
	 * 
	 * byte[] img=null; img=ImageClass.compressBytes(file.getBytes());
	 * detRepo.save(img);
	 * 
	 * return ResponseEntity.status(HttpStatus.OK);
	 * 
	 * }
	 */

	@Override
	public Details loginValidate(String email) {
		// TODO Auto-generated method stub
		byte[] picture;
		Details dbdata = test.findByEmail(email);
		
		return dbdata;
	}

}
