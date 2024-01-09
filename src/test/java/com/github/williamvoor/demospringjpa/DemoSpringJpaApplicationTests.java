package com.github.williamvoor.demospringjpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.williamvoor.demospringjpa.dao.A320DAO;
import com.github.williamvoor.demospringjpa.model.A320;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.flywaydb.test.FlywayTestExecutionListener;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.testcontainers.containers.PostgreSQLContainer;

@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
    FlywayTestExecutionListener.class })
@SpringBootTest(classes = TestDemoSpringJpaApplication.class)
@FlywayTest(invokeCleanDB = false)
class DemoSpringJpaApplicationTests {

  @ClassRule
  public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:11.1").withDatabaseName(
      "integration-tests-db").withUsername("sa").withPassword("sa");

  @Autowired
  private A320DAO dao;

  @Autowired
  private EntityManager entityManager;

  @Test
  void createAndUpdatePlane() {

    A320 referenceById = dao.getReferenceById(1L);

    referenceById.setSoftwareVersion("2.0");

    entityManager.flush();
    entityManager.clear();

    List<A320> airbusA320 = dao.findByDescriptionLikeIgnoreCase("Airbus A320");
    assertFalse(airbusA320.isEmpty());
    assertEquals(1, airbusA320.size());
    A320 a320 = airbusA320.get(0);
    assertEquals("2.0", a320.getSoftwareVersion());
    assertTrue(a320.getLarge());
  }
}