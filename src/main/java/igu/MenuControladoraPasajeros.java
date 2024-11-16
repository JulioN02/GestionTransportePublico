package igu;

import controladoras.controladoraPasajero;
import java.util.Scanner;

public class MenuControladoraPasajeros {
    
    Scanner sc;
    controladoraPasajero controlPasajeros;
    public MenuControladoraPasajeros() {
        sc=new Scanner(System.in);
        controlPasajeros = new controladoraPasajero();
    }
    
    public void MenuPasajeros(){
        System.out.println("----------------------------------------");
        System.out.println("----------GESTION DE PASAJEROS----------");
        System.out.println("----------------------------------------");
        System.out.println("Ingrese el numero de la opcion a utilizar");
        System.out.println("1: Agregar Nuevo Pasajero");
        System.out.println("2: Eliminar Pasajero");
        System.out.println("3: Actualizar Pasajero");
        System.out.println("4: Lista de Pasajeros Por Ruta");
        System.out.println("5: Buscar Pasajero por Cedula");
        System.out.println("6: Volver al Menu Principal");
        int opcionGestionVehiculos = sc.nextInt();
        sc.nextInt();
        if (opcionGestionVehiculos >= 1 && opcionGestionVehiculos <= 6) {
            switch (opcionGestionVehiculos) {
                case 1:
                    System.out.println("________________________________________");
                    System.out.println("---------AGREGAR PASAJERO NUEVO---------");
                    controlPasajeros.agregarPasajero();
                    System.out.println("________________________________________");
                    break;
                case 2:
                    System.out.println("________________________________________");
                    System.out.println("------------ELIMINAR PASAJERO-----------");
                    controlPasajeros.eliminarPasajero();
                    System.out.println("________________________________________");
                    break;
                case 3:
                    System.out.println("________________________________________");
                    System.out.println("-----------ACTUALIZAR PASAJERO----------");
                    controlPasajeros.actualizarPasajero();
                    System.out.println("________________________________________");
                    break;
                case 4:
                    System.out.println("________________________________________");
                    System.out.println("-------LISTA DE PASAJEROS POR RUTA------");
                    controlPasajeros.listaPasajerosPorRuta();
                    System.out.println("________________________________________");
                case 5:
                    System.out.println("________________________________________");
                    System.out.println("-------BUSCAR PASAJERO POR CEDULA-------");
                    controlPasajeros.buscarPasajero();
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