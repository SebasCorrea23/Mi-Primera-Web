package logica;

public class Operador {

    private String documento;
    private String Nombre;
    private double sueldo;
    private int antiguedad;
    private double sueldoNuevo;
    private double aumento;


    public Operador(){
        Nombre="default";
    }

    public Operador(String documento, String nombre, double sueldo, int antiguedad, double sueldoNuevo, double aumento) {
        this.documento = documento;
        this.Nombre = nombre;
        this.sueldo = sueldo;
        this.antiguedad = antiguedad;
        this.sueldoNuevo = sueldoNuevo;
        this.aumento = aumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public double getSueldoNuevo(double aumento) {
        return sueldoNuevo;
    }

    public void setSueldoNuevo(double sueldoNuevo) {
        this.sueldoNuevo = sueldoNuevo;
    }

    public double getAumento() {
        return aumento;
    }

    public void setAumento(double aumento) {
        this.aumento = aumento;
    }
}
