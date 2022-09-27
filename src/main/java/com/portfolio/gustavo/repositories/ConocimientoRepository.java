package com.portfolio.gustavo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.gustavo.models.ConocimientoModel;

@Repository
public interface ConocimientoRepository extends CrudRepository<ConocimientoModel,Long>{

}
