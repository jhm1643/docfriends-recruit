package com.doc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableConfigurationProperties
public class DocFriendsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocFriendsApiApplication.class, args);
	}

}
