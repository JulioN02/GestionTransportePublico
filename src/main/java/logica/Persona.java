package logica;

import controladoras.baseIdentificacion;

public class Persona extends baseIdentificacion{
    //Esta clase es la clase base para Conductor y Pasajeros
    
    protected int Cedula;
    protected String nombre;

    public Persona() {
    }

    public Persona(int Cedula, String nombre) {
        this.Cedula = Cedula;
        this.nombre = nombre;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "Cedula=" + Cedula + ", nombre=" + nombre + '}';
    }
}
