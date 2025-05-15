package data;

import logica.Persona;
import java.util.ArrayList;

public class ModeloDatos {

    private ArrayList<Persona> listaPersonas;

    public ModeloDatos() {
        listaPersonas = new ArrayList<>();
    }

    public void registrarPersona(Persona p) {
        listaPersonas.add(p);
        System.out.println("Persona registrada: " + p.getNombre());
    }

    public void agregarPersona(Persona p) {
        listaPersonas.add(p);
        System.out.println("Persona registrada: " + p.getNombre());
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }
}
