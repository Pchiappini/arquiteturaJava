package br.edu.infinet.appautovendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AppautovendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppautovendasApplication.class, args);
	}

}
