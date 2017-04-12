package com.pericode.sisbib.service;

import com.pericode.sisbib.model.Anexo;
import com.pericode.sisbib.repository.AnexoRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnexoService {
    
    @Autowired
    AnexoRepository anexoRepository;
    
    //Metodo Service para Registar Anexo
    public Anexo guardar(Anexo anexo){
        return anexoRepository.save(anexo);
    }
    
    //Metodo Service para Buscar Todo los Anexoes
    public Collection<Anexo> buscarTodos(){
        return anexoRepository.findAll();
    }
    
    //Metodo Service para Buscar por Id
    public Anexo buscarPorId(Integer id){
       return anexoRepository.findOne(id);
    }
    
    //Metodo Sevice para Eliminar un Registro
    public void eliminar(Anexo anexo){
        anexoRepository.delete(anexo);
    }
    
}
