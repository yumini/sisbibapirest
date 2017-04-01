package com.pericode.sisbib.repository;

import com.pericode.sisbib.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial,Integer>{
    
}
