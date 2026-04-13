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
import com.joaogabriel.mongoproject.dto.CommentDTO;
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
		
		CommentDTO c1 = new CommentDTO("Boa viagem irmão", sdf.parse("12/04/2026"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Vai com Deus!", sdf.parse("12/04/2026"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Treino hoje foi brabo!", sdf.parse("12/04/2026"), new AuthorDTO(bob));
		
		post1.addComments(Arrays.asList(c1, c2));
		post2.addComments(Arrays.asList(c3));
		
		pRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.addPosts(Arrays.asList(post1, post2));
		uRepository.save(maria);
		
		
	}

}
