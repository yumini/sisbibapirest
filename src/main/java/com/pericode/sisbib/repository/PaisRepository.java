package com.pericode.sisbib.repository;

import com.pericode.sisbib.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer>{
    
}
