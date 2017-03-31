package com.pericode.sisbib.controller;

import com.pericode.sisbib.model.Pais;
import com.pericode.sisbib.service.PaisService;
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
public class PaisController {
    
    @Autowired
    PaisService paisService;
    
    //controller Rest para Registar un Pais
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.POST, value = "/paises", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pais> registrarPais(@RequestBody Pais pais) {
        Pais paisRegistrado = paisService.guardar(pais);
        return new ResponseEntity<>(paisRegistrado, HttpStatus.CREATED);
    }

    //Controller Rest para Buscar Todo los paises
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/paises", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Pais>> buscarTodosPaises() {
        Collection<Pais> paisesTodos = paisService.buscarTodos();
        return new ResponseEntity<>(paisesTodos, HttpStatus.OK);

    }

    //Controler Rest para Buscar Pais por Id
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/paises/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pais> buscarPaisPorId(@PathVariable Integer id) {
        Pais pais = paisService.buscarPorId(id);
        return new ResponseEntity<>(pais, HttpStatus.OK);

    }

    //Controller Rest para Eliminar un Registro de Pais
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.DELETE, value = "/paises/{id}")
    public ResponseEntity<Collection<Pais>> excluirPais(@PathVariable Integer id) {
        Pais paisEncontrado = paisService.buscarPorId(id);
        if (paisEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        paisService.eliminar(paisEncontrado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Controller Rest para actualizar un Registro de pais
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.PUT, value = "/paises", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pais> modificarPais(@RequestBody Pais pais) {
        Pais paisModificado = paisService.guardar(pais);
        return new ResponseEntity<>(paisModificado, HttpStatus.OK);

    }
    
}