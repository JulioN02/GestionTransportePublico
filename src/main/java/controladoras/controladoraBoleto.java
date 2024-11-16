package controladoras;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import logica.Boleto;
import logica.Pasajero;
import logica.Ruta;
public class controladoraBoleto extends controles<Boleto> {

    private List<Boleto> boletos;
    private final Scanner sc;
    controladoraRutas controlRuta;
    controladoraPasajero controlPasajero;

    public controladoraBoleto() {
        super();
        sc = new Scanner(System.in);
        controlRuta = new controladoraRutas();
        controlPasajero = new controladoraPasajero();
        boletos = new ArrayList<>();
    }

    public void crearBoleto() {
        System.out.println("Ingrese el ID del Boleto");
        int idBoleto = sc.nextInt();
        sc.nextLine();

        //Verificar si el boleto ya existe
        if (buscarElemento(idBoleto) != null) {
            System.out.println("El ID del boleto ya esta en uso. Intente con otro");
            return;
        }

        Date fecha = obtenerFecha();

        System.out.println("Ingrese el precio del boleto");
        double precio = sc.nextDouble();
        sc.nextLine();

        System.out.println("Ingrese la Cedula del pasajero");
        int cedulaPasajero = sc.nextInt();
        sc.nextLine();

        Pasajero pasajero = controlPasajero.buscarPasajeroPorCedula(cedulaPasajero);
        if (pasajero == null) {
            System.out.println("Pasajero no encontrado");
            return;
        }

        System.out.println("Ingrese el ID de la Ruta");
        int idRuta = sc.nextInt();
        Ruta ruta = controlRuta.buscarRutaPorId(idRuta);
        if (ruta == null) {
            System.out.println("Ruta no encontrada");
            return;
        }

        Boleto boleto = new Boleto(idBoleto, fecha, precio, pasajero, ruta);
        agregarElemento(boleto);
        pasajero.getBoletosComprados().add(boleto);
        System.out.println("Boleto creado y asignado al pasajero");
    }

    public void actualizarBoleto() {
        System.out.println("Ingrese el ID del boleto a Actualizar");
        int idBoleto = sc.nextInt();
        sc.nextLine(); //Limpiar Buffer
        Boleto boletoExistente = buscarElemento(idBoleto);
        if (boletoExistente != null) {
            System.out.println("Ingrese la nueva fecha");
            Date fecha = obtenerFecha();
            double precio = sc.nextDouble();
            sc.nextLine();
            System.out.print("Ingrese la nueva Cedula del pasajero: ");
            int cedulaPasajero = sc.nextInt();
            sc.nextLine();
            Pasajero pasajero = controlPasajero.buscarPasajeroPorCedula(cedulaPasajero);
            System.out.print("Ingrese el nuevo ID de la ruta: ");
            int idRuta = sc.nextInt();
            sc.nextLine();
            Ruta ruta = controlRuta.buscarRutaPorId(idRuta);
            if (pasajero != null && ruta != null) {
                Boleto boletoActualizado = new Boleto(idBoleto, fecha, precio, pasajero, ruta);
                actualizarElemento(idBoleto, boletoActualizado);
                System.out.println("Boleto actualizado exitosamente.");
            } else {
                System.out.println("Pasajero o Ruta no encontrados");
            }
        } else {
            System.out.println("Boleto no encontrado");
        }
    }

    public void buscarBoleto() {
        System.out.println("Ingrese el ID del boleto a buscar:");
        int idBoleto = sc.nextInt();
        sc.nextLine();
        Boleto boleto = buscarBoletoPorId(idBoleto);
        if (boleto != null) {
            System.out.println("Boleto encontrado: " + boleto);
        } else {
            System.out.println("Boleto no encontrado");
        }
    }
    
    public void eliminarBoleto(){
        System.out.println("Ingrese el Codigo del Boleto que quiere Eliminar");
        int idBoleto=sc.nextInt();
        sc.nextLine();
        Boleto boleto = buscarBoletoPorId(idBoleto);
        if (boleto!=null){
            eliminarElemento(boleto.getId());
            System.out.println("Boleto Eliminado Exitosamente");
        } else {
            System.out.println("No se encontro Boleto emitido con el Codigo: "+idBoleto);
        }
    }
    
    public Boleto buscarBoletoPorId(int idBoleto){
        return (Boleto) buscarElemento(idBoleto);
    }

    //METODO PARA OBTENER LA FECHA CON EL FORMATO ADECUADO
    private Date obtenerFecha() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        while (fecha == null) {
            System.out.print("Ingrese la fecha (yyyy-MM-dd): ");
            String fechaStr = sc.nextLine();
            try {
                // Intenta parsear la fecha
                fecha = dateFormat.parse(fechaStr);
            } catch (ParseException e) {
                // Muestra un mensaje de error y vuelve a pedir la fecha
                System.out.println("Formato incorrecto. Ingrese la fecha nuevamente en el formato yyyy-MM-dd.");
            }
        }
        return fecha;
    }

    @Override
    protected Object obtenerIdentificador(Boleto boleto) {
        return (Boleto) buscarElementoPorObjeto(boleto);
    }
    
    public void listaBoletosRuta(){
        System.out.println("Ingrese el Codigo de la Ruta de la cual desea ver su lista de Boletos");
        int idRuta = sc.nextInt();
        sc.nextLine();
        Ruta rutaEncontrada = controlRuta.buscarRutaPorId(idRuta);
        if (rutaEncontrada == null) {
            System.out.println("La ruta con Codigo: "+idRuta+" no existe");
            return; // Salir del metodo si no hay ruta
        }
        List<Boleto> boletosDeRuta = rutaEncontrada.getBoletosEmitidos();
        
        if(boletosDeRuta==null || boletosDeRuta.isEmpty()){
            System.out.println("No hay boletos emitidos para la ruta con Codigo: "+idRuta);
            return;
        }
        
        System.out.println("Boletos emitidos para la ruta con Codigo: "+idRuta);
        for(Boleto boleto :boletosDeRuta){
            System.out.println("Codigo Boleto: "+boleto.getIdBoleto()+"| Pasajero: "+boleto.getPasajero().getNombre());
        }
    }

    public void listaPasajerosRuta(int idRuta) {
        // Buscar la ruta por ID
        Ruta rutaEncontrada = controlRuta.buscarRutaPorId(idRuta);
        // Validar si la ruta existe
        if (rutaEncontrada == null) {
            System.out.println("La ruta con Codigo: "+idRuta+" no existe");
            return; // Salir del metodo si no hay ruta
        }
        // Obtener la lista de boletos emitidos
        List<Boleto> boletosDeRuta = rutaEncontrada.getBoletosEmitidos();
        // Validar si hay boletos
        if (boletosDeRuta == null || boletosDeRuta.isEmpty()) {
            System.out.println("No hay boletos emitidos para la ruta con Codigo: "+idRuta);
            return; // Salir del metodo si no hay boletos
        }
        // Mostrar información de cada pasajero
        System.out.println("Pasajeros en la ruta con Codigo: "+idRuta);
        for (Boleto boleto : boletosDeRuta) {
            Pasajero pasajeroRuta = boleto.getPasajero();
            if (pasajeroRuta != null) { // Validamos que el pasajero no sea nulo
                System.out.println("Cédula: "+pasajeroRuta.getCedula()+"Nombre: "+pasajeroRuta.getNombre());
            } else {
                System.out.println("-Boleto sin pasajero asociado");
            }
        }
    }
}
