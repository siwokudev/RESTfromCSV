package com.tcs.csvloader.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import com.tcs.csvloader.model.Usuario;

public class FileHandler {
	
	static Logger log = LoggerFactory.getLogger(FileHandler.class);
	
	public static List<Usuario> read(){
		
		List<Usuario> usuarios = new ArrayList<>();
		
		try {
			File file = ResourceUtils.getFile("classpath:users.csv");
			
			Scanner scanner = new Scanner(file); 
			boolean headerIgnored = false;
		    while (scanner.hasNextLine()) {
		    	if(!headerIgnored) {
		    		headerIgnored = true;
		    		scanner.nextLine();
		    	} else {
		    		String[] usuarioRaw = scanner.nextLine().split(",");
		    		Usuario usuario = new Usuario();
		    		usuario.setId(usuarioRaw[0]);
		    		usuario.setNombre(usuarioRaw[1]);
		    		usuario.setApellido(usuarioRaw[2]);
		    		usuario.setEdad(usuarioRaw[3]);
		    		usuario.setTelefono(usuarioRaw[4]);
		    		usuario.setDireccion(usuarioRaw[5]);
		    		
		    		usuarios.add(usuario);
		    	}
		    }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//usuarios.stream().forEach(System.out::println);
		log.info("archivo leido");
		
		return usuarios;
	}
	
	public static void write(List<Usuario> fileContent) {
		//TO-DO
	}
}
