package logica;

public class Persona {

    private String nombre;
    private int edad;
    private double peso;
    private double talla;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }


    public double getTalla() {
        return talla;
    }
    public void setTalla(double talla) {
        this.talla = talla;
    }


    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }


    public Persona(String nombre, int edad, double peso, double talla) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.talla = talla;
    }


}
