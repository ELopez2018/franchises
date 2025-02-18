package com.accenture.contexts.franchises.persistence.entities;

import com.accenture.contexts.branch.persistence.entities.Branch;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Franchise {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, name = "name")
  private String name;

  @OneToMany(mappedBy = "franchise", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Branch> branches;
}
