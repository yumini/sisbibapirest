
package com.pericode.sisbib.controller;

import com.pericode.sisbib.model.Editorial;
import com.pericode.sisbib.service.EditorialService;
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
public class EditorialController {
     @Autowired
    EditorialService editorialService;

    //controller Rest para Registar Editorial
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.POST, value = "/editoriales", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Editorial> registrarEditorial(@RequestBody Editorial editorial) {
        Editorial editorialRegistrado = editorialService.guardar(editorial);
        return new ResponseEntity<>(editorialRegistrado, HttpStatus.CREATED);
    }

    //Controller Rest para Buscar Todo Editorial
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/editoriales", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Editorial>> buscarTodosEditorial() {
        Collection<Editorial> editorialesTodos = editorialService.buscarTodos();
        return new ResponseEntity<>(editorialesTodos, HttpStatus.OK);

    }

    //Controler Rest para Buscar Editorial por Id
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/editoriales/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Editorial> buscarEditorialPorId(@PathVariable Integer id) {
        Editorial editorial = editorialService.buscarPorId(id);
        return new ResponseEntity<>(editorial, HttpStatus.OK);

    }

    //Controller Rest para Eliminar un Registro Editorial
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.DELETE, value = "/editoriales/{id}")
    public ResponseEntity<Collection<Editorial>> excluirAutor(@PathVariable Integer id) {
        Editorial editorialEncontrado = editorialService.buscarPorId(id);
        if (editorialEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        editorialService.eliminar(editorialEncontrado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Controller Rest para actualizar un Registro de Editorial
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.PUT, value = "/editoriales", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Editorial> modificarAutor(@RequestBody Editorial editorial) {
        Editorial editorialModificado = editorialService.guardar(editorial);
        return new ResponseEntity<>(editorialModificado, HttpStatus.OK);

    }
}
