package com.swamy.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.swamy.model.Employee;

@EnableMongoRepositories
public interface EmployeeRepository extends MongoRepository<Employee,String> {

}
