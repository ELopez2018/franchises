package com.accenture.contexts.franchises;

import com.accenture.contexts.branch.persistence.entities.Branch;
import com.accenture.contexts.franchises.persistence.entities.Franchise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/franquicia")
public class FranchiseRestController {

  @Autowired
  FranchiseService franchiseService;

  @GetMapping
  public ResponseEntity<?> getAll() {
    return ResponseEntity.status(HttpStatus.OK).body(franchiseService.findAll());
  }

  @PostMapping
  public ResponseEntity<?> post(@RequestBody Franchise franchise, BindingResult result) {
    return ResponseEntity.ok(franchiseService.save(franchise));
  }

  @PostMapping("/agregar-sucursal")
  public ResponseEntity<?> addBranch(@RequestBody Branch branch, BindingResult result) {
    return ResponseEntity.ok(franchiseService.addBranch(branch));
  }

  @PutMapping
  public ResponseEntity<?> update(@RequestBody Franchise franchise, BindingResult result) {
    return ResponseEntity.ok(franchiseService.save(franchise));
  }
}
