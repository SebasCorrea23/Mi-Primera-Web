package logica;

public class Procesos {

    double por;

    public String calcularSueldo(Operador miOpera1){
        System.out.println("Calculando Sueldo");
        double aumento=0;

        if (miOpera1.getSueldo()<500 && miOpera1.getAntiguedad()>=10) {
            por=0.2;

            aumento= miOpera1.getSueldo()+(miOpera1.getSueldo()*por);
            miOpera1.setSueldoNuevo(aumento);

        } else if (miOpera1.getSueldo()<500 && miOpera1.getAntiguedad()<10) {
            por=0.5;

            aumento= miOpera1.getSueldo()+(miOpera1.getSueldo()*por);
            miOpera1.setSueldoNuevo(aumento);
        }
        miOpera1.setAumento(por*100);

        return "Calculo Exitoso";
    }
}
