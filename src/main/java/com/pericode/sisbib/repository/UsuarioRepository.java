package com.pericode.sisbib.repository;

import com.pericode.sisbib.model.Usuario;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}