package com.accenture.contexts.franchises.persistence.respositories;

import com.accenture.contexts.franchises.persistence.entities.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<Franchise, Long> {
}
