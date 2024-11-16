package controladoras;
public abstract class baseIdentificacion {
    //Clase para inicializar el id y usar sus metodos en la clase base de las controladoras
    protected int id;
    protected baseIdentificacion() {
    }
    protected baseIdentificacion(int id) {
        this.id = id;
    }
    protected int getId() {
        return this.id;
    }
    protected void setId(int id) {
        this.id = id;
    }
}
