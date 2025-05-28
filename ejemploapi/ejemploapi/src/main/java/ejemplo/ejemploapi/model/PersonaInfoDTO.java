package ejemplo.ejemploapi.model;

public class PersonaInfoDTO {
    private int edad;
    private String color;

    public PersonaInfoDTO(int edad, String color) {
        this.edad = edad;
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public String getColor() {
        return color;
    }

}
