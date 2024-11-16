package logica;

import controladoras.baseIdentificacion;

public abstract class Transporte extends baseIdentificacion{
    //Clase base para tipos especificos de transporte
    protected String placa;
    protected int capacidad;

    public Transporte() {
    }

    public Transporte(String placa, int capacidad) {
        this.placa = placa;
        this.capacidad = capacidad;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

}
