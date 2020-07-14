package com.carwashadmin.main.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.carwashadmin.main.bean.CustomerDetails;
import com.carwashadmin.main.bean.Details;
import com.carwashadmin.main.bean.Test;

@Service
public interface CustomerService {

	public Details AddDetails(Details details) throws IOException;
	
	public Details UpdateDetails(Details details) throws IOException;

	
	
	
	
	public Details loginValidate(String email);

		
	
}
