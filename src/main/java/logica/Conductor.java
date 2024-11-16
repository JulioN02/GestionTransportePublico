package logica;
import java.util.ArrayList;
import java.util.List;

public class Conductor extends Persona{
    private String licencia;
    private List<Ruta>rutasAsignadas; //Muchos a Muchos

    public Conductor() {
        super(); //Llamar al constructor de la clase Persona
        this.rutasAsignadas=new ArrayList<>(); //Inicializar la lista vacia
    }

    public Conductor(String licencia, List<Ruta> rutasAsignadas, int Cedula, String nombre) {
        super(Cedula, nombre);
        this.licencia = licencia;
        
        //Asegurarse de que rutasAsignadas nunca sea nulo
        this.rutasAsignadas=rutasAsignadas!=null ? rutasAsignadas : new ArrayList<>();
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public List<Ruta> getRutasAsignadas() {
        return rutasAsignadas;
    }

    public void setRutasAsignadas(List<Ruta> rutasAsignadas) {
        this.rutasAsignadas = rutasAsignadas;
    }
    
    public boolean estaDisponible(){
        return rutasAsignadas.isEmpty();
    }

    @Override
    public String toString() {
     return "Conductor: " +
                "\nCedula: " + getCedula() +
                "\nNombre: " + getNombre() +
                "\nLicencia: " + licencia +
                "\nRutas Asignadas: " + (rutasAsignadas.isEmpty() ? "Ninguna" : rutasAsignadas);
    }
    
}
