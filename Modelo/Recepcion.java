package Modelo;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Recepcion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel("Hotel Java");
        hotel.cargarHabitacionesDesdeCSV("habitaciones.csv");

        Cliente cliente = null;
        Reserva reserva = null;
        int opcion;

        do {
            System.out.println("\n===== MENÚ HOTEL =====");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Ver Habitaciones");
            System.out.println("3. Hacer Reserva");
            System.out.println("4. Ver Reserva");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el documento del cliente: ");
                    String documento = scanner.nextLine();
                    cliente = new Cliente(nombre, documento);
                    System.out.println(" Cliente creado: " + cliente);
                    break;

                case 2:
                    System.out.println("Habitaciones disponibles:");
                    for (Habitacion h : hotel.getHabitaciones()) {
                        System.out.println(h);
                    }
                    break;

                case 3:
                    if (cliente == null) {
                        System.out.println(" Primero debe crear un cliente.");
                        break;
                    }
                    System.out.println("Seleccione número de habitación:");
                    for (Habitacion h : hotel.getHabitaciones()) {
                        if (h.isDisponible()) {
                            System.out.println(h.getNumero() + " - " + h.getTipo() + " - $" + h.getPrecio());
                        }
                    }
                    int numHab = scanner.nextInt();
                    scanner.nextLine();

                    Habitacion habitacionSeleccionada = null;
                    for (Habitacion h : hotel.getHabitaciones()) {
                        if (h.getNumero() == numHab && h.isDisponible()) {
                            habitacionSeleccionada = h;
                            break;
                        }
                    }

                    if (habitacionSeleccionada == null) {
                        System.out.println("⚠️ Habitación no válida o no disponible.");
                        break;
                    }

                    System.out.print("Ingrese cantidad de días de estadía: ");
                    int dias = scanner.nextInt();
                    scanner.nextLine();

                    reserva = new Reserva(
                            cliente,
                            habitacionSeleccionada,
                            LocalDateTime.now(),
                            dias
                    );
                    System.out.println(" Reserva creada: " + reserva);
                    break;

                case 4:
                    if (reserva == null) {
                        System.out.println("No hay reservas realizadas.");
                    } else {
                        System.out.println("Reserva actual:");
                        System.out.println(reserva);
                    }
                    break;

                case 0:
                    System.out.println(" Gracias por usar el sistema.");
                    break;

                default:
                    System.out.println(" Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}