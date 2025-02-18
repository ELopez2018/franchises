package com.accenture.contexts.franchises;

import com.accenture.contexts.branch.persistence.entities.Branch;
import com.accenture.contexts.branch.persistence.repositories.BranchRepository;
import com.accenture.contexts.franchises.persistence.entities.Franchise;
import com.accenture.contexts.franchises.persistence.respositories.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranchiseService {

  @Autowired
  FranchiseRepository franchiseRepository;

  @Autowired
  BranchRepository branchRepository;

  public List<Franchise> findAll() {
    return franchiseRepository.findAll();
  }

  public Franchise save(Franchise franchise) {
    return franchiseRepository.save(franchise);
  }

  public Branch addBranch(Branch branch) {
    return branchRepository.save(branch);
  }
}
