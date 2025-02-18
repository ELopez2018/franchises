package com.accenture.contexts.branch;

import com.accenture.contexts.branch.persistence.dtos.ProductDto;
import com.accenture.contexts.branch.persistence.entities.Branch;
import com.accenture.contexts.branch.persistence.repositories.BranchRepository;
import com.accenture.contexts.franchises.persistence.respositories.FranchiseRepository;
import com.accenture.contexts.product.ProductService;
import com.accenture.contexts.product.persistence.entities.Product;
import com.accenture.contexts.product.persistence.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BranchService {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  BranchRepository branchRepository;

  public Product addProduct(Product product) {
    return productRepository.save(product);
  }

  public void deleteProductAtBranch(ProductDto productDto) {
     productRepository.deleteBySucursalIdAndProductoId(productDto.getBranch().getId(), productDto.getProduct().getId());

  }

  public Branch saveName(Long id, String name) {
    Branch branch = branchRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sucursal no encontrada"));
    branch.setName(name);
    return branchRepository.save(branch);
  }

}
