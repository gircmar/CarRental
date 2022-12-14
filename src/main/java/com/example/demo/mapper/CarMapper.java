package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CarDto;
import com.example.demo.entity.Car;

@Service
public class CarMapper {
	
	public CarDto toDto(Car entity) {
		if(entity==null) {
			return null;
		}
		CarDto dto=new CarDto();
		dto.setId(entity.getId());
		dto.setBrand(entity.getBrand());
		dto.setName(entity.getName());
		dto.setProductionDate(entity.getProductionDate());
		dto.setEngine(entity.getEngine());
		dto.setClassification(entity.getClassification());
		dto.setPricePerDay(entity.getPricePerDay());
		
		return dto;
	}
	public Car fromDto(CarDto dto) {
		if(dto==null) {
			return null;
		}
		Car entity=new Car();
		entity.setId(dto.getId());
		entity.setBrand(dto.getBrand());
		entity.setName(dto.getName());
		entity.setProductionDate(dto.getProductionDate());
		entity.setEngine(dto.getEngine());
		entity.setClassification(dto.getClassification());
		entity.setPricePerDay(dto.getPricePerDay());	
		return entity;
	}
	
	public List<CarDto> toDtoList(List<Car> entities){
		List<CarDto> dtos=new ArrayList<>();
		for (Car entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}
}
