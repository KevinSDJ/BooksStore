package com.example.bookApp;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.example.bookApp.DTO.UserDTO;
import com.example.bookApp.Services.impl.UsersServiceImpl;
import com.example.bookApp.security.jwt.JwtUtil;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class DemoApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

	UserDTO data = new UserDTO("kevin","kevin@gmail.com", "12345");

	String token=null;

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	UsersServiceImpl userService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Test
	@Order(1)
	void register(){
		userService.register(data);
	}

	@Test
	@Order(2)
	void createToken(){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getEmail(),data.getPassword()));
		token =jwtUtil.generateToken(authentication);
		log.info(token);
	}

	@Test
	@Order(3)
	void viewEmailFromToken(){
			
	}
}
