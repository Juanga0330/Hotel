package Modelo;
import java.time.LocalDateTime;
import java.util.*;

public class Recepcion {
    private Hotel hotel;
    private Scanner scanner;
    
    public Recepcion() {
        hotel = new Hotel("Hotel Paradise");
        scanner = new Scanner(System.in);
    }
    
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== " + hotel.getNombre() + " ===");
            System.out.println("1. Listar habitaciones disponibles");
            System.out.println("2. Crear reserva");
            System.out.println("3. Mostrar reservas");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1: listarHabitaciones(); break;
                case 2: crearReserva(); break;
                case 3: mostrarReservas(); break;
            }
        } while (opcion != 0);
    }
    
    private void listarHabitaciones() {
        System.out.println("\n=== HABITACIONES DISPONIBLES ===");
        List<Habitacion> disponibles = hotel.getHabitacionesDisponibles();
        for (Habitacion habitacion : disponibles) {
            System.out.println(habitacion);
        }
    }
    
    private void crearReserva() {
        System.out.print("Nombre cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();
        
        Cliente cliente = new Cliente(nombre, cedula);
        
        listarHabitaciones();
        System.out.print("Número de habitación: ");
        int numero = scanner.nextInt();
        
        Habitacion habitacion = hotel.buscarHabitacion(numero);
        if (habitacion == null) {
            System.out.println("Habitación no disponible");
            return;
        }
        
        System.out.print("Días de estadía: ");
        int dias = scanner.nextInt();
        
        LocalDateTime fechaEntrada = LocalDateTime.now().plusDays(1).withHour(15).withMinute(0);
        Reserva reserva = new Reserva(cliente, habitacion, fechaEntrada, dias);
        
        hotel.crearReserva(reserva);
        System.out.println("Reserva creada: " + reserva);
    }
    
    private void mostrarReservas() {
        System.out.println("\n=== RESERVAS ===");
        for (Reserva reserva : hotel.getReservas()) {
            System.out.println(reserva);
        }
    }
    
    public static void main(String[] args) {
        new Recepcion().mostrarMenu();
    }
}