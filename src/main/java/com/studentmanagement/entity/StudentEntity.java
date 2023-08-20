package com.studentmanagement.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Studentmnagement")
public class StudentEntity {
	
	@Id
	@SequenceGenerator(initialValue = 100,allocationSize = 1,name = "id",sequenceName = "id")
	@GeneratedValue(generator = "id")
	private int id;
	
	@Column(name = "Std_Name")
	private String name;

	@Column(name = "Std_Phone")
	private long phone;
	
	@Column(name = "Kann_Marks")
	private int kannada;
	
	@Column(name = "English_Marks")
	private int english;
	
	@Column(name = "Hindi_Marks")
	private int hindi;
	
	@Column(name = "total")
	private int total;
	
	@Column(name = "Percentage")
	private double per;
	
	@Column(name = "Std_DOB")
	private Date dob;
	
	@Column(name = "Std_Age")
	private int age;
}
