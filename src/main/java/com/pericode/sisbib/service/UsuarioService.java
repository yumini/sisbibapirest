package com.pericode.sisbib.service;

import com.pericode.sisbib.model.Usuario;
import com.pericode.sisbib.repository.UsuarioRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    //Metodo Service para Registar Usuario
    public Usuario guardar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    
    //Metodo Service para Buscar Todo los Usuarioes
    public Collection<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }
    
    //Metodo Service para Buscar por Id
    public Usuario buscarPorId(Integer id){
       return usuarioRepository.findOne(id);
    }
    
    //Metodo Sevice para Eliminar un Registro
    public void eliminar(Usuario usuario){
        usuarioRepository.delete(usuario);
    }
    
}
