package logica;

public class Procesos {

    public double calcularIMC(Persona p) {
        // Fórmula del IMC: peso / (talla^2)
        return p.getPeso() / (p.getTalla() * p.getTalla());
    }

    public String obtenerDiagnostico(double imc) {
        if (imc < 18) {
            return "Anorexia";
        } else if (imc >= 18 && imc < 20) {
            return "Delgadez";
        } else if (imc >= 20 && imc < 27) {
            return "Normalidad";
        } else if (imc >= 27 && imc < 30) {
            return "Obesidad (grado 1)";
        } else if (imc >= 30 && imc < 35) {
            return "Obesidad (grado 2)";
        } else if (imc >= 35 && imc < 40) {
            return "Obesidad (grado 3)";
        } else {
            return "Obesidad mórbida";
        }
    }
}
