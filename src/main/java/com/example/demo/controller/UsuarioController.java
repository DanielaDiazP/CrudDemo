package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(path = "/crear/{nombre}/{edad}", method = RequestMethod.POST)
	String crearUsuario(@PathVariable("nombre") String nombreUsuario, @PathVariable("edad") String edad) {

		return usuarioService.crearUsuario(nombreUsuario, edad);
	}

	@RequestMapping(path = "/eliminar/{nombre}", method = RequestMethod.DELETE)
	boolean eliminarUsuario(@PathParam("nombre") String usuario) {
		return usuarioService.eliminarUsuario(usuario);
	}

	@RequestMapping(path = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	List<Usuario> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}
	
	@RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object buscarUsuario(@PathVariable("nombre") String nombre) {
		return usuarioService.buscarUsuario(nombre);
	}

	@RequestMapping(path = "/modificar/{nombre}/{nombreNuevo}/{edad}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	public String modificaUsuario(@PathVariable("nombre") String nombreUsuario,
			@PathVariable("nombreNuevo") String nombreNuevo, @PathVariable("edad") String edad) {
		return usuarioService.modificarUsuario(nombreUsuario, nombreNuevo, edad);
	}
}
