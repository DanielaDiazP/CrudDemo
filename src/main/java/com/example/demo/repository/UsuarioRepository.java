package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Usuario;

@Repository
public class UsuarioRepository {

	List<Usuario> usuarios;

	public UsuarioRepository() {

		Usuario usr1 = new Usuario("Julio", 20);
		Usuario usr2 = new Usuario("Pedro", 21);
		Usuario usr3 = new Usuario("Ernan", 22);
		Usuario usr4 = new Usuario("Mario", 23);
		Usuario usr5 = new Usuario("Andres", 24);

		usuarios = new ArrayList<Usuario>();

		usuarios.add(usr1);
		usuarios.add(usr2);
		usuarios.add(usr3);
		usuarios.add(usr4);
		usuarios.add(usr5);
	}

	public String crearUsuario(Usuario usuario) {
		usuarios.add(usuario);
		return "El usuario se ha guardado correctamente";
	}

	public boolean eliminarUsuario(Usuario usuario) {
		usuarios.remove(usuario);
		return true;
	}

	public List<Usuario> listarUsuarios() {
		return this.usuarios;
	}

	public Usuario buscarUsuario(String nombre) {

		for (Usuario usuario : usuarios) {
			if (usuario.getNombre().equalsIgnoreCase(nombre))
				;
			return usuario;
		}

		return null;
	}

	public String modificarUsuario(int posicionUsuario, Usuario nuevoUsuario) {
		try {
			usuarios.set(posicionUsuario, nuevoUsuario);
			return "Usuario editado";
		} catch (Exception e) {
			return "Error al modificar";
		}
	}

	public int buscarPosicion(String usuario) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getNombre().equalsIgnoreCase(usuario)) {
				return i;
			}
		}
		return -1;
	}
}
