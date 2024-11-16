package logica;
import java.util.ArrayList;
import java.util.List;

public class Pasajero extends Persona{
    private List<Boleto> boletosComprados; //Uno a Muchos

    public Pasajero() {
        this.boletosComprados=new ArrayList<>();
    }

    public Pasajero(List<Boleto> boletosComprados, int cedula, String nombre) {
        super(cedula, nombre);
        this.boletosComprados = boletosComprados;
    }

    public List<Boleto> getBoletosComprados() {
        return boletosComprados;
    }

    public void setBoletosComprados(List<Boleto> boletosComprados) {
        this.boletosComprados = boletosComprados;
    }

    @Override
    public String toString() {
        return "Pasajero{" + "boletosComprados=" + boletosComprados + '}';
    }
}
