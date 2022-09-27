package com.portfolio.gustavo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.gustavo.models.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long>{
    
}
