package com.accenture.contexts.product.persistence.repositories;

import com.accenture.contexts.product.persistence.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository  extends CrudRepository<Product, Long> {

  @Modifying
  @Query("DELETE FROM Product p WHERE p.branch.id = :sucursalId AND p.id = :productoId")
  void deleteBySucursalIdAndProductoId(@Param("sucursalId") Long sucursalId,
                                       @Param("productoId") Long productoId
                                        );


  @Query("""
        SELECT p FROM Product p
        WHERE p.stock = (
            SELECT MAX(p2.stock) FROM Product p2 WHERE p2.branch.franchise.id = :franchiseId AND p2.branch.id = p.branch.id
        ) 
        AND p.branch.franchise.id = :franchiseId
    """)
  List<Product> findTopStockProductByBranchInFranchise(@Param("franchiseId") Long franchiseId);


}
