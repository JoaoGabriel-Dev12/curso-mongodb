package com.joaogabriel.mongoproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaogabriel.mongoproject.domain.Post;
import com.joaogabriel.mongoproject.repository.PostRepository;
import com.joaogabriel.mongoproject.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
	}
}
