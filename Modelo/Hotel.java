package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private List<Habitacion> habitaciones;

    public Hotel(String nombre) {
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
    }


    public void cargarHabitacionesDesdeCSV(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                if (linea.startsWith("numero")) continue;

                String[] datos = linea.split(",");
                int numero = Integer.parseInt(datos[0]);
                String tipo = datos[1];
                double precio = Double.parseDouble(datos[2]);
                boolean disponible = Boolean.parseBoolean(datos[3]);

                Habitacion habitacion = new Habitacion(numero, tipo, precio, disponible);
                habitaciones.add(habitacion);
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error al leer archivo CSV: " + e.getMessage());
        }
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nombre='" + nombre + '\'' +
                ", habitaciones=" + habitaciones +
                '}';
    }
}
