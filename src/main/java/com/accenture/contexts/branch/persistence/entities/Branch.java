package com.accenture.contexts.branch.persistence.entities;

import com.accenture.contexts.franchises.persistence.entities.Franchise;
import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
public class Branch {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @ManyToOne
  @JoinColumn(name = "franchise_id")
  private Franchise franchise;


}
