package com.romulomotta.checkpoint;

import com.romulomotta.checkpoint.model.entity.Cliente;
import com.romulomotta.checkpoint.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CheckpointApplication {

//	@Bean
//	public CommandLineRunner run(@Autowired ClienteRepository repository) {
//		return args -> {
//			Cliente cliente = Cliente.builder()
//					.cpf("01234568745")
//					.nome("Fulano")
//					.build();
//			repository.save(cliente);
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(CheckpointApplication.class, args);
	}

}
