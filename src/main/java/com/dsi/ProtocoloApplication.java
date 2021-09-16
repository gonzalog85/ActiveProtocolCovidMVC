package com.dsi;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProtocoloApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProtocoloApplication.class, args);
	}

	@Bean
	public CommandLineRunner prueba() {
		return args -> {
			Date d = new Date();
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			System.out.println("Fecha de hoy:" + df.format(d));
			System.out.println("Fecha hace dos días:" + df.format((d.getTime() - 2 * 24 * 60 * 60 * 1000)));
			System.out.println("Fecha en tres días:" + df.format((d.getTime() + 3 * 24 * 60 * 60 * 1000)));
		};
	}

}
