package com.studentmanagement.responsestructure;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	int code;
	String msg;
	T data;
}
