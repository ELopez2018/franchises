package com.accenture.contexts.branch;

import com.accenture.contexts.branch.persistence.dtos.ProductDto;
import com.accenture.contexts.branch.persistence.entities.Branch;
import com.accenture.contexts.franchises.persistence.entities.Franchise;
import com.accenture.contexts.product.persistence.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sucursal")
public class BranchRestController {

  @Autowired
  BranchService branchService;

  @PostMapping("/agregar-producto")
  public ResponseEntity<?> addProduct(@RequestBody Product product, BindingResult result) {
    return ResponseEntity.ok(branchService.addProduct(product));
  }

  @PostMapping("/actualizar/name")
  public ResponseEntity<?> UpdateName(@RequestBody Branch branch, BindingResult result) {
    return ResponseEntity.ok( branchService.saveName(branch.getId(), branch.getName()) );
  }

  @DeleteMapping("/eliminar-producto")
  public ResponseEntity<?> deleteProduct(@RequestBody ProductDto productDto, BindingResult result) {
    branchService.deleteProductAtBranch(productDto);
    return ResponseEntity.ok("Producto eliminado");
  }
}
