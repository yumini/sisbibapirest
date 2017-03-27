
package com.pericode.sisbib.service;

import com.pericode.sisbib.model.Autor;
import com.pericode.sisbib.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class AutorService {
    
    @Autowired
    AutorRepository autorRepository;
    
    //Metodo Service para Registar Autor
    public Autor guardar(Autor autor){
        return autorRepository.save(autor);
    }
    
    //Metodo Service para Buscar Todo los Autores
    public Collection<Autor> buscarTodos(){
        return autorRepository.findAll();
    }
    
    //Metodo Service para Buscar por Id
    public Autor buscarPorId(Integer id){
       return autorRepository.findOne(id);
    }
    
    //Metodo Sevice para Eliminar un Registro
    public void eliminar(Autor autor){
        autorRepository.delete(autor);
    }
    
}
