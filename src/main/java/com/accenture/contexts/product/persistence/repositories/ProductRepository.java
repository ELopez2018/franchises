package com.accenture.contexts.product.persistence.repositories;

import com.accenture.contexts.product.persistence.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository  extends CrudRepository<Product, Long> {
}
