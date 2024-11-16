package controladoras;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//Clase base para crear las controladoras y ahorrar codigo
public abstract class controles<T extends baseIdentificacion> {
    //Lista generica para almacenar los elementos
    protected List<T> elementos;

    protected controles() {
        this.elementos = new ArrayList<>();
    }
    //Metodo para agregar un nuevo elemento a la lista
    protected void agregarElemento(T elemento) {
        elementos.add(elemento);
    }
    //Metodo para eliminar un elemento de la lista
    protected void eliminarElemento(int id) {
        Iterator<T> iterator = elementos.iterator();
        while (iterator.hasNext()) {
            T elemento = iterator.next();
            if (elemento.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }
    //Metodo para actualizar un elemento
    protected void actualizarElemento(int id, T nuevoElemento) {
        for (int i = 0; i < elementos.size(); i++) {
            if (elementos.get(i).getId() == id) {
                elementos.set(i, nuevoElemento);
                break;
            }
        }
    }
    //Metodo para mostrar todos los elementos de la lista
    protected void listarElementos() {
        for (T elemento : elementos) {
            System.out.println(elemento);
        }
    }
    //Metodo para buscar un elemento de ID
    protected T buscarElemento(int id) {
        for (T elemento : elementos) {
            if (elemento.getId() == id) {
                return elemento;
            }
        }
        return null; //Si no lo encuentra
    }
    // Método abstracto para obtener el identificador
    protected abstract Object obtenerIdentificador(T elemento);
    // Método específico para buscar por un identificador tipo String
    protected T buscarElementoPorString(String identificador) {
        for (T elemento : elementos) {
            if (obtenerIdentificador(elemento).equals(identificador)) {
                return elemento;
            }
        }
        return null; // Si no se encuentra el elemento
    }
    // Método genérico para buscar por un identificador de tipo Object
    protected T buscarElementoPorObjeto(Object identificador) {
        for (T elemento : elementos) {
            if (obtenerIdentificador(elemento).equals(identificador)) {
                return elemento;
            }
        }
        return null; // Si no se encuentra el elemento
    }
}
