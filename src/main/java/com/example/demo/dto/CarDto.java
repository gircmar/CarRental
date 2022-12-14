package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.example.demo.enumerator.CarBrandEnum;
import com.example.demo.enumerator.CarClassificationEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CarDto {

	
	private Long id;
	
	private CarBrandEnum brand;
	
	@NotBlank (message="Name is required")
	private String name;
	
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date productionDate;
	
	private String engine;
	
	private CarClassificationEnum classification;
	
	
	private Double pricePerDay;
}
