import javax.management.ValueExp;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String cedula;
    private int diaNacimiento;
    private int mesNacimiento;
    private int anioNacimiento;
    private int calcEdad;
    private ArrayList<Animal> animals;

    public Usuario(String pNombre, String pCedula, int pDiaNacimiento, int pMesNacimiento, int pAnioNacimiento) throws Exception {
        if (pNombre.matches(".*\\d.*")){
            throw new Exception("El nombre no puede contener numeros");
        }
        int cedulaNumero = Integer.parseInt(pCedula);
        if (cedulaNumero < 0){
            throw new Exception ("El numero de cedula no puede ser negativo");
        }
        if (!validarCedula(pCedula)) {
            throw new IllegalArgumentException("La cedula no es valida");
        }


        this.cedula = pCedula;
        this.nombre = pNombre;
        this.diaNacimiento = pDiaNacimiento;
        this.mesNacimiento = pMesNacimiento;
        this.anioNacimiento = pAnioNacimiento;

        LocalDate fechaNacimiento = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        calcEdad = periodo.getYears();
        if (calcEdad < 18){
            throw new Exception("El usuario no es mayor a 18 años");
        }

        animals = new ArrayList<Animal>();
    }

    public String darNombre() {
        return nombre;
    }

    public String darCedula() {
        return cedula;
    }

    public int darCalcEdad() {
        return calcEdad;
    }

    public String toString() {
        return "\nNombre: " + this.nombre +
                "\nCedula: " + this.cedula +
                "\nFecha de nacimiento: " + this.diaNacimiento + "-" + this.mesNacimiento + "-" + this.anioNacimiento +
                "\nEdad: " + this.calcEdad;
    }


    public ArrayList<Animal> darAnimales() {
        return animals;
    }

//    public void actualizarAnimal(int index) {
//        animals.get(index).establecerAdopcion(true);
//    }

    private boolean validarCedula(String cedula) throws Exception{


        if (cedula.length() != 10){
            throw new Exception("La cedula debe tener 10 digitos");
        }
        int provincia= Integer.parseInt(cedula.substring(0,2));
        if (provincia<1 || provincia >24){
            throw new Exception("La cedula no conrresponde a ninguna provincia intente nuevamente");
        }

        int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
        if (tercerDigito < 0 || tercerDigito > 5) {
            return false;
        }

        int verificador = Integer.parseInt(cedula.substring(9));
        int suma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(cedula.charAt(i));
            if (i % 2 == 0) {
                digito *= 2;
                if (digito > 9) {
                    digito -= 9;
                }
            }
            suma += digito;
        }

        int residuo = suma % 10;
        int digitoVerificadorCalculado = residuo == 0 ? 0 : 10 - residuo;
        if (verificador != digitoVerificadorCalculado) {
            return false;
        }
        return true;
    }

    public void adoptar(Animal animal, RegistroAnimal registroAnimal) throws Exception {
        boolean puedeAdoptar = registroAnimal.puedeAdoptar(this, animal);

        if(puedeAdoptar)
            registroAnimal.actualizarAdoptados(this, animal);
        else
            throw new Exception("El animal no se puede adoptar.");
    }

}

