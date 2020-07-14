package com.carwashadmin.main.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carwashadmin.main.bean.ImageData;

public interface ImageRepository extends MongoRepository<ImageData, Long>{

	Optional<ImageData> findByName(String name);
}
