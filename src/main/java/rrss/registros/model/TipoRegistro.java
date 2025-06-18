package rrss.registros.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TipoRegistro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private boolean requiereAutonumeracion;
    private Integer valorInicial;

    public TipoRegistro() {
    }   

    public TipoRegistro(Long id, String nombre, boolean requiereAutonumeracion) {
        this.id = id;
        this.nombre = nombre;
        this.requiereAutonumeracion = requiereAutonumeracion;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public boolean isRequiereAutonumeracion() {
        return requiereAutonumeracion;
    }

    public void setRequiereAutonumeracion(boolean requiereAutonumeracion) {
        this.requiereAutonumeracion = requiereAutonumeracion;
    }

    public Integer getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Integer valorInicial) {
        this.valorInicial = valorInicial;
    }
}
