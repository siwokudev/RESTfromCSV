package com.tcs.csvloader.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.tcs.csvloader.model.Usuario;
import com.tcs.csvloader.util.FileHandler;

@Repository
public class UsuarioRepo {
	public List<Usuario> getAllUsers(){
		return FileHandler.read();
	}
	
	public Usuario getUserById(String id){
		final List<Usuario> usuarios = FileHandler.read();

		List<Usuario> list = usuarios.stream().filter(usuario -> usuario.getId().equals(id))
		.collect(Collectors.toList());
		
		if(list.size() == 1) {
			return list.get(0);
		} else {
			final Usuario usuarioObj = new Usuario();
			usuarioObj.setId("-1");
			return usuarioObj;
		}
	}
}
