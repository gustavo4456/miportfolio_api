package com.portfolio.gustavo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.gustavo.repositories.AuthorityRepository;

import com.portfolio.gustavo.models.Authority;

@Service
public class AuthorityService {
    @Autowired
	AuthorityRepository authorityRepository;
	
	public ArrayList<Authority> obtenerTodasAutoridades(){
		return (ArrayList<Authority>)authorityRepository.findAll();
	}

	
	public Optional<Authority> obtenerAutoridadPorId(Long idAuthority) {	
		return authorityRepository.findById(idAuthority);
	}

	//ELIMINAR
	public void eliminarAutoridad(Long idAuthority){
		authorityRepository.deleteById(idAuthority);
	}

    public Authority guardarAutoridad(Authority authority) {
		return authorityRepository.save(authority);
	}
}
