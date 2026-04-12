package com.joaogabriel.mongoproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaogabriel.mongoproject.domain.User;
import com.joaogabriel.mongoproject.repository.UserRepository;
import com.joaogabriel.mongoproject.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}
}
