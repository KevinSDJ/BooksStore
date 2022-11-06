package com.bookStore.bookApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookAppApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Long count = rolRepository.count();
		if(count<1){
			Rol rol1= new Rol("USER");
			Rol rol2= new Rol("ADMIN");
			List<Rol> roles = List.of(rol1,rol2);

			rolRepository.saveAll(roles);
		}
		
	}

}
