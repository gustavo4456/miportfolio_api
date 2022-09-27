package com.portfolio.gustavo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.gustavo.models.EducacionModel;

@Repository
public interface EducacionRepository extends CrudRepository<EducacionModel, Long>{

}
