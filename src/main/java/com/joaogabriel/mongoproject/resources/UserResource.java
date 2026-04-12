package com.joaogabriel.mongoproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaogabriel.mongoproject.dto.UserDTO;
import com.joaogabriel.mongoproject.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<UserDTO> listaDto = service.findAll()
				.stream().map(u -> new UserDTO(u)).toList();
		
		return ResponseEntity.ok().body(listaDto);
	}
}
