package com.github.williamvoor.demospringjpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "a320", schema = "public")
public class A320 extends Plane {

  @Column
  private String softwareVersion;
}
