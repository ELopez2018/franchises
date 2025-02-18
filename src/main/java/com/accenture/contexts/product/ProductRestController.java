package com.accenture.contexts.product;

import com.accenture.contexts.branch.persistence.dtos.ProductDto;
import com.accenture.contexts.branch.persistence.entities.Branch;
import com.accenture.contexts.product.persistence.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductRestController {

  @Autowired
  ProductService productService;

  @PatchMapping("/{id}/{stock}")
  public ResponseEntity<Product> updateStock(@PathVariable Long id, @PathVariable int stock) {
    Product updatedProduct = productService.updateStock(id, stock);
    return ResponseEntity.ok(updatedProduct);
  }

  @PostMapping("/actualizar/name")
  public ResponseEntity<?> UpdateName(@RequestBody Product product, BindingResult result) {
    return ResponseEntity.ok( productService.saveName(product.getId(), product.getName()) );
  }

  @GetMapping("/top-stock/{franchiseId}")
  public ResponseEntity<List<ProductDto>> getTopStockProductsByFranchise(@PathVariable Long franchiseId) {
    List<ProductDto> products = productService.getTopStockProductsByFranchise(franchiseId);
    return ResponseEntity.ok(products);
  }
}
