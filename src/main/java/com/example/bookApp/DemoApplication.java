package com.example.bookApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.bookApp.Entities.Rol;
import com.example.bookApp.Repositories.RolRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	RolRepository rolRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
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

