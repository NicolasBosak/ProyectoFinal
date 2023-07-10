import java.util.ArrayList;

public class Perro extends Usuario{

    private static final int CapacidadAlmacenamiento = 20;
    private static ArrayList<String> perros = new ArrayList<>();

    public Perro(String nombre, String apellido, String cedula, String fechaNacimientoStr, String nombre1, int edad, String raza, double peso, boolean salud, int diaLlegada, int mesLlegada, int anioLlegada, String declaracionRescate) {
        super(nombre, apellido, cedula, fechaNacimientoStr);
        this.nombre = nombre1;
        this.edad = edad;
        this.raza = raza;
        this.peso = peso;
        this.salud = salud;
        this.diaLlegada = diaLlegada;
        this.mesLlegada = mesLlegada;
        this.anioLlegada = anioLlegada;
        this.declaracionRescate = declaracionRescate;

    }

    private String nombre;
    private int edad;
    private String raza;
    private double peso;
    private boolean salud;
    private int diaLlegada;
    private int mesLlegada;
    private int anioLlegada;
    private String declaracionRescate;
    public static final int Tamano = 20;


    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isSalud() {
        return salud;
    }

    public void setSalud(boolean salud) {
        this.salud = salud;
    }

    public int getDiaLlegada() {
        return diaLlegada;
    }

    public void setDiaLlegada(int diaLlegada) {
        this.diaLlegada = diaLlegada;
    }

    public int getMesLlegada() {
        return mesLlegada;
    }

    public void setMesLlegada(int mesLlegada) {
        this.mesLlegada = mesLlegada;
    }

    public int getAnioLlegada() {
        return anioLlegada;
    }

    public void setAnioLlegada(int anioLlegada) {
        this.anioLlegada = anioLlegada;
    }

    public String getDeclaracionRescate() {
        return declaracionRescate;
    }

    public void setDeclaracionRescate(String declaracionRescate) {
        this.declaracionRescate = declaracionRescate;
    }
    public static boolean agregarPerro(String nombrePerro) {
        if (perros.size() < CapacidadAlmacenamiento) {
            perros.add(nombrePerro);
            return true;
        } else {
            return false;
        }
    }

    public static int contarPerros() {
        return perros.size();
    }

    public static ArrayList<String> getNombresPerros() {
        return perros;
    }
}
