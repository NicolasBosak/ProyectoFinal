package Interfaz;

public class Perro{
    String nombre;
    int edad;
    String raza;
    double peso;
    boolean salud;
    int diallegada;
    int mesllegada;
    int aniollegada;
    String declaracionRescate;

    public Perro(String nombre, int edad, String raza, double peso, boolean salud, int diallegada, int mesllegada, int aniollegada, String declaracionRescate) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.peso = peso;
        this.salud = salud;
        this.diallegada = diallegada;
        this.mesllegada = mesllegada;
        this.aniollegada = aniollegada;
        this.declaracionRescate = declaracionRescate;
    }
 
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

    public int getDiallegada() {
        return diallegada;
    }

    public void setDiallegada(int diallegada) {
        this.diallegada = diallegada;
    }

    public int getMesllegada() {
        return mesllegada;
    }

    public void setMesllegada(int mesllegada) {
        this.mesllegada = mesllegada;
    }

    public int getAniollegada() {
        return aniollegada;
    }

    public void setAniollegada(int aniollegada) {
        this.aniollegada = aniollegada;
    }

    public String getDeclaracionRescate() {
        return declaracionRescate;
    }

    public void setDeclaracionRescate(String declaracionRescate) {
        this.declaracionRescate = declaracionRescate;
    }
}