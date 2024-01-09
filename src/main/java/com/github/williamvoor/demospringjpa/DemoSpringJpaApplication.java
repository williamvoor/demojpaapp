package com.github.williamvoor.demospringjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class DemoSpringJpaApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoSpringJpaApplication.class, args);
  }
}
