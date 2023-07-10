import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int opc;

        System.out.println("Bienvenidos a nuestro Refugio.");
        System.out.println("REGISTRAR UN NUEVO USUARIO ");
        System.out.print("Ingrese el nombre: ");
        String Nombre = scanner.next();
        System.out.print("Ingrese el apellido: ");
        String Apellido = scanner.next();
        System.out.print("Ingrese el numero de cedula: ");
        String Cedula = scanner.next();
        System.out.print("Ingrese la fecha de nacimiento (dd/mm/yyyy): ");
        String FechaNacimiento = scanner.next();
        System.out.println("\n\nMENU DEL REFUGIO.");
        System.out.println("1. Ingresar un nuevo perro ");
        System.out.println("2. Registrar una donacion ");
        System.out.println("3. Adoptar perro ");

        opc = Integer.parseInt(scanner.next());
        switch (opc){
            case 1:{
                System.out.println("REGISTAR UN NUEVO PERRO.");
                System.out.print("Ingrese el nombre: ");
                String Nombre1 = scanner.next();
                System.out.print("Ingrese la edad: ");
                String edad = scanner.next();
                System.out.print("Ingrese el raza: ");
                String raza = scanner.next();

            }break;
            case 2:{
                System.out.println("REGISTRAR DONACION");
                System.out.println("Ingresar nombre: ");
                System.out.println("Ingresar cedula");
                System.out.println("Ingresar ");
            }
        }

        Usuario usuario = new Usuario(Nombre, Apellido, Cedula, FechaNacimiento);
        int edad = usuario.calcularEdad();

        System.out.println("\nNombre: "+usuario.getNombre()+" "+usuario.getApellido());
        System.out.println("Numero de cedula: "+usuario.getCedula());
        System.out.println("Fecha de nacimiento: " +usuario.getFechaNacimiento());
        System.out.println("Edad: " +edad);
    }
}