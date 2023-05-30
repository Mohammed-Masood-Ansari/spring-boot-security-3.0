package com.ty.springbootsecurity30.response;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStructure<T> {

	private int statusCode;
	private String statusMessage;
	private T statusData;
	
	
}
