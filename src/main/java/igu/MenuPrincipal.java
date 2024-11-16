package igu;

import java.util.Scanner;

public class MenuPrincipal {

    Scanner sc;
    public MenuPrincipal() {
        sc = new Scanner(System.in);
    }

    public void MenuPrincipal() {
        boolean salir = false;
        while (!salir) {
            System.out.println("___________________________________________");
            System.out.println("\n");
            System.out.println("-------GESTION DE TRANSPORTE PUBLICO-------");
            System.out.println("___________________________________________");
            System.out.println("Seleccione la opcion de la entidad que quiere gestionar: ");
            System.out.println("1: Menu para Gestionar Boletos");
            System.out.println("2: Menu para Gestionar Pasajeros");
            System.out.println("3: Manu para Gestionar Rutas");
            System.out.println("4: Menu para Gestionar Conductores");
            System.out.println("5: Menu para Gestionar Vehiculos");
            System.out.println("6: Salir del Programa");
            System.out.println("Ingrese su opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1 -> {
                    MenuControladoraBoletos MenuBoletos = new MenuControladoraBoletos();
                    MenuBoletos.MenuBoletos();
                }
                case 2 -> {
                    MenuControladoraPasajeros MenuPasajeros = new MenuControladoraPasajeros();
                    MenuPasajeros.MenuPasajeros();
                }
                case 3 -> {
                    MenuControladoraRutas MenuRutas = new MenuControladoraRutas();
                    MenuRutas.MenuRutas();
                }
                case 4 -> {
                    MenuControladoraConductores MenuConductores = new MenuControladoraConductores();
                    MenuConductores.MenuConductores();
                }
                case 5 -> {
                    MenuControladoraVehiculos MenuVehiculos = new MenuControladoraVehiculos();
                    MenuVehiculos.MenuVehiculos();
                }
                case 6 -> {
                    System.out.println("SALIENDO DEL PROGRAMA...");
                    salir=true;
                    break;
                }
                default -> System.out.println("Opcion no valida Por favor, intente nuevamente");
            }
        }
    }
}
