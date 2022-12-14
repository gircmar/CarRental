package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.RentDto;
import com.example.demo.entity.Car;
import com.example.demo.entity.Rent;
import com.example.demo.entity.User;

@Service
public class RentMapper {

	public RentDto toDto(Rent entity) {
		if(entity==null) {
			return null;
		}
		RentDto dto=new RentDto();
		dto.setId(entity.getId());
		dto.setStartDate(entity.getStartDate());
		dto.setEndDate(entity.getEndDate());
		dto.setTotalPrice(entity.getTotalPrice());
		dto.setTotalPriceWithDiscount(entity.getTotalPriceWithDiscount());
		dto.setDiscount(entity.getDiscount());
		dto.setUserId(entity.getUser().getId());
		dto.setCarId(entity.getCar().getId());
		
		return dto;
	}
	
	public Rent fromDto(RentDto dto) {
		if(dto==null) {
			return null;
		}
		Rent entity=new Rent();
		entity.setId(dto.getId());
		entity.setStartDate(dto.getStartDate());
		entity.setEndDate(dto.getEndDate());
		entity.setTotalPrice(dto.getTotalPrice());
		entity.setTotalPriceWithDiscount(dto.getTotalPriceWithDiscount());
		entity.setDiscount(dto.getDiscount());
		
		User user=new User();
		user.setId(dto.getUserId());
		entity.setUser(user);
		
		Car car = new Car();
		car.setId(dto.getCarId());
		entity.setCar(car);
		
	
		return entity;
	}
	
	public List<RentDto> toDtoList(List<Rent> entities){
		List<RentDto> dtos=new ArrayList<>();
		for (Rent entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}
}
