package com.aiac.testconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TestConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestConfigApplication.class, args);
	}

	@RestController
	@RefreshScope
	class TestConfig{
		@Value("${global.params.x}")
		String valueX;

		@Value("${global.params.y}")
		String valueY;

		@GetMapping("/test")
		public String get(){
			return "X --> "+valueX+" ; "+"Y --> "+valueY;
		}
	}

}
