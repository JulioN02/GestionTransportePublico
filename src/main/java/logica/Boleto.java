package logica;

import controladoras.baseIdentificacion;
import java.util.Date;

public class Boleto extends baseIdentificacion{

    private int idBoleto;
    private Date fecha;
    private double precio;
    private Pasajero pasajero; //Uno a Uno
    private Ruta ruta; //Uno a Uno

    public Boleto(int idBoleto, Date fecha, double precio, Pasajero pasajero, Ruta ruta) {
        this.idBoleto = idBoleto;
        this.fecha = fecha;
        this.precio = precio;
        this.pasajero = pasajero;
        this.ruta = ruta;
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "Boleto{" + "idBoleto=" + idBoleto + ", fecha=" + fecha + ", precio=" + precio + ", pasajero=" + pasajero + ", ruta=" + ruta + '}';
    }
}
