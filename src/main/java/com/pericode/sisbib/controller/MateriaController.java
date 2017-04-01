
package com.pericode.sisbib.controller;

import com.pericode.sisbib.model.Materia;
import com.pericode.sisbib.service.MateriaService;
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
public class MateriaController {
    
    @Autowired
    MateriaService materiaService;
    
    //controller Rest para Registar una materia
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.POST, value = "/materias", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Materia> registrarMateria(@RequestBody Materia materia) {
        Materia materiaRegistrado = materiaService.guardar(materia);
        return new ResponseEntity<>(materiaRegistrado, HttpStatus.CREATED);
    }

    //Controller Rest para Buscar Todo las materias
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/materias", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Materia>> buscarTodosMaterias() {
        Collection<Materia> materiasTodos = materiaService.buscarTodos();
        return new ResponseEntity<>(materiasTodos, HttpStatus.OK);

    }

    //Controler Rest para Buscar Pais por Id
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/materias/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Materia> buscarMateriaPorId(@PathVariable Integer id) {
        Materia materia = materiaService.buscarPorId(id);
        return new ResponseEntity<>(materia, HttpStatus.OK);

    }

    //Controller Rest para Eliminar un Registro de Materia
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.DELETE, value = "/materias/{id}")
    public ResponseEntity<Collection<Materia>> excluirPais(@PathVariable Integer id) {
        Materia materiaEncontrado = materiaService.buscarPorId(id);
        if (materiaEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        materiaService.eliminar(materiaEncontrado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Controller Rest para actualizar un Registro de materia
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.PUT, value = "/materias", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Materia> modificarPais(@RequestBody Materia materia) {
        Materia materiaModificado = materiaService.guardar(materia);
        return new ResponseEntity<>(materiaModificado, HttpStatus.OK);

    }
    
}