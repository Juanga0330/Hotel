package Modelo;
import java.util.*;

class Hotel {
    private String nombre;
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;
    
    public Hotel(String nombre) {
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
        

        habitaciones.add(new Habitacion(101, "Simple", 100, true));
        habitaciones.add(new Habitacion(102, "Doble", 200, true));
        habitaciones.add(new Habitacion(201, "Suite", 350, true));
    }
    
    public List<Habitacion> getHabitacionesDisponibles() {
        List<Habitacion> disponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.isDisponible()) {
                disponibles.add(habitacion);
            }
        }
        return disponibles;
    }
    
    public Habitacion buscarHabitacion(int numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero && habitacion.isDisponible()) {
                return habitacion;
            }
        }
        return null;
    }
    
    public void crearReserva(Reserva reserva) {
        reservas.add(reserva);
        reserva.getHabitacion().setDisponible(false);
    }
    
    public List<Reserva> getReservas() { return reservas; }
    public String getNombre() { return nombre; }
}
