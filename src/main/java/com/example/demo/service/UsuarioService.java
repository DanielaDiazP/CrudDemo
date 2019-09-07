package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public String crearUsuario(String nombre, String edad) {
		try {
			if(edad.equals("") || nombre.equals("")) {
				return "Debe ingresar los datos completos";
			} else {
				return usuarioRepository.crearUsuario(new Usuario(nombre, Integer.parseInt(edad)));
			}
		} catch(Exception e) {
			return "La edad debe ser obligatoria y un número entero";
		}
	}

	public boolean eliminarUsuario(String nombreUsuario) {
		Usuario usuario = usuarioRepository.buscarUsuario(nombreUsuario);
		if (usuario == null) {
			return false;
		} else {
			return usuarioRepository.eliminarUsuario(usuario);
		}
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.listarUsuarios();
	}

	public Object buscarUsuario(String nombre) {
		Usuario usuario= usuarioRepository.buscarUsuario(nombre);
		if(usuario == null) {
			return "El usuario no está en la lista";
		} else {
			return usuario;
		}
	}
	
	public String modificarUsuario(String nombreUsuario, String nombreNuevo, String edad) {
		try {
			int pos = usuarioRepository.buscarPosicion(nombreUsuario);
			if (pos == -1) {
				return "El usuario no existe";
			}
			return usuarioRepository.modificarUsuario(pos, new Usuario(nombreNuevo, Integer.parseInt(edad)));
		} catch (Exception e) {
			return "No se pudo modificar, revisar los datos enviados";
		}
	}
}
