package com.github.williamvoor.demospringjpa.model;

import static jakarta.persistence.FetchType.LAZY;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Formula;

@ToString(of = {"id", "description", "nbrOfSeats"})
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "plane", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Entity
public class Plane {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String description;

  @Column
  private int nbrOfSeats;

  @Formula(
      """
      (SELECT EXISTS (SELECT p.id FROM plane p WHERE p.nbr_of_seats > 100))
      """)
  @Basic(fetch = LAZY)
  private Boolean large = false;
}
