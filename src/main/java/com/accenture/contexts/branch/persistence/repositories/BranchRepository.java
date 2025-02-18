package com.accenture.contexts.branch.persistence.repositories;

import com.accenture.contexts.branch.persistence.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
