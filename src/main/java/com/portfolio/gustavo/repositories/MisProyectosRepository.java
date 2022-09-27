package com.portfolio.gustavo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.gustavo.models.MisProyectosModel;

@Repository
public interface MisProyectosRepository extends CrudRepository<MisProyectosModel, Long> {

}
