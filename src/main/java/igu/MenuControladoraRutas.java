package igu;

import controladoras.controladoraRutas;
import java.util.Scanner;

public class MenuControladoraRutas {

    Scanner sc;
    controladoraRutas controlRutas;
    public MenuControladoraRutas() {
        sc=new Scanner(System.in);
        controlRutas=new controladoraRutas();
    }
    
    public void MenuRutas(){
        System.out.println("----------------------------------------");
        System.out.println("------------GESTION DE RUTAS------------");
        System.out.println("----------------------------------------");
        System.out.println("Ingrese el numero de la opcion a utilizar");
        System.out.println("1: Agregar Ruta Nueva");
        System.out.println("2: Eliminar Ruta");
        System.out.println("3: Actualizar Ruta");
        System.out.println("4: Lista de Rutas");
        System.out.println("5: Buscar Ruta por Codigo");
        System.out.println("6: Volver al Menu Principal");
        int opcionGestionVehiculos = sc.nextInt();
        sc.nextInt();
        if (opcionGestionVehiculos >= 1 && opcionGestionVehiculos <= 6) {
            switch (opcionGestionVehiculos) {
                case 1:
                    System.out.println("________________________________________");
                    System.out.println("-----------AGREGAR RUTA NUEVA-----------");
                    controlRutas.agregarRuta();
                    System.out.println("________________________________________");
                    break;
                case 2:
                    System.out.println("________________________________________");
                    System.out.println("--------------ELIMINAR RUTA-------------");
                    controlRutas.eliminarRuta();
                    System.out.println("________________________________________");
                    break;
                case 3:
                    System.out.println("________________________________________");
                    System.out.println("-------------ACTUALIZAR RUTA------------");
                    controlRutas.actualizarRuta();
                    System.out.println("________________________________________");
                    break;
                case 4:
                    System.out.println("________________________________________");
                    System.out.println("-------------LISTA DE RUTAS-------------");
                    controlRutas.listarRutas();
                    System.out.println("________________________________________");
                case 5:
                    System.out.println("________________________________________");
                    System.out.println("---------BUSCAR RUTA POR CODIGO---------");
                    controlRutas.buscarRuta();
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