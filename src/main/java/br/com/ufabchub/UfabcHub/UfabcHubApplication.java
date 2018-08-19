package br.com.ufabchub.UfabcHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.ufabchub.controller", "br.com.ufabchub.service", "br.com.ufabchub.config" })
@EntityScan(basePackages = "br.com.ufabchub.model")
@EnableJpaRepositories(basePackages = "br.com.ufabchub.repository")
public class UfabcHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(UfabcHubApplication.class, args);
	}
}
