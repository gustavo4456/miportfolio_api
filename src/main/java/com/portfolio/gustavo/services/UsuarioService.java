package com.portfolio.gustavo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.gustavo.models.User;
import com.portfolio.gustavo.repositories.UserRepository;

@Service
public class UsuarioService {
	@Autowired
	UserRepository usuarioRepository;
	
	public ArrayList<User> obtenerUsuarios(){
		return (ArrayList<User>)usuarioRepository.findAll();
	}
	
	public User guardarUsuario(User usuario) {
		return usuarioRepository.save(usuario);
	}

	public Optional<User> obtenerUserId(Long idUsuario) {	
		return usuarioRepository.findById(idUsuario);
	}

	public void eliminarUsuario(Long idUsuario){
		usuarioRepository.deleteById(idUsuario);
	}
}
