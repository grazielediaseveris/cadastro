package com.nttdata.cadastrodeusuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CadastrodeusuarioApplication {

	public static void main(String[] args) {

		SpringApplication.run(CadastrodeusuarioApplication.class, args);
		System.out.print(new BCryptPasswordEncoder().encode("123"));
	}
}
