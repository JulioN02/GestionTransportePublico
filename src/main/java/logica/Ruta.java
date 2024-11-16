package logica;

import controladoras.baseIdentificacion;
import java.util.ArrayList;
import java.util.List;

public class Ruta extends baseIdentificacion {

    private int idRuta;
    private String origen;
    private String destino;
    private double distancia;
    private int horarios;
    private Vehiculo vehiculoAsignado; //Uno a uno
    private List<Conductor> conductoresAsignados; //Muchos a Muchos
    private List<Boleto> boletosEmitidos = new ArrayList<>(); //Uno a Muchos

    public Ruta() {
    }

    public Ruta(int idRuta, String origen, String destino, double distancia, int horarios, Vehiculo vehiculoAsignado, List<Conductor> conductoresAsignados) {
        this.idRuta = idRuta;
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.horarios = horarios;
        this.vehiculoAsignado = vehiculoAsignado;
        this.conductoresAsignados = conductoresAsignados;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getHorarios() {
        return horarios;
    }

    public void setHorarios(int Horarios) {
        this.horarios = Horarios;
    }

    public Vehiculo getVehiculoAsignado() {
        return vehiculoAsignado;
    }

    public void setVehiculoAsignado(Vehiculo vehiculoAsignado) {
        this.vehiculoAsignado = vehiculoAsignado;
    }

    public List<Conductor> getConductoresAsignados() {
        return conductoresAsignados;
    }

    public void setConductoresAsignados(List<Conductor> conductoresAsignados) {
        this.conductoresAsignados = conductoresAsignados;
    }

    public List<Boleto> getBoletosEmitidos() {
        return boletosEmitidos;
    }

    public void setBoletosEmitidos(List<Boleto> boletosEmitidos) {
        this.boletosEmitidos = boletosEmitidos;
    }

    @Override
    public String toString() {
        String horarioTexto;
        switch (horarios) {
            case 1:
                horarioTexto = "Día";
                break;
            case 2:
                horarioTexto = "Tarde";
                break;
            case 3:
                horarioTexto = "Noche";
                break;
            default:
                horarioTexto = "Horario no especificado";
        }
        return "Ruta con Codigo "+idRuta 
                + "\nOrigen: "+origen 
                + "\nDestino: "+destino 
                + "\nDistancia: "+distancia
                + "\nHorario: "+horarioTexto
                + "\nVehiculo Asignado: "+vehiculoAsignado 
                + "\nConductores Asignados: "+conductoresAsignados
                + "\nBoletos Emitidos: "+boletosEmitidos;
    }   

    public void agregarConductor(Conductor conductor) {
        // Verificar si el conductor no está ya en la lista
        if (!conductoresAsignados.contains(conductor)) {
            conductoresAsignados.add(conductor);
            System.out.println("Conductor " + conductor.getNombre() + " agregado a la ruta.");
        } else {
            System.out.println("El conductor ya está asignado a esta ruta.");
        }
    }
}
