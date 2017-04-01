package com.pericode.sisbib.service;

import com.pericode.sisbib.model.Materia;
import com.pericode.sisbib.repository.MateriaRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaService {
    
    @Autowired
    MateriaRepository materiaRepository;
    
    //Metodo Service para Registar Materia
    public Materia guardar(Materia materia){
        return materiaRepository.save(materia);
    }
    
    //Metodo Service para Buscar Todo las Materias
    public Collection<Materia> buscarTodos(){
        return materiaRepository.findAll();
    }
    
    //Metodo Service para Buscar por Id
    public Materia buscarPorId(Integer id){
       return materiaRepository.findOne(id);
    }
    
    //Metodo Sevice para Eliminar un Registro
    public void eliminar(Materia materia){
        materiaRepository.delete(materia);
    }
    
}