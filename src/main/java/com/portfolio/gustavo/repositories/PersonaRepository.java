package com.portfolio.gustavo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.gustavo.models.PersonaModel;

@Repository
public interface PersonaRepository extends CrudRepository<PersonaModel, Long>{

}
