package com.pericode.sisbib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Anexo {
    
    @Id
    @GeneratedValue
    private Integer idanexo;
    private String nombre;
    private String ape_pat;
    private String ape_mat;

    public Integer getIdanexo() {
        return idanexo;
    }

    public void setIdanexo(Integer idanexo) {
        this.idanexo = idanexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe_pat() {
        return ape_pat;
    }

    public void setApe_pat(String ape_pat) {
        this.ape_pat = ape_pat;
    }

    public String getApe_mat() {
        return ape_mat;
    }

    public void setApe_mat(String ape_mat) {
        this.ape_mat = ape_mat;
    }
    
    
    
}
