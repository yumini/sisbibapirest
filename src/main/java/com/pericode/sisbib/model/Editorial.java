/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pericode.sisbib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Editorial {
    @Id
    @GeneratedValue
    private Integer ideditorial;
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "idpais")
    private Pais idpais;  

    public Integer getIdeditorial() {
        return ideditorial;
    }

    public void setIdeditorial(Integer ideditorial) {
        this.ideditorial = ideditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getIdpais() {
        return idpais;
    }

    public void setIdpais(Pais idpais) {
        this.idpais = idpais;
    }
    
}
