package com.carwashadmin.main.orderRepository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.carwashadmin.main.bean.Images;

public interface ImagesRepository extends MongoRepository<Images, String>{
	
	@Query(value="{'name' : ?0}")
	Images findByName(String name);

}
