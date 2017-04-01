/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pericode.sisbib.service;

import com.pericode.sisbib.model.Editorial;
import com.pericode.sisbib.repository.EditorialRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EditorialService {
    @Autowired
    EditorialRepository editorialRepository;
    
    //Metodo Service para Registar Editorial
    public Editorial guardar(Editorial editorial){
        return editorialRepository.save(editorial);
    }
    
    //Metodo Service para Buscar Todo Editoriales
    public Collection<Editorial> buscarTodos(){
        return editorialRepository.findAll();
    }
    
    //Metodo Service para Buscar por Id
    public Editorial buscarPorId(Integer id){
       return editorialRepository.findOne(id);
    }
    
    //Metodo Sevice para Eliminar un Registro
    public void eliminar(Editorial editorial){
        editorialRepository.delete(editorial);
    } 
}
