package com.accenture.contexts.product;

import com.accenture.contexts.branch.persistence.dtos.ProductDto;
import com.accenture.contexts.branch.persistence.entities.Branch;
import com.accenture.contexts.product.persistence.entities.Product;
import com.accenture.contexts.product.persistence.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;

  public Product updateStock(Long id, int stock) {
    Product product = productRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));

    product.setStock(stock);
    return productRepository.save(product);
  }

  public List<ProductDto> getTopStockProductsByFranchise(Long franchiseId) {
    List<Product> products = productRepository.findTopStockProductByBranchInFranchise(franchiseId);
    return products.stream()
            .map(product -> new ProductDto(
                    product.getId(),
                    product.getName(),
                    product.getStock(),
                    product.getBranch().getName()
            ))
            .collect(Collectors.toList());
  }

  public Product saveName(Long id, String name) {
    Product product = productRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
    product.setName(name);
    return productRepository.save(product);
  }
}
