package rrss.registros.dto;

public class RegistroDTO {
    private Integer numero; // puede venir null
    private String nombre;
    private String distrito;
    private String tipo;

    public RegistroDTO() {
    }

    public RegistroDTO(String nombre, String tipo, Integer numero) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

}

