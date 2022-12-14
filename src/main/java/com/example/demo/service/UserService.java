package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
@Autowired UserMapper userMapper;
@Autowired UserRepository userRepo;

public UserDto findById(Long id ) {
	User user=userRepo.findById(id).orElse(null);
	return userMapper.toDto(user);
}

public List<UserDto> findAllUsers(){
	List <User> users=(List<User>) userRepo.findAll();
	return userMapper.toDtoList(users);
}
public UserDto createUser(UserDto userDto) {
	User user=userMapper.fromDto(userDto);
	userRepo.save(user);
	return userMapper.toDto(user);
}

public UserDto updateUser (UserDto userDto) {
	User user = userMapper.fromDto(userDto);
	userRepo.save(user);
	return userMapper.toDto(user);
}

public void deleteUser (Long id) {
	userRepo.deleteById(id);
}


}
