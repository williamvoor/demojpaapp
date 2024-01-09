package com.github.williamvoor.demospringjpa.dao;

import com.github.williamvoor.demospringjpa.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneDAO extends JpaRepository<Plane, Long> {


}
