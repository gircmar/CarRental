package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CarDto;
import com.example.demo.service.CarService;

@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired CarService carService;

	
	@GetMapping("/{id}")
	public CarDto findById(@PathVariable (name="id") Long id) {
		return carService.findById(id);
		
	}
	
	@GetMapping("")
	public List<CarDto> findAllCars() {
		return carService.findAllCars();
	}
		
	
	@PostMapping("")
	public CarDto createCar( @RequestBody CarDto carDto) {
		return carService.createCar(carDto);
	}
	
	@PutMapping("/{id}")
	public CarDto updateUser( @RequestBody CarDto carDto,@PathVariable(name="id") Long id) {
		return carService.updateCar(carDto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable(name="id") Long id) {
		carService.deleteCar(id);
	}
}
