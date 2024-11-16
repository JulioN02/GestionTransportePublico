package controladoras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import logica.Conductor;
import logica.Ruta;

public class controladoraConductor extends controles<Conductor> {

    private final Scanner sc;
    private controladoraRutas controlRutas;

    public controladoraConductor() {
        super();
        sc = new Scanner(System.in);
        controlRutas = new controladoraRutas();
    }

    public void crearConductor() {
        System.out.println("INGRESE LOS DATOS DEL NUEVO CONDUCTOR");
        int cedulaConductor;
        while (true) {
            System.out.println("Ingrese la Cedula del nuevo Conductor");
            if (sc.hasNextInt()) {
                cedulaConductor = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println("La Cedula el nuevo Conductor deber ser un entero");
            }
        }
        String nombreConductor;
        while (true) {
            System.out.println("Escriba el nombre del nuevo Conductor");
            nombreConductor = sc.nextLine();
            if (!nombreConductor.trim().isEmpty()) {
                break;
            } else {
                System.out.println("El nombre del nuevo Conductor no puede estar vacio");
            }
        }
        String licenciaConductor;
        while (true) {
            System.out.println("¿Que licencia tiene el nuevo Conductor?");
            licenciaConductor = sc.nextLine();
            if (!licenciaConductor.trim().isEmpty()) {
                break;
            } else {
                System.out.println("La licencia del nuevo Conductor no puede estar vacia");
            }
        }
        List<Ruta> rutaAsignadas = new ArrayList<>();
        boolean agregarOtraRuta = true;
        while (agregarOtraRuta) {
            System.out.println("Ingrese el ID de la ruta que desea asignar al conductor o ingresar -1 para terminar");
            int idRuta = sc.nextInt();
            sc.nextLine(); //Limpiar Buffer
            if (idRuta == -1) {
                agregarOtraRuta = false;
            } else {
                boolean rutaAsignada = asignarRutaAConductor(cedulaConductor,idRuta);
                if(rutaAsignada){
                    Ruta ruta = controlRutas.buscarRutaPorId(idRuta);
                    if(ruta!=null){
                        rutaAsignadas.add(ruta);
                        System.out.println("Ruta asignada al conductor: "+nombreConductor+" con Origen: "+ruta.getOrigen()+" y Destino: "+ruta.getDestino());
                    }
                } else {
                    System.out.println("No se pudo asignar la ruta. Verifique que la ruta no este ya asignada");
                }
            }
        }
        Conductor conductorNuevo = new Conductor(licenciaConductor, rutaAsignadas, cedulaConductor, nombreConductor);
        elementos.add(conductorNuevo);
        System.out.println("Conductor nuevo agregado exitosamente");
    }

    public void eliminarConductor() {
        int cedulaConductorEliminar;

        // Bucle para ingresar cédula
        do {
            System.out.println("INGRESE LA CEDULA DEL CONDUCTOR QUE DESEA ELIMINAR");
            if (sc.hasNextInt()) {
                cedulaConductorEliminar = sc.nextInt();
                sc.nextLine(); // Limpiar buffer

                Conductor conductor = buscarElemento(cedulaConductorEliminar);
                if (conductor != null) {
                    // Confirmación de eliminación
                    int confirmacion = obtenerConfirmacionEliminacion();
                    if (confirmacion == 1) {
                        elementos.remove(conductor);
                        System.out.println("Conductor ha sido eliminado exitosamente");
                    } else {
                        System.out.println("No se elimino ningun Conductor");
                    }
                    break;
                } else {
                    System.out.println("Conductor no encontrado");
                }
            } else {
                System.out.println("La cedula debe ser un numero entero");
                sc.nextLine(); // Limpiar buffer
            }
        } while (true);
    }

    private int obtenerConfirmacionEliminacion() {
        int confirmacion;
        while (true) {
            System.out.println("¿Seguro que desea eliminar este Conductor? 1: Si / 2: No");
            if (sc.hasNextInt()) {
                confirmacion = sc.nextInt();
                sc.nextLine();
                if (confirmacion == 1 || confirmacion == 2) {
                    return confirmacion;
                } else {
                    System.out.println("Debe ingresar 1 para Si o 2 para No");
                }
            } else {
                System.out.println("Debe ingresar un numero valido (1 o 2)");
                sc.nextLine();
            }
        }
    }

    public void actualizarConductor() {
        System.out.println("INGRESE LA CEDULA DEL CONDUCTOR QUE DESEA ACTUALIZAR");
        int conductorCedula;
        while (true) {
            if (sc.hasNextInt()) {
                conductorCedula = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println("El ID de la ruta debe ser un numero entero");
                sc.nextLine();
            }
        }
        Conductor conductor = buscarElemento(conductorCedula);
        if (conductor != null) {
            System.out.println("¿Que datos del Conductor quiere cambiar?");
            System.out.println("1: Cedula");
            System.out.println("2: Nombre");
            System.out.println("3: Licencia");
            System.out.println("4: Ruta Asignada");
            int respuesta = sc.nextInt();
            sc.nextLine();
            if (respuesta >= 1 && respuesta <= 4) {
                switch (respuesta) {
                    case 1:
                        System.out.println("Ingrese la nueva cedula");
                        int nuevaCedula = sc.nextInt();
                        sc.nextLine();
                        conductor.setId(nuevaCedula);
                        System.out.println("Cedula actualizada a: " + nuevaCedula);
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo nombre");
                        String nuevoNombre = sc.nextLine();
                        if (!nuevoNombre.isEmpty()) {
                            conductor.setNombre(nuevoNombre);
                            System.out.println("Nombre actualizado a: " + nuevoNombre);
                        } else {
                            System.out.println("El nombre no puede estar vacio");
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese la nueva licencia");
                        String nuevaLicencia = sc.nextLine().trim();
                        if (!nuevaLicencia.isEmpty()) {
                            conductor.setLicencia(nuevaLicencia);
                            System.out.println("Licencia actualizada a: " + nuevaLicencia);
                        } else {
                            System.out.println("La licencia no puede estar vacia");
                        }
                        break;
                    case 4:
                        System.out.println("OPCIONES DE RUTAS ASIGNADAS");
                        System.out.println("1: Mostrar Rutas Asignadas");
                        System.out.println("2: Editar una Ruta Asignada");
                        System.out.println("3: Eliminar una Ruta Asignada");
                        System.out.println("4: Asignar una Nueva Ruta");
                        int opcionEdicionRuta = sc.nextInt();
                        sc.nextLine();
                        switch (opcionEdicionRuta) {
                            case 1:
                                System.out.println("Rutas asignadas al Conductor");
                                for (Ruta ruta : conductor.getRutasAsignadas()) {
                                    System.out.println("ID: " + ruta.getIdRuta() + " Origen: " + ruta.getOrigen() + " Destino: " + ruta.getDestino());
                                }
                                break;
                            case 2:
                                System.out.println("Ingrese el ID de la ruta que desea editar");
                                int idRutaEditar = sc.nextInt();
                                sc.nextLine();
                                Ruta rutaEditar = controlRutas.buscarRutaPorId(idRutaEditar);
                                if (rutaEditar != null && conductor.getRutasAsignadas().contains(rutaEditar)) {
                                    System.out.println("Ingrese el nuevo Origen");
                                    String nuevoOrigen = sc.nextLine();
                                    System.out.println("Ingrese el nuevo Destino");
                                    String nuevoDestino = sc.nextLine();
                                    rutaEditar.setOrigen(nuevoOrigen);
                                    rutaEditar.setDestino(nuevoDestino);
                                    System.out.println("Ruta actualizada: Origen " + nuevoOrigen + " Destino: " + nuevoDestino);
                                } else {
                                    System.out.println("La ruta no esta asignada al conductor o no se encontro");
                                }
                                break;
                            case 3:
                                System.out.println("Ingrese el ID de la ruta que desea eliminar");
                                int idRutaEliminar = sc.nextInt();
                                sc.nextLine();
                                Ruta rutaEliminar = controlRutas.buscarRutaPorId(idRutaEliminar);
                                sc.nextLine();
                                if (rutaEliminar != null && conductor.getRutasAsignadas().remove(rutaEliminar)) {
                                    System.out.println("Ruta eliminada del conductor");
                                } else {
                                    System.out.println("La ruta no esta asignada al conductor o no se encontro ");
                                }
                                break;
                            case 4:
                                boolean agregarOtraRuta = true;
                                while (agregarOtraRuta) {
                                    System.out.println("Ingrese el ID de la nueva ruta que desea asignar al conductor o ingrese -1 para finalizar");
                                    int idRutaNueva = sc.nextInt();
                                    sc.nextLine();
                                    if (idRutaNueva == -1) {
                                        agregarOtraRuta = false;
                                    } else {
                                        boolean rutaAsignada = asignarRutaAConductor(conductor.getCedula(), idRutaNueva);
                                        if (rutaAsignada){
                                            System.out.println("Ruta asignada exitosamente al conductor: "+conductor.getNombre());
                                        }
                                    }
                                }
                                break;
                            default:
                                System.out.println("Opcion no valida");
                        }
                    default:
                }
            } else {
                System.out.println("Opcion no valida. Seleccione una opcion entre 1 y 4");
            }
            int indice = elementos.indexOf(conductor);
            if (indice != -1) {
                elementos.set(indice, conductor);
                System.out.println("Conductor actualizado exitosamente");
            } else {
                System.out.println("No se pudo actualizar el conductor en la lista");
            }
        } else {
            System.out.println("Conductor no encontrado");
        }
    }

    public Conductor buscarConductor() {
        System.out.println("Ingrese la cedula del conductor que desea buscar");
        int cedulaConductorBuscar = sc.nextInt();
        sc.nextLine();
        Conductor conductor = buscarConductor(cedulaConductorBuscar);
        if (conductor != null) {
            System.out.println("Conductor encontrado: " + conductor.toString());
        } else {
            System.out.println("Conductor no encontrado con la cedula: " + cedulaConductorBuscar);
        }
        return conductor;
    }
    
    public Conductor buscarConductor(int cedulaConductor) {
        Conductor conductor = (Conductor) buscarElemento(cedulaConductor);
        if (conductor != null) {
            System.out.println("Conductor encontrado: " + conductor.toString());
        } else {
            System.out.println("Conductor no encontrado con la cedula: " + cedulaConductor);
        }
        return conductor;
    }

    public void asignarRutaAConductor() {
        // Solicitar cédula del conductor
        System.out.println("Ingrese la cédula del conductor para asignar una ruta:");
        int cedulaConductor = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        System.out.println("Ingrese el ID de la ruta que desea asignar al conductor:");
        int idRuta = sc.nextInt();
        sc.nextLine();
        // Llamar al método con parámetros para realizar la asignación
        asignarRutaAConductor(cedulaConductor, idRuta);
    }

    public boolean asignarRutaAConductor(int cedulaConductor, int idRuta) {
        Conductor conductor = buscarElemento(cedulaConductor);
        //Buscar conductor por cedula
        if (conductor == null) {
            System.out.println("Conductor no encontrado");
            return false;
        }
        //Verificar el limite de 5 rutas asignadas por conductor
        if (conductor.getRutasAsignadas().size() >= 5) {
            System.out.println("El conductor ya tiene el maximo de rutas asignadas");
            return false;
        }
        //Buscar la ruta por ID
        Ruta ruta = controlRutas.buscarRutaPorId(idRuta);
        if (ruta == null) {
            System.out.println("Ruta no encontrada con el ID proporcionado");
            return false;
        }
        //Verificar si el conductor tiene la ruta asignada
        if (conductor.getRutasAsignadas().contains(ruta)) {
            System.out.println("Este conductor ya tiene esta ruta asignada");
            return false;
        }
        conductor.getRutasAsignadas().add(ruta);
        ruta.agregarConductor(conductor);
        System.out.println("Ruta asignada exitosamente al conductor: " + conductor.getNombre());
        return true;
    }

    public void listarConductor(){
        if(elementos.isEmpty()){
            System.out.println("No hay Conductores Agregados");
        } else {
            System.out.println("LISTADO DE CONDUCTORES REGISTRADOS");
            int contador =1;
            for (Conductor conductor:elementos){
                System.out.println("Conductor # "+contador+" :");
                System.out.println(conductor);
                System.out.println("----------------------------------------");
                contador++;
            }
        }
    }
    @Override
    protected Object obtenerIdentificador(Conductor conductor) {
        return (Conductor) buscarElementoPorObjeto(conductor);
    }
}
