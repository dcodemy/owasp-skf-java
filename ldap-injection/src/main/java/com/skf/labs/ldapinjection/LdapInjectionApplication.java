package com.skf.labs.ldapinjection;

import java.io.IOException;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class LdapInjectionApplication {

	public static void main(String[] args) throws IOException, InterruptedException  {
		SpringApplication.run(LdapInjectionApplication.class, args);
	}

	@Bean
    ApplicationRunner applicationRunner(Environment environment) {
        return args -> {
            LdapInjectionModel.init(environment.getProperty("init.command"));
        };
    }
}
