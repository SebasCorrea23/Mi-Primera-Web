package EjemploIMC.Modelo.Dao;

import EjemploIMC.Controlador.Coordinador;
import EjemploIMC.Modelo.Conexion.ConexionDatos;
import EjemploIMC.Modelo.dto.PersonaDTO;

import java.util.ArrayList;

public class PersonaDao {
    private Coordinador miCoordinador;
    private ConexionDatos conexionDatos;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    public void setConexionDatos(ConexionDatos conexionDatos) {
        this.conexionDatos = conexionDatos;
    }

    public boolean registrarPersona(PersonaDTO persona) {
        try {
            return conexionDatos.guardarPersona(persona);
        } catch (Exception e) {
            System.err.println("Error al registrar persona: " + e.getMessage());
            return false;
        }
    }

    public PersonaDTO buscarPersona(String documento) {
        try {
            return conexionDatos.buscarPersona(documento);
        } catch (Exception e) {
            System.err.println("Error al buscar persona: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<PersonaDTO> consultarListaPersonas() {
        try {
            return conexionDatos.obtenerTodasLasPersonas();
        } catch (Exception e) {
            System.err.println("Error al consultar lista de personas: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public boolean existePersona(String documento) {
        try {
            return conexionDatos.existePersona(documento);
        } catch (Exception e) {
            System.err.println("Error al verificar existencia de persona: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarPersona(PersonaDTO persona) {
        try {
            return conexionDatos.actualizarPersona(persona);
        } catch (Exception e) {
            System.err.println("Error al actualizar persona: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarPersona(String documento) {
        try {
            return conexionDatos.eliminarPersona(documento);
        } catch (Exception e) {
            System.err.println("Error al eliminar persona: " + e.getMessage());
            return false;
        }
    }

    public int getTotalPersonas() {
        try {
            return conexionDatos.getTotalPersonas();
        } catch (Exception e) {
            System.err.println("Error al obtener total de personas: " + e.getMessage());
            return 0;
        }
    }
}
