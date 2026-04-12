package com.joaogabriel.mongoproject.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.joaogabriel.mongoproject.domain.Post;
import com.joaogabriel.mongoproject.domain.User;
import com.joaogabriel.mongoproject.dto.AuthorDTO;
import com.joaogabriel.mongoproject.repository.PostRepository;
import com.joaogabriel.mongoproject.repository.UserRepository;

@Configuration
public class Config implements CommandLineRunner{

	
	@Autowired
	private UserRepository uRepository;
	
	@Autowired
	private PostRepository pRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		uRepository.deleteAll();
		pRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		uRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("12/04/2026"), "Partiu viagem!", "Vou para Goiânia!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("12/04/2026"), "No BJJ", "No pain no gain!!", new AuthorDTO(maria));
		
		pRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.addPosts(Arrays.asList(post1, post2));
		uRepository.save(maria);
	}

}
