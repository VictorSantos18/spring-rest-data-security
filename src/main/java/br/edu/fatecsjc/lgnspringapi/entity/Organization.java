package br.edu.fatecsjc.lgnspringapi.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "organization")
public class Organization {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String country;

  @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
  private List<Marathon> marathons;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}