package com.accenture.contexts.product.persistence.entities;

import com.accenture.contexts.branch.persistence.entities.Branch;
import jakarta.persistence.*;


@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, name = "name")
  private String name;

  @Column(nullable = false, name = "stock")
  private int stock;

  @ManyToOne
  @JoinColumn(name = "branch_id")
  private Branch branch;
}
