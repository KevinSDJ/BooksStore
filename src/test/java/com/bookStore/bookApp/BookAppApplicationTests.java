package com.bookStore.bookApp;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import com.bookStore.bookApp.DTO.RequestLoginDTO;
import com.bookStore.bookApp.DTO.UserDTO;
import com.bookStore.bookApp.Services.impl.UsersServiceImpl;

@SpringBootTest
class BookAppApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(BookAppApplicationTests.class);

	UserDTO data = new UserDTO("kevin","kevin@gmail.com", "12345");

	String token=null;

	

	@Autowired
	UsersServiceImpl userService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Test
	@Order(1)
	void register() throws Exception{
		try{
			userService.register(data);
		}catch(Exception e){
			log.error("error test 1: {}", e.getMessage());
			throw new Exception(e.getCause().toString());
		}
		
	}

	@Test
	@Order(2)
	void login() throws Exception{
		RequestLoginDTO user = new RequestLoginDTO(data.getEmail(),data.getPassword());
		try{
			com.bookStore.bookApp.DTO.TokenResponseDTO reponse= userService.login(user);
			log.info("token reponse :{}",reponse);
		}catch(Exception e){
			log.error(e.getMessage());
			throw new Exception(e);
		}
		
	}

	@Test
	@Order(3)
	void loadCategories(){
		
	}

}
