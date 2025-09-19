package Modelo; 
import java.time.LocalDateTime;

public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private int diasEstadia;
    private double costoTotal;
    
    public Reserva(Cliente cliente, Habitacion habitacion, LocalDateTime fechaEntrada, int diasEstadia) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.diasEstadia = diasEstadia;
        this.fechaSalida = fechaEntrada.plusDays(diasEstadia);
        this.costoTotal = habitacion.getPrecio() * diasEstadia;
    }
    
    public Cliente getCliente() { return cliente; }
    public Habitacion getHabitacion() { return habitacion; }
    public LocalDateTime getFechaEntrada() { return fechaEntrada; }
    public LocalDateTime getFechaSalida() { return fechaSalida; }
    public double getCostoTotal() { return costoTotal; }
    
    @Override
    public String toString() {
        return "Cliente: " + cliente.getNombre() + " | Habitación: " + habitacion.getNumero() + 
               " | Entrada: " + fechaEntrada.toLocalDate() + " | Salida: " + fechaSalida.toLocalDate() + 
               " | Total: $" + costoTotal;
    }
}