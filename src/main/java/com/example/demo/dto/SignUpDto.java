package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpDto {
	
	@NotBlank
	@Size(min=3,max=15)
	private String name;
	
	@NotBlank
	@Size(min=3,max=15)
	private String lastName;
	
	@Email
	@Size(max=50)
	private String email;
	
	@NotBlank
	@Size(min=6,max=20)
	private String password;
	
	
	@NotBlank
	@Size(min=6,max=20)
	private String repeatPassword;

}
