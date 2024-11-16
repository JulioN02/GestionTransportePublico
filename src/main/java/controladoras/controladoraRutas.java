package controladoras;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import logica.Conductor;
import logica.Ruta;
import logica.Vehiculo;
public class controladoraRutas extends controles<Ruta> {
    private final Scanner sc;
    controladoraVehiculos controlVehiculos;
    controladoraConductor controlConductor;
    public controladoraRutas() {
        super(); //inicializa la lista de elementos
        sc = new Scanner(System.in);
        controlVehiculos = new controladoraVehiculos();
        controlConductor = new controladoraConductor();
    }
    public void agregarRuta() {
        System.out.println("INGRESE LOS DATOS DE LA NUEVA RUTA");
        int codigoRuta;
        while (true) {
            System.out.println("El codigo de ruta:");
            if (sc.hasNextInt()) {
                codigoRuta = sc.nextInt();
                sc.nextLine(); //Limpiar el salto de linea residual
                break;
            } else {
                System.out.println("El codigo de la ruta debe ser un numero entero");
            }
        }
        String origenRuta;
        while (true) {
            System.out.println("El origen de la ruta:");
            origenRuta = sc.nextLine();
            if (!origenRuta.trim().isEmpty()) {
                break;
            } else {
                System.out.println("El origen de la ruta no puede estar vacio");
            }
        }
        String destinoRuta;
        while (true) {
            System.out.println("El destino de la ruta:");
            destinoRuta = sc.nextLine();
            if (!destinoRuta.trim().isEmpty()) {
                break;
            } else {
                System.out.println("El destino de la ruta no puede estar vacio");
            }
        }
        double distanciaRuta;
        while (true) {
            System.out.println("Distancia del recorrido en kilometros:");
            if (sc.hasNextDouble()) {
                distanciaRuta = sc.nextDouble();
                sc.nextLine();
                if (distanciaRuta > 0) {
                    break;
                } else {
                    System.out.println("La distancia debe ser un numero positivo");
                }
            } else {
                System.out.println("La distancia debe ser un numero valido");
            }
        }
        int horarioRuta;
        while (true) {
            System.out.println("Clasificar el horario de la ruta:");
            System.out.println("1: Si es Dia");
            System.out.println("2: Si es Tarde");
            System.out.println("3: Si es Noche");
            if (sc.hasNextInt()) {
                horarioRuta = sc.nextInt();
                sc.nextLine();
                if (horarioRuta >= 1 && horarioRuta <= 3) {
                    break;
                } else {
                    System.out.println("El horario debe ser:");
                    System.out.println("1: Si es Dia");
                    System.out.println("2: Si es Tarde");
                    System.out.println("3: Si es Noche");
                }
            } else {
                System.out.println("Debe ingresar un numero valido para el horario");
            }
        }
        String placaVehiculoRuta;
        Vehiculo vehiculoAsignado;
        while (true) {
            System.out.println("Ingrese la placa del Vehiculo que recorrera la Ruta");
            placaVehiculoRuta = sc.nextLine();
            vehiculoAsignado = controlVehiculos.buscarVehiculoPorPlaca(placaVehiculoRuta);
            if (vehiculoAsignado == null) {
                System.out.println("No se encontro un vehiculo con la placa " + placaVehiculoRuta);
            } else if (vehiculoAsignado.isDisponible() == false) {
                System.out.println("El vehiculo con la placa: " + placaVehiculoRuta + " no esta disponible");
            } else {
                vehiculoAsignado.setDisponible(false);
                System.out.println("Vehiculo con placa: " + vehiculoAsignado.getPlaca() + "asignado a la Ruta: " + codigoRuta + " con Origen: " + origenRuta + "y Destino: " + destinoRuta);
                break;
            }
        }
        int cedulaConductorRuta;
        List<Conductor> conductoresAsignados = new ArrayList<>();

        while (true) {
            System.out.println("Ingrese la Cedula del conductor que recorrera la Ruta");

            if (sc.hasNextInt()) {
                cedulaConductorRuta = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println("Debe ingresar un numero valido para la cedula del conductor");
            }
        }
        Conductor conductorAsignado = controlConductor.buscarConductor(cedulaConductorRuta);
        if (conductorAsignado == null) {
            System.out.println("No se encontro un conductor con la cedula: " + cedulaConductorRuta);
            return;
        }
        if (conductorAsignado.getRutasAsignadas().size() >= 5) {
            System.out.println("El conductor con cedula " + cedulaConductorRuta + " ya tiene el maximo de 5 rutas asignadas");
            return;
        }

        if (controlConductor.asignarRutaAConductor(cedulaConductorRuta, codigoRuta)) {
            System.out.println("Ruta asignada correctamente al conductor con cedula: " + cedulaConductorRuta);
        }

        conductoresAsignados.add(conductorAsignado);
        Ruta nuevaRuta = new Ruta(codigoRuta, origenRuta, destinoRuta, distanciaRuta, horarioRuta, vehiculoAsignado, conductoresAsignados);
        elementos.add(nuevaRuta);
        System.out.println("Ruta agregada exitosamente");
    }
    public void eliminarRuta() {
        int rutaId;
        while (true) {
            System.out.println("INGRESE EL ID DE LA RUTA QUE DESEA ELIMINAR");
            if (sc.hasNextInt()) {
                rutaId = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println("El ID de la ruta debe ser un numero entero");
                sc.nextLine();
            }
        }
        Ruta rutaEliminar = buscarElemento(rutaId);
        if (rutaEliminar != null) {
            int confirmacion = 0;
            while (confirmacion != 1 && confirmacion != 2) {
                System.out.println("¿Seguro que desea eliminar la ruta? 1: Si / 2: No");
                if (sc.hasNextInt()) {
                    confirmacion = sc.nextInt();
                    sc.nextLine();
                    if (confirmacion == 1 || confirmacion == 2) {
                        elementos.remove(rutaEliminar);
                        System.out.println("Ruta eliminada exitosamente");
                    } else if (confirmacion == 2) {
                        System.out.println("Eliminacion de la ruta Cancelada");
                    } else {
                        System.out.println("Opcion no valida. Debe ingresar un numero entre 1 y 2");
                    }
                }
            }
        }
    }
    public void actualizarRuta() {
        System.out.println("INGRESE EL ID DE LA RUTA QUE DESEA ACTUALIZAR");
        int rutaId;
        while (true) {
            if (sc.hasNextInt()) {
                rutaId = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println("El ID de la ruta debe ser un numero entero");
                sc.nextLine();
            }
        }
        Ruta ruta = buscarElemento(rutaId);
        if (ruta != null) {
            System.out.println("¿Que datos de la ruta quiere cambiar?");
            System.out.println("1: Origen");
            System.out.println("2: Destino");
            System.out.println("3: Distancia");
            System.out.println("4: Horario");
            System.out.println("5: Vehiculo Asignado");
            System.out.println("6: Agregar o eliminar conductores");
            int respuesta = sc.nextInt();
            sc.nextLine();
            if (respuesta >= 1 && respuesta <= 6) {
                switch (respuesta) {
                    case 1:
                        System.out.println("Ingrese el nuevo Origen");
                        String rpOrigen = sc.nextLine().trim();
                        if (!rpOrigen.isEmpty()) {
                            ruta.setOrigen(rpOrigen);
                            System.out.println("Origen actualizado a: " + rpOrigen);
                        } else {
                            System.out.println("El origen no puede estar vacio");
                        }
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo Destino");
                        String rpDestino = sc.nextLine();
                        if (!rpDestino.isEmpty()) {
                            ruta.setDestino(rpDestino);
                            System.out.println("Destino actualizado a: " + rpDestino);
                        } else {
                            System.out.println("El destino no puede estar vacio");
                        }
                        break;
                    case 3:
                        if (sc.hasNextDouble()) {
                            System.out.println("Ingrese la nueva Distancia (Kilometros)");
                            double rpDistancia = sc.nextDouble();
                            sc.nextLine(); //Limpiar el buffer
                            if (rpDistancia > 0) {
                                ruta.setDistancia(rpDistancia);
                                System.out.println("Distancia actualizada a: " + rpDistancia + " km");
                            } else {
                                System.out.println("La distancia debe ser un numero positivo");
                            }
                        } else {
                            System.out.println("Debe ingresar un numero valido");
                        }
                        break;
                    case 4:
                        System.out.println("Ingrese el nuevo Horario");
                        System.out.println("1: Si es Dia");
                        System.out.println("2: Si es Tarde");
                        System.out.println("3: Si es Noche");

                        if (sc.hasNextInt()) {
                            int rpHorario = sc.nextInt();
                            sc.nextLine(); //Limpiar el buffer
                            if (rpHorario >= 1 && rpHorario <= 3) {
                                ruta.setHorarios(rpHorario);
                                System.out.println("Horario actualizado a: " + rpHorario);
                            } else {
                                System.out.println("Opcion no valida. Debe seleccionar un numero entre 1 y 3");
                            }
                        } else {
                            System.out.println("Entrada no valida, se espera un numero");
                        }
                        break;
                    case 5:
                        String placaVehiculoRuta;
                        while (true) {
                            System.out.println("Ingrese la placa del nuevo Vehiculo para esta ruta");
                            placaVehiculoRuta = sc.nextLine().trim();
                            Vehiculo vehiculoAsignado = controlVehiculos.buscarVehiculoPorPlaca(placaVehiculoRuta);
                            if (vehiculoAsignado != null) {
                                ruta.setVehiculoAsignado(vehiculoAsignado);
                                System.out.println("Vehiculo actualizado a la ruta: " + placaVehiculoRuta);
                                break;
                            } else {
                                System.out.println("No se encontro un vehiculo con la placa" + placaVehiculoRuta);
                            }
                        }
                        break;
                    case 6:
                        System.out.println("Ingrese la Cedula del Conductor");
                        int opcionConductor = sc.nextInt();
                        sc.nextLine(); // Limpiar el buffer
                        Conductor conductor = controlConductor.buscarConductor(opcionConductor);

                        System.out.println("¿Desea agregar o eliminar un conductor?");
                        System.out.println("1: Agregar conductor");
                        System.out.println("2: Eliminar conductor");

                        if (opcionConductor == 1) {
                            if (conductor != null) {
                                if (!ruta.getConductoresAsignados().contains(conductor)) {
                                    ruta.getConductoresAsignados().add(conductor);
                                    System.out.println("Conductor agregado correctamente.");
                                } else {
                                    System.out.println("Este conductor ya esta asignado a la ruta.");
                                }
                            } else {
                                System.out.println("No se encontro un conductor con la cedula ingresada.");
                            }
                        } else if (opcionConductor == 2) {
                            if (conductor != null) {
                                if (ruta.getConductoresAsignados().remove(conductor)) {
                                    System.out.println("Conductor eliminado correctamente.");
                                } else {
                                    System.out.println("Este conductor no esta asignado a la ruta.");
                                }
                            } else {
                                System.out.println("No se encontro un conductor con la cedula ingresada.");
                            }
                        } else {
                            System.out.println("Opcion no Valida.");
                        }
                        break;
                    default:
                        System.out.println("Opcion no Valida");
                        break;
                }
                System.out.println("Ruta Actualizada Exitosamente");
            } else {
                System.out.println("Opcion no valida. Seleccione una opcion entre 1 y 6");
            }
        } else {
            System.out.println("Ruta no encontrada");
        }
    }
    public void listarRutas() {
        if (elementos.isEmpty()) {
            System.out.println("No hay rutas registradas");
        } else {
            System.out.println("LISTADO DE RUTAS REGISTRADAS");
            int contador = 1;
            for (Ruta ruta : elementos) {
                System.out.println("Ruta # " + contador + " :");
                System.out.println("Origen: "+ruta.getOrigen()+" Destino: "+ruta.getDestino());
                System.out.println("---------------------------");
                contador++;
            }
        }
    }
    public Ruta buscarRutaPorId(int idRuta) {
        return (Ruta) buscarElemento(idRuta);
    }
    public void buscarRuta(){
        System.out.println("Ingrese el Codigo de la Ruta para Consultar");
        int codigoRuta = sc.nextInt();
        sc.nextLine();
        Ruta rutaEncontrada=buscarRutaPorId(codigoRuta);
        if(rutaEncontrada!=null){
            System.out.println("Ruta con Codigo: "+codigoRuta+"encontrada con los siguientes datos");
            System.out.println(rutaEncontrada);
        } else {
            System.out.println("Ruta con Codigo :"+codigoRuta+" no encontrada en la lista");
        }
    }
    @Override
    protected Object obtenerIdentificador(Ruta identificadorRuta) {
        return (Ruta) buscarElementoPorObjeto(identificadorRuta);
    }
}
