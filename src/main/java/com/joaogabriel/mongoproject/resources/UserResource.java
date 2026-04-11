package com.joaogabriel.mongoproject.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaogabriel.mongoproject.domain.User;

@RestController
@RequestMapping("/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("3", "maria", "maria@email");
		
		List<User> lista = new ArrayList<>();
		lista.addAll(Arrays.asList(maria));
		
		return ResponseEntity.ok().body(lista);
	}
}
