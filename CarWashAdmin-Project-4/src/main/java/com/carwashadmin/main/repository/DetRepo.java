package com.carwashadmin.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carwashadmin.main.bean.CustomerDetails;


public interface DetRepo extends MongoRepository<CustomerDetails, String> {


}
