package com.pericode.sisbib.controller;

import com.pericode.sisbib.model.Anexo;
import com.pericode.sisbib.service.AnexoService;
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
public class AnexoController {
    
    @Autowired
    AnexoService anexoService;

    //controller Rest para Registar un Anexo
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.POST, value = "/anexos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Anexo> registrarAnexo(@RequestBody Anexo anexo) {
        Anexo anexoRegistrado = anexoService.guardar(anexo);
        return new ResponseEntity<>(anexoRegistrado, HttpStatus.CREATED);
    }

    //Controller Rest para Buscar Todo los anexoes
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/anexos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Anexo>> buscarTodosAnexoes() {
        Collection<Anexo> anexoesTodos = anexoService.buscarTodos();
        return new ResponseEntity<>(anexoesTodos, HttpStatus.OK);

    }

    //Controler Rest para Buscar Anexo por Id
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/anexos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Anexo> buscarAnexoPorId(@PathVariable Integer id) {
        Anexo anexo = anexoService.buscarPorId(id);
        return new ResponseEntity<>(anexo, HttpStatus.OK);

    }

    //Controller Rest para Eliminar un Registro de Anexo
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.DELETE, value = "/anexos/{id}")
    public ResponseEntity<Collection<Anexo>> excluirAnexo(@PathVariable Integer id) {
        Anexo anexoEncontrado = anexoService.buscarPorId(id);
        if (anexoEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        anexoService.eliminar(anexoEncontrado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Controller Rest para actualizar un Registro de anexo
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.PUT, value = "/anexos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Anexo> modificarAnexo(@RequestBody Anexo anexo) {
        Anexo anexoModificado = anexoService.guardar(anexo);
        return new ResponseEntity<>(anexoModificado, HttpStatus.OK);

    }
    
}
