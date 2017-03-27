package com.pericode.sisbib.repository;

import com.pericode.sisbib.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Integer>{
    
}
