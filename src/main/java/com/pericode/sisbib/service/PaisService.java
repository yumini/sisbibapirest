package com.pericode.sisbib.service;

import com.pericode.sisbib.model.Pais;
import com.pericode.sisbib.repository.PaisRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dajoh
 */
@Service
public class PaisService {
    
    @Autowired
    PaisRepository paisRepository;
    
    //Metodo Service para Registar Pais
    public Pais guardar(Pais pais){
        return paisRepository.save(pais);
    }
    
    //Metodo Service para Buscar Todo los Paises
    public Collection<Pais> buscarTodos(){
        return paisRepository.findAll();
    }
    
    //Metodo Service para Buscar por Id
    public Pais buscarPorId(Integer id){
       return paisRepository.findOne(id);
    }
    
    //Metodo Sevice para Eliminar un Registro
    public void eliminar(Pais pais){
        paisRepository.delete(pais);
    }
    
}
