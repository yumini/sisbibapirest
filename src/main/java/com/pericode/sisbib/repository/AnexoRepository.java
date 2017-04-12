package com.pericode.sisbib.repository;

import com.pericode.sisbib.model.Anexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnexoRepository extends JpaRepository<Anexo, Integer>{
    
}
