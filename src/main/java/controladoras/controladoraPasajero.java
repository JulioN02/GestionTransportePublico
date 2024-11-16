package controladoras;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import logica.Boleto;
import logica.Pasajero;

public class controladoraPasajero extends controles<Pasajero> {

    private List<Pasajero> pasajeros;
    private final Scanner sc;

    public controladoraPasajero() {
        sc = new Scanner(System.in);
    }

    public void agregarPasajero() {
        System.out.print("Ingrese la Cedula del pasajero: ");
        int cedulaPasajero = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el nombre del pasajero: ");
        String nombre = sc.nextLine();
        List<Boleto> boletosComprados = new ArrayList<>(); // Inicializamos la lista de boletos vacía para el nuevo pasajero
        Pasajero pasajero = new Pasajero(boletosComprados, cedulaPasajero, nombre);
        agregarElemento(pasajero);
        System.out.println("Pasajero agregado exitosamente.");
    }

    public void actualizarPasajero() {
        System.out.print("Ingrese la Cedula del pasajero a actualizar: ");
        int cedulaPasajero = sc.nextInt();
        sc.nextLine();
        Pasajero pasajero = buscarElemento(cedulaPasajero);
        if (pasajero != null) {
            System.out.print("Ingrese el nuevo nombre del pasajero: ");
            String nuevoNombre = sc.nextLine();

            List<Boleto> boletosActualizados = pasajero.getBoletosComprados(); // Mantiene los boletos existentes
            Pasajero nuevoPasajero = new Pasajero(boletosActualizados, cedulaPasajero, nuevoNombre);

            actualizarElemento(cedulaPasajero, nuevoPasajero);
            System.out.println("Pasajero actualizado exitosamente.");
        } else {
            System.out.println("Pasajero no encontrado.");
        }
    }

    public void eliminarPasajero() {
        System.out.print("Ingrese la Cedula del pasajero a eliminar: ");
        int cedulaPasajero = sc.nextInt();
        sc.nextLine();

        Pasajero borrarPasajero = buscarPasajeroPorCedula(cedulaPasajero);
        if (borrarPasajero != null) {
            eliminarElemento(borrarPasajero.getCedula());
            System.out.println("Pasajero eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un pasajero con esa cédula.");
        }
    }

    public void listarPasajeros() {
        if (elementos.isEmpty()) {
            System.out.println("No hay Pasajeros Registrados");
        }
    }

    public void listaPasajerosPorRuta() {
        System.out.println("Ingrese el Codigo de la Ruta que desea ver los Pasajeros");
        int codigoRuta = sc.nextInt();
        sc.nextLine();
        controladoraBoleto controlBoleto = new controladoraBoleto();
        controlBoleto.listaPasajerosRuta(codigoRuta);
    }

    public void buscarPasajero() {
        System.out.println("Ingrese la Cedula del pasajero a buscar");
        int cedulaPasajero = sc.nextInt();
        sc.nextLine();

        Pasajero pasajero = buscarPasajeroPorCedula(cedulaPasajero);
        if (pasajero != null) {
            System.out.println("Pasajero encontrado: " + pasajero + " con Cedula: " + pasajero.getCedula());
        } else {
            System.out.println("Pasajero no encontrado");
        }
    }

    public Pasajero buscarPasajeroPorCedula(int cedulaPasajero) {
        return (Pasajero) buscarElemento(cedulaPasajero);
    }

    public void agregarBoletoAPasajero() {
        try {
            System.out.println("Ingrese la Cedula del pasajero");
            int cedulaPasajero = sc.nextInt();
            sc.nextLine();
            Pasajero pasajero = buscarElemento(cedulaPasajero);
            if (pasajero != null) {
                System.out.println("Ingrese el ID del boleto");
                int idBoleto = sc.nextInt();
                sc.nextLine();
                //Validar si el boleto ya existe en la lista de boletos del pasajero
                for (Boleto boleto : pasajero.getBoletosComprados()) {
                    if (boleto.getIdBoleto() == idBoleto) {
                        System.out.println("Este boleto ya ha sido agregado");
                        return;
                    }
                }
                System.out.println("Ingrese el precio del boleto");
                double precioBoleto = sc.nextDouble();
                sc.nextLine();
                Boleto nuevoBoleto = new Boleto(idBoleto, new Date(), precioBoleto, pasajero, null);
                pasajero.getBoletosComprados().add(nuevoBoleto);
                System.out.println("Boleto agregado al pasajero exitosamente");
            } else {
                System.out.println("Pasajero no encontrado");
            }
        } catch (Exception e) {
            System.out.println("Error al agregar el boleto. Asegurese de ingresar los datos correctos");
            sc.nextLine();
        }
    }

    @Override
    protected Object obtenerIdentificador(Pasajero pasajero) {
        return pasajero.getId();
    }
}
