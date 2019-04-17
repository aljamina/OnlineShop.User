package com.techprimers.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableJpaRepositories(basePackages = "com.techprimers.db.repository")
@SpringBootApplication
public class SpringBootMysqldbApplication {

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("123");
        System.out.println("pASSSWooord" + password);
        System.out.println("Compare 1 " + passwordEncoder.matches("123", password));
        System.out.println("Compare 2: " + passwordEncoder.matches("12345", password));
        SpringApplication.run(SpringBootMysqldbApplication.class, args);
    }
}
