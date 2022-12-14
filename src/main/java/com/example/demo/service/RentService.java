package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RentDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Rent;
import com.example.demo.entity.User;
import com.example.demo.mapper.RentMapper;
import com.example.demo.repository.RentRepository;

@Service
public class RentService {
@Autowired RentMapper rentMapper;
@Autowired RentRepository rentRepository;

public RentDto findById (Long id) {
	Rent rent = rentRepository.findById(id).orElse(null);
	return rentMapper.toDto(rent);
}

public List<RentDto> findAllRents(){
	List <Rent> rent=(List<Rent>) rentRepository.findAll();
	return rentMapper.toDtoList(rent);
}
public RentDto createRent(RentDto rentDto) {
	Rent rent=rentMapper.fromDto(rentDto);
	rentRepository.save(rent);
	return rentMapper.toDto(rent);
}
public RentDto updateRent (RentDto rentDto) {
	Rent rent = rentMapper.fromDto(rentDto);
	rentRepository.save(rent);
	return rentMapper.toDto(rent);
}
public void deleteRent (Long id) {
	rentRepository.deleteById(id);
}

}
