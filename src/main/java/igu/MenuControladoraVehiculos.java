package igu;

import controladoras.controladoraVehiculos;
import java.util.Scanner;

public class MenuControladoraVehiculos {

    Scanner sc;
    controladoraVehiculos controlVehiculos;

    public MenuControladoraVehiculos() {
        sc = new Scanner(System.in);
        controlVehiculos = new controladoraVehiculos();
    }

    public void MenuVehiculos() {
        System.out.println("----------------------------------------");
        System.out.println("----------GESTION DE VEHICULOS----------");
        System.out.println("----------------------------------------");
        System.out.println("Ingrese el numero de la opcion a utilizar");
        System.out.println("1: Agregar Vehiculo Nuevo");
        System.out.println("2: Eliminar Vehiculo");
        System.out.println("3: Actualizar Vehiculo");
        System.out.println("4: Lista de Vehiculos");
        System.out.println("5: Buscar Vehiculo por Placa");
        System.out.println("6: Volver al Menu Principal");
        int opcionGestionVehiculos = sc.nextInt();
        sc.nextInt();
        if (opcionGestionVehiculos >= 1 && opcionGestionVehiculos <= 6) {
            switch (opcionGestionVehiculos) {
                case 1:
                    System.out.println("________________________________________");
                    System.out.println("---------AGREGAR VEHICULO NUEVO---------");
                    controlVehiculos.agregarVehiculo();
                    System.out.println("________________________________________");
                    break;
                case 2:
                    System.out.println("________________________________________");
                    System.out.println("---------ELIMINAR VEHICULO NUEVO--------");
                    controlVehiculos.eliminarVehiculo();
                    System.out.println("________________________________________");
                    break;
                case 3:
                    System.out.println("________________________________________");
                    System.out.println("-----------ACTUALIZAR VEHICULO----------");
                    controlVehiculos.actualizarVehiculo();
                    System.out.println("________________________________________");
                    break;
                case 4:
                    System.out.println("________________________________________");
                    System.out.println("-----------LISTA DE VEHICULOS-----------");
                    controlVehiculos.listarVehiculos();
                    System.out.println("________________________________________");
                case 5:
                    System.out.println("________________________________________");
                    System.out.println("--------BUSCAR VEHICULO POR PLACA-------");
                    controlVehiculos.buscarVehiculoPorPlaca();
                case 6:
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.MenuPrincipal();
                    break;
                default:
                    System.out.println("Opcion invalida, ingrese un numero entre 1 y 6");
            }
        } else {
            System.out.println("Ingrese un numero de las opciones entre 1 y 6");
        }

    }

}
