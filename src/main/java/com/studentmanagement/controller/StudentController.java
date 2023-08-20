package com.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagement.entity.StudentEntity;
import com.studentmanagement.responsestructure.ResponseStructure;
import com.studentmanagement.service.StudentService;

@RestController
@RequestMapping("studentmanagement")
public class StudentController {

	
	@Autowired
	StudentService service;
	
	@PostMapping("/adddetails")
	public ResponseStructure<StudentEntity> addDeatils(@RequestBody StudentEntity entity)
	{
		return service.addDetails(entity);
	}
	
	@GetMapping("/getalldetails")
	public ResponseStructure<List<StudentEntity>> getAllDetails()
	{
		return service.getAllDetails();
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseStructure<StudentEntity> getById(@PathVariable int id)
	{
		return service.getById(id);
	}
	
	@GetMapping("/getbyname/{name}")
	public ResponseStructure<List<StudentEntity>> getByName(@PathVariable String name)
	{
		return service.getByName(name);
	}
	
	@PutMapping("/updatebyid/{id}")
	public ResponseStructure<StudentEntity> updateById(@PathVariable int id,@RequestBody StudentEntity entity)
	{
		return service.upadteById(id,entity);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseStructure<StudentEntity> deleteById(@PathVariable int id)
	{
		return service.deleteById(id);
	}
}
