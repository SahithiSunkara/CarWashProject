package com.carwashadmin.main.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.carwashadmin.main.bean.Details;

@Repository
public interface TestRepo extends MongoRepository<Details, String>{

	@Query(value="{'firstName' : ?0}")
	List<Details> findByfirstName(String firstName);

	@Query(value="{'email' : ?0}")
	Details findByEmail(String email);

	@Query(value="{'role' : ?0}")
	List<Details> findByRole(String role);
}
