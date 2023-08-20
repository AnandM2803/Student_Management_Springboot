package com.studentmanagement.service;

import java.util.List;

import com.studentmanagement.entity.StudentEntity;
import com.studentmanagement.responsestructure.ResponseStructure;

public interface StudentService {

	ResponseStructure<StudentEntity> addDetails(StudentEntity entity);

	ResponseStructure<List<StudentEntity>> getAllDetails();

	ResponseStructure<StudentEntity> getById(int id);

	ResponseStructure<List<StudentEntity>> getByName(String name);

	ResponseStructure<StudentEntity> upadteById(int id, StudentEntity entity);

	ResponseStructure<StudentEntity> deleteById(int id);



	

}
