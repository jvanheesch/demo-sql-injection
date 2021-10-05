package com.github.jvanheesch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {
    @Autowired
    private AuthorRepository authorRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void setup() {
        Author gamma = new Author();
        gamma.setName("Gamma");
        authorRepository.save(gamma);

        Author bloch = new Author();
        bloch.setName("Bloch");
        authorRepository.save(bloch);
    }
}
