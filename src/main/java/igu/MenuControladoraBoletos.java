package igu;

import controladoras.controladoraBoleto;
import java.util.Scanner;

public class MenuControladoraBoletos {

    Scanner sc;
    controladoraBoleto controlBoletos;
    public MenuControladoraBoletos() {
        sc=new Scanner(System.in);
        controlBoletos = new controladoraBoleto();
    }
    
    public void MenuBoletos(){
        System.out.println("----------------------------------------");
        System.out.println("-----------GESTION DE BOLETOS-----------");
        System.out.println("----------------------------------------");
        System.out.println("Ingrese el numero de la opcion a utilizar");
        System.out.println("1: Crear Nuevo Boleto");
        System.out.println("2: Eliminar Boleto");
        System.out.println("3: Actualizar Boleto");
        System.out.println("4: Lista de Boletos por Ruta");
        System.out.println("5: Buscar Boleto por Codigo");
        System.out.println("6: Volver al Menu Principal");
        int opcionGestionVehiculos = sc.nextInt();
        sc.nextLine();
        if (opcionGestionVehiculos >= 1 && opcionGestionVehiculos <= 6) {
            switch (opcionGestionVehiculos) {
                case 1:
                    System.out.println("________________________________________");
                    System.out.println("----------AGREGAR NUEVO BOLETO----------");
                    controlBoletos.crearBoleto();
                    System.out.println("________________________________________");
                    break;
                case 2:
                    System.out.println("________________________________________");
                    System.out.println("-------------ELIMINAR BOLETO------------");
                    controlBoletos.eliminarBoleto();
                    System.out.println("________________________________________");
                    break;
                case 3:
                    System.out.println("________________________________________");
                    System.out.println("------------ACTUALIZAR BOLETO-----------");
                    controlBoletos.actualizarBoleto();
                    System.out.println("________________________________________");
                    break;
                case 4:
                    System.out.println("________________________________________");
                    System.out.println("--------LISTA DE BOLETOS POR RUTA-------");
                    controlBoletos.listaBoletosRuta();
                    System.out.println("________________________________________");
                    break;
                case 5:
                    System.out.println("________________________________________");
                    System.out.println("--------BUSCAR BOLETO POR CODIGO--------");
                    controlBoletos.buscarBoleto();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opcion invalida, ingrese un numero entre 1 y 6");
            }
        } else {
            System.out.println("Ingrese un numero de las opciones entre 1 y 6");
        }
    }
}