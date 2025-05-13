package data;

import logica.Operador;

import java.util.HashMap;

public class ModeloDatos {

    HashMap<String, Operador> mapaOperadores;

    public ModeloDatos(){
        mapaOperadores=new HashMap<String, Operador>();
    }

    public void regitarOperador(Operador op){
        mapaOperadores.put(op.getDocumento(),op );
        System.out.println("Operador registrado: "+ op.getNombre());
    }

    public void consultarOperador(String documento){

        if (mapaOperadores.containsKey(documento)) {
            Operador operadorTemporal = mapaOperadores.get(documento);
            System.out.println("Documento: "+ operadorTemporal.getDocumento());
            System.out.println("Nombre: "+ operadorTemporal.getNombre());

        }
    }
}
