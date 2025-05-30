package com.miempresa.proyecto.model;

import jakarta.persistence.*;

@Entity
public class Registro {

    @Id
    private Integer codigo;
    private String cuitResponsable;

    public Registro() {}

    public Registro(Integer codigo, String cuitResponsable) {
        this.codigo = codigo;
        this.cuitResponsable = cuitResponsable;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCuitResponsable() {
        return cuitResponsable;
    }
    public void setCuitResponsable(String cuitResponsable) {
        this.cuitResponsable = cuitResponsable;
    }
}
