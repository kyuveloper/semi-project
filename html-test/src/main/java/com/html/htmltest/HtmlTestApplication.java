package com.html.htmltest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class HtmlTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtmlTestApplication.class, args);
	}

}
