package com.accenture.contexts.branch.persistence.entities;

import com.accenture.contexts.franchises.persistence.entities.Franchise;
import com.accenture.contexts.product.persistence.entities.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Branch {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100, name = "name")
  private String name;

  @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<Product> products;

  @ManyToOne
  @JoinColumn(name = "franchise_id")
  @JsonBackReference
  private Franchise franchise;

}
