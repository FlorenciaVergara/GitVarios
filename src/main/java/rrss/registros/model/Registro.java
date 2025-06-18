package rrss.registros.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Registro {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private String nombre;
    private String distrito;

    @ManyToOne
    @JoinColumn(name = "tipo_registro", referencedColumnName = "nombre")
    private TipoRegistro tipoRegistro;

    public Registro() {
    }

    public Registro(Long id, Integer numero, String nombre, String distrito, TipoRegistro tipoRegistro) {
        this.id = id;
        this.numero = numero;
        this.nombre = nombre;
        this.distrito = distrito;
        this.tipoRegistro = tipoRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    } 

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public TipoRegistro getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(TipoRegistro tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

}
