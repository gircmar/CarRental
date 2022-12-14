package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.dto.RentDto;
import com.example.demo.service.RentService;

@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
@RestController
@RequestMapping("/rent")
public class RentController {

	@Autowired RentService rentService;
	
	@GetMapping("/{id}")
	public RentDto findById(@PathVariable (name="id") Long id) {
		return rentService.findById(id);
		
	}
	
	@GetMapping("")
	public List<RentDto> findAllRents() {
		return rentService.findAllRents();
	}
		
	
	@PostMapping("")
	public RentDto createRent( @RequestBody RentDto rentDto) {
		return rentService.createRent(rentDto);
	}
	
	@PutMapping("/{id}")
	public RentDto updateRent( @RequestBody RentDto rentDto,@PathVariable(name="id") Long id) {
		return rentService.updateRent(rentDto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRent(@PathVariable(name="id") Long id) {
		rentService.deleteRent(id);
	}
}
