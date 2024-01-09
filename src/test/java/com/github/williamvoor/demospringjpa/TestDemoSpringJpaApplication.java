package com.github.williamvoor.demospringjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TestConfiguration(proxyBeanMethods = false)
public class TestDemoSpringJpaApplication {

  public static void main(String[] args) {
    SpringApplication.from(DemoSpringJpaApplication::main).with(TestDemoSpringJpaApplication.class).run(args);
  }
}
