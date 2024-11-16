package igu;

import controladoras.controladoraConductor;
import java.util.Scanner;

public class MenuControladoraConductores {

    Scanner sc;
    controladoraConductor controlConductores;
    public MenuControladoraConductores() {
        sc=new Scanner(System.in);
        controlConductores=new controladoraConductor();
    }
    public void MenuConductores(){
        System.out.println("----------------------------------------");
        System.out.println("---------GESTION DE CONDUCTORES---------");
        System.out.println("----------------------------------------");
        System.out.println("Ingrese el numero de la opcion a utilizar");
        System.out.println("1: Agregar Conductor Nuevo");
        System.out.println("2: Eliminar Conductor");
        System.out.println("3: Actualizar Conductor");
        System.out.println("4: Lista de Conductores");
        System.out.println("5: Buscar Conductor por Cedula");
        System.out.println("6: Volver al Menu Principal");
        int opcionGestionConductores=sc.nextInt();
        sc.nextLine();
        if (opcionGestionConductores >= 1 && opcionGestionConductores <= 6) {
            switch (opcionGestionConductores) {
                case 1:
                    System.out.println("________________________________________");
                    System.out.println("---------AGREGAR CONDUCTOR NUEVO---------");
                    controlConductores.crearConductor();
                    System.out.println("________________________________________");
                    break;
                case 2:
                    System.out.println("________________________________________");
                    System.out.println("-----------ELIMINAR CONDUCTOR-----------");
                    controlConductores.eliminarConductor();
                    System.out.println("________________________________________");
                    break;
                case 3:
                    System.out.println("________________________________________");
                    System.out.println("-----------ACTUALIZAR VEHICULO----------");
                    controlConductores.actualizarConductor();
                    System.out.println("________________________________________");
                    break;
                case 4:
                    System.out.println("________________________________________");
                    System.out.println("-----------LISTA DE VEHICULOS-----------");
                    controlConductores.listarConductor();
                    System.out.println("________________________________________");
                    break;
                case 5:
                    System.out.println("________________________________________");
                    System.out.println("--------BUSCAR VEHICULO POR PLACA-------");
                    controlConductores.buscarConductor();
                    break;
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