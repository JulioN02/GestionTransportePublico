package logica;
public class Vehiculo extends Transporte{
    private String tipo;
    private boolean disponible;
    public Vehiculo() {
    }
    public Vehiculo(String tipo, boolean disponible, String placa, int capacidad) {
        super(placa, capacidad);
        this.tipo = tipo;
        this.disponible = disponible;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    @Override
    public String toString() {
        return "Vehiculo{" + "tipo=" + tipo + ", disponible=" + disponible + '}';
    }
}
