import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Usuario{
    private String nombre;
    private String apellido;
    private String cedula;
    private LocalDate fechaNacimiento;

    public static ArrayList<String> usuarios = new ArrayList<>();
    public Usuario(String nombre, String apellido, String cedula, String fechaNacimientoStr){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
    }

    public int calcularEdad() {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }

    public String getNombre() {
        return nombre;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }
}
