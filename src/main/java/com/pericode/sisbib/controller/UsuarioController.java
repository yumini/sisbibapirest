package com.pericode.sisbib.controller;

import com.pericode.sisbib.model.Usuario;
import com.pericode.sisbib.service.UsuarioService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

    //controller Rest para Registar un Usuario
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.POST, value = "/usuarios", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioRegistrado = usuarioService.guardar(usuario);
        return new ResponseEntity<>(usuarioRegistrado, HttpStatus.CREATED);
    }

    //Controller Rest para Buscar Todo los usuarioes
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Usuario>> buscarTodosUsuarios() {
        Collection<Usuario> usuarioesTodos = usuarioService.buscarTodos();
        return new ResponseEntity<>(usuarioesTodos, HttpStatus.OK);

    }

    //Controler Rest para Buscar Usuario por Id
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/usuarios/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Integer id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);

    }

    //Controller Rest para Eliminar un Registro de Usuario
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.DELETE, value = "/usuarios/{id}")
    public ResponseEntity<Collection<Usuario>> excluirUsuario(@PathVariable Integer id) {
        Usuario usuarioEncontrado = usuarioService.buscarPorId(id);
        if (usuarioEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usuarioService.eliminar(usuarioEncontrado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Controller Rest para actualizar un Registro de usuario
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.PUT, value = "/usuarios", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> modificarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioModificado = usuarioService.guardar(usuario);
        return new ResponseEntity<>(usuarioModificado, HttpStatus.OK);

    }
    
}
