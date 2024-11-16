package controladoras;
import com.sun.source.tree.BreakTree;
import java.util.InputMismatchException;
import java.util.Scanner;
import logica.Vehiculo;
public class controladoraVehiculos extends controles<Vehiculo> {
    private final Scanner sc;
    public controladoraVehiculos() {
        super(); //inicializa la lista de elementos
        sc = new Scanner(System.in);
    }
    public void agregarVehiculo() {
        System.out.println("INGRESE LOS DATOS DEL NUEVO VEHICULO");
        System.out.println("Que tipo de Vehiculo es? (moto, carro, camioneta, bus, camion...)");
        String tipo = sc.nextLine();
        boolean disponibilidad;
        while (true) {
            System.out.println("Indique la disponibilidad");
            System.out.println("1: Disponible (true)");
            System.out.println("0: No Disponible (false)");
            int rpDisponibilidad = sc.nextInt();
            sc.nextLine();
            if (rpDisponibilidad == 1) {
                disponibilidad = true;
                break;
            } else if (rpDisponibilidad == 0) {
                disponibilidad = false;
                break;
            } else {
                System.out.println("Ingrese 1 para Disponible o 0 para No Disponible");
            }
        }
        System.out.println("Digite la placa del Vehiculo");
        String placa = sc.nextLine();
        int capacidad;
        while (true) {
            System.out.println("Capacidad del Vehiculo en numero de Personas");
            if (sc.hasNextInt()) {
                capacidad = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println("La capacidad debe ser un numero entero");
                sc.nextLine();
            }
        }
        Vehiculo nuevoVehiculo = new Vehiculo(tipo, disponibilidad, placa, capacidad);
        elementos.add(nuevoVehiculo);
        System.out.println("Vehiculo agregado exitosamente");
    }
    public void eliminarVehiculo() {
        System.out.println("Ingresa la placa del Vehiculo para Eliminar");
        String placa = sc.nextLine();
        Vehiculo vehiculo = buscarElementoPorString(placa);
        if (vehiculo != null) {
            System.out.println("¿Seguro desea eliminar el vehiculo?");
            System.out.println("1: Si");
            System.out.println("2: No");
            int confirmacion = sc.nextInt();
            if (confirmacion == 1) {
                elementos.remove(vehiculo);
                System.out.println("Vehiculo eliminado exitosamente");
            } else {
                System.out.println("No se elimino ningun Vehiculo");
            }
        } else {
            System.out.println("Vehiculo no encontrado");
        }
    }
    @Override
    protected Object obtenerIdentificador(Vehiculo vehiculo) {
        return vehiculo.getPlaca(); // Retorna la placa como identificador
    }
    public void actualizarVehiculo() {
        System.out.println("Ingrese la Placa del Vehiculo que desea Actualizar");
        String placa =sc.nextLine();
        Vehiculo vehiculoEncontrado = buscarVehiculoPorPlaca(placa);
        if (vehiculoEncontrado != null) {
            System.out.println("¿Que dato desea actualizar?");
            System.out.println("1: Tipo");
            System.out.println("2: Disponibilidad");
            System.out.println("3: Capacidad");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Nuevo tipo de Vehiculo: ");
                    String nuevoTipo = sc.nextLine();
                    vehiculoEncontrado.setTipo(nuevoTipo);
                    System.out.println("Tipo actualizado a: " + nuevoTipo);
                    break;
                case 2:
                    System.out.println("Nueva disponibilidad: ");
                    System.out.println("1: Disponible (true)");
                    System.out.println("0: No Disponible (false)");
                    int nuevaDisponibilidad = sc.nextInt();
                    sc.nextLine();
                    if (nuevaDisponibilidad == 1) {
                        vehiculoEncontrado.setDisponible(true);
                        System.out.println("Disponibilidad actualizada a: " + vehiculoEncontrado.isDisponible());
                        break;
                    } else if (nuevaDisponibilidad == 0) {
                        vehiculoEncontrado.setDisponible(false);
                        System.out.println("Disponibilidad actualizada a: " + vehiculoEncontrado.isDisponible());
                        break;
                    }
                    break;
                case 3:
                    System.out.println("Nueva capacidad: ");
                    try{
                        int nuevaCapacidad = sc.nextInt();
                        sc.nextLine();
                        vehiculoEncontrado.setCapacidad(nuevaCapacidad);
                        System.out.println("Capacidad actualizada a: " + nuevaCapacidad);
                    } catch (InputMismatchException e){
                        System.out.println("Por favor ingrese un numero valido para la capacidad");
                        sc.nextLine();
                    }
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } else {
            System.out.println("Vehiculo no encontrado");
        }
    }
    public void listarVehiculos(){
        if (elementos.isEmpty()) {
            System.out.println("No hay vehiculos registrados");
        } else {
            System.out.println("LISTADO DE VEHICULOS REGISTRADOS");
            int contador = 1;
            for (Vehiculo vehiculo : elementos){
                System.out.println("Vehiculo # "+contador+" :");
                System.out.println(vehiculo);
                System.out.println("-----------------------");
                contador++;
            }
        }
    }
    public Vehiculo buscarVehiculoPorPlaca(String placaVehiculo){
        return (Vehiculo) buscarElementoPorString(placaVehiculo);
    }
    public Vehiculo buscarVehiculoPorPlaca(){
        System.out.println("Ingrese la placa del Vehiculo que desea buscar");
        String placaBuscarVehiculo=sc.nextLine();
        Vehiculo vehiculoBuscado=buscarVehiculoPorPlaca(placaBuscarVehiculo);
        if(vehiculoBuscado!=null){
            System.out.println("Vehiculo con placa: "+placaBuscarVehiculo+"encontrado");
            System.out.println("Esta es la informacion:");
            return vehiculoBuscado;
        } else {
            System.out.println("Vehiculo no encontrado");
            return null;
        }
    }
}
