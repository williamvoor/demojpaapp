package com.github.williamvoor.demospringjpa.dao;

import com.github.williamvoor.demospringjpa.model.A320;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface A320DAO extends JpaRepository<A320, Long> {

  List<A320> findByDescriptionLikeIgnoreCase(String description);
}
