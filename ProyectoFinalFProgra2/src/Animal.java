public class Animal {
    private String nombre;
    private String raza;
    private float peso;
    private int edad;
    private String descripcion;
    private boolean adopcion;
    private String nombreAdoptante;
    private boolean salud; //Si es True es sano, si es false es enfermo.

    public Animal(String nombre, String raza, float peso, int edad, boolean salud, String descripcion) throws Exception{
        if (nombre.matches(".*\\d.*")){
            throw new Exception("El nombre no puede contener numeros");
        }
        if (raza.matches(".*\\d.*")){
            throw new Exception("La raza no puede contener numeros");
        }
        if (peso < 0){
            throw new Exception("El peso no puede ser negativo");
        }
        if (edad < 0){
            throw new Exception("La edad no puede ser negativa");
        }

        this.nombre =nombre;
        this.raza =raza;
        this.peso =peso;
        this.edad =edad;
        this.salud = salud;
        this.descripcion =descripcion;
    }

    public String darNombre() {
        return this.nombre;
    }

    public String darRaza() {
        return this.raza;
    }

    public float darPeso() {
        return this.peso;
    }

    public int darEdad() {
        return this.edad;
    }

    public String darDescripcion() {
        return this.descripcion;
    }

    public boolean darSalud() {
        return this.salud;
    }

    public boolean darAdopcion() {
        return this.adopcion;
    }

    public void establecerAdopcion(boolean adopcion) {
        this.adopcion = adopcion;
    }
    public void establecerNombreAdoptante(String nombreAdoptante) {
        this.nombreAdoptante = nombreAdoptante;
    }

    public String toString( ) {
        String salud = (this.salud)? "sano" : "enfermo";
        String adopcion = (this.adopcion)? "adoptado" : "no adoptado";
        String contenido = "\nAnimal: " + this.nombre +
                "\nRaza: " + this.raza +
                "\nPeso: " + this.peso + "Kg" +
                "\nEdad: " + this.edad + " años" +
                "\nAdopción: " + adopcion +
                "\nSalud: " + salud;
        if(this.adopcion)
            contenido += "\nAdoptado por: " + nombreAdoptante;

        return contenido;
    }
}
