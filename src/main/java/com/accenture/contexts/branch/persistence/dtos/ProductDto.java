package com.accenture.contexts.branch.persistence.dtos;

import com.accenture.contexts.branch.persistence.entities.Branch;
import com.accenture.contexts.product.persistence.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
  private Branch branch;
  private Product product;
  private Long id;
  private String name;
  private int stock;
  private String branchName;

  public ProductDto(Long id, String name, int stock, String name1) {
    this.id = id;
    this.name = name;
    this.stock = stock;
    this.branchName = name1;
  }

}
