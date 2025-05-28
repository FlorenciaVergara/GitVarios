package ejemplo.ejemploapi.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class Persona {
    @Id
    private String nombre;
    private int edad;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    private String color;

    // Constructor por defecto
    public Persona() {
    }

    //getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }   

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
