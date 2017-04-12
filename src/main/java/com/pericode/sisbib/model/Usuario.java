package com.pericode.sisbib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue
    private Integer idusuario;
    private String usuario;
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "idanexo")
    private Anexo idanexo;

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Anexo getIdanexo() {
        return idanexo;
    }

    public void setIdanexo(Anexo idanexo) {
        this.idanexo = idanexo;
    }
    
    
    
}
