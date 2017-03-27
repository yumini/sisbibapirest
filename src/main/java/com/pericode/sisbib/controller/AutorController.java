package com.pericode.sisbib.controller;

import com.pericode.sisbib.model.Autor;
import com.pericode.sisbib.service.AutorService;
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
public class AutorController {

    @Autowired
    AutorService autorService;

    //controller Rest para Registar un Autor
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.POST, value = "/autores", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Autor> registrarAutor(@RequestBody Autor autor) {
        Autor autorRegistrado = autorService.guardar(autor);
        return new ResponseEntity<>(autorRegistrado, HttpStatus.CREATED);
    }

    //Controller Rest para Buscar Todo los autores
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/autores", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Autor>> buscarTodosAutores() {
        Collection<Autor> autoresTodos = autorService.buscarTodos();
        return new ResponseEntity<>(autoresTodos, HttpStatus.OK);

    }

    //Controler Rest para Buscar Autor por Id
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/autores/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Autor> buscarAutorPorId(@PathVariable Integer id) {
        Autor autor = autorService.buscarPorId(id);
        return new ResponseEntity<>(autor, HttpStatus.OK);

    }

    //Controller Rest para Eliminar un Registro de Autor
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.DELETE, value = "/autores/{id}")
    public ResponseEntity<Collection<Autor>> excluirAutor(@PathVariable Integer id) {
        Autor autorEncontrado = autorService.buscarPorId(id);
        if (autorEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        autorService.eliminar(autorEncontrado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Controller Rest para actualizar un Registro de autor
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.PUT, value = "/autores", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Autor> modificarAutor(@RequestBody Autor autor) {
        Autor autorModificado = autorService.guardar(autor);
        return new ResponseEntity<>(autorModificado, HttpStatus.OK);

    }

}
