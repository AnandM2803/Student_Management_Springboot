package com.studentmanagement.serviceimpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.studentmanagement.entity.StudentEntity;
import com.studentmanagement.repository.StudentRepository;
import com.studentmanagement.responsestructure.ResponseStructure;
import com.studentmanagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository repository;
	@Override
	public ResponseStructure<StudentEntity> addDetails(StudentEntity entity) {
		
		entity.setAge(Period.between(entity.getDob().toLocalDate(), LocalDate.now()).getYears());
		entity.setTotal(entity.getKannada()+entity.getEnglish()+entity.getHindi());
		double percentage=entity.getTotal()/3.0;
		entity.setPer(percentage);
		ResponseStructure<StudentEntity> structure=new ResponseStructure<>();
		structure.setMsg("Data Saved successfully");
		structure.setCode(HttpStatus.CREATED.value());
		structure.setData(repository.save(entity));
		return structure;
	}
	@Override
	public ResponseStructure<List<StudentEntity>> getAllDetails() {
		
		ResponseStructure<List<StudentEntity>> structure=new ResponseStructure<List<StudentEntity>>();
		List<StudentEntity> list=repository.findAll();
		if(list.isEmpty())
		{
			structure.setMsg("Not Found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
		}
		else
		{
			structure.setMsg("Data Found");
			structure.setCode(HttpStatus.FOUND.value());
			structure.setData(list);
		}
		
		return structure;
	}
	@Override
	public ResponseStructure<StudentEntity> getById(int id) {
		
		ResponseStructure<StudentEntity> structure=new ResponseStructure<StudentEntity>();
		Optional<StudentEntity> optional=repository.findById(id);
		if(optional.isEmpty())
		{
			structure.setMsg("Data Not Found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
		}
		else
		{
			structure.setMsg("Data Found");
			structure.setCode(HttpStatus.FOUND.value());
			structure.setData(optional.get());
		}
		
		return structure;
	}
	@Override
	public ResponseStructure<List<StudentEntity>> getByName(String name) {
		
		ResponseStructure<List<StudentEntity>> structure=new ResponseStructure<List<StudentEntity>>();
		List<StudentEntity> list=repository.findByName(name);
		if(list==null)
		{
			structure.setMsg("Data Not Found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
		}
		else
		{
			structure.setMsg("Data Found");
			structure.setCode(HttpStatus.FOUND.value());
			structure.setData(list);
		}
		
		return structure;
	}
	@Override
	public ResponseStructure<StudentEntity> upadteById(int id, StudentEntity entity) {
		
		ResponseStructure<StudentEntity> structure=new ResponseStructure<StudentEntity>();
		StudentEntity entity2=repository.findById(id).get();
		if(entity2!=null)
		{
			entity2.setName(entity.getName());
			entity2.setPhone(entity.getPhone());
			entity2.setDob(entity.getDob());
			entity2.setAge(Period.between(entity2.getDob().toLocalDate(), LocalDate.now()).getYears());
			entity2.setKannada(entity.getKannada());
			entity2.setEnglish(entity.getEnglish());
			entity2.setHindi(entity.getHindi());
			entity2.setTotal(entity2.getKannada()+entity2.getEnglish()+entity2.getHindi());
			double percentage=entity2.getTotal()/3.0;
			entity2.setPer(percentage);
			structure.setMsg("Data Updated Successfully");
			structure.setCode(HttpStatus.OK.value());
			structure.setData(repository.save(entity2));
		}
		else
		{
			structure.setMsg("Data Not Found To Update");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
		}
		return structure;
	}
	@Override
	public ResponseStructure<StudentEntity> deleteById(int id) {
		
		ResponseStructure<StudentEntity> structure=new ResponseStructure<StudentEntity>();
		Optional<StudentEntity> list=repository.findById(id);
		if(list.isEmpty())
		{
			structure.setMsg("Data Not Found to Delete");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
		}
		else
		{
			repository.deleteById(id);
			structure.setMsg("data Deleted Successfully");
			structure.setCode(HttpStatus.OK.value());
			structure.setData(list.get());
		}
		return structure;
	}

}
