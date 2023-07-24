import java.time.LocalDate;
import java.util.*;

public class RegistroAnimal {

    Map<Integer, List<LocalDate>> fechas; //El integer representa la posicion del usuario
    List<Usuario> usuarios;


    public RegistroAnimal(List<Usuario> usuarios){
        this.usuarios = usuarios;
        this.fechas = new HashMap<>();
    }

    public void actualizarUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void actualizarAdoptados(Usuario usuario, Animal animal) throws Exception {
        int indexAnimal = buscarAnimal(usuarios.get(buscarUsuario(usuario)).darAnimales(), animal);
        int indexUsuario = buscarUsuario(usuario);
        try {
            usuarios.get(indexUsuario).darAnimales().get(indexAnimal).establecerAdopcion(true);
            usuarios.get(indexUsuario).darAnimales().get(indexAnimal).establecerNombreAdoptante(usuario.darNombre());
            if(!fechas.containsKey(indexUsuario))
                fechas.put(indexUsuario, List.of(LocalDate.now()));
            else fechas.get(indexUsuario).add(LocalDate.now());
        } catch (Exception e) {
            throw new Exception("No se encontró el usuario o el animal");
        }
    }

    public boolean puedeAdoptar(Usuario usuario, Animal animal) throws IndexOutOfBoundsException, NullPointerException {
        int indexAnimal = buscarAnimal(usuarios.get(buscarUsuario(usuario)).darAnimales(), animal);
        int indexUsuario = buscarUsuario(usuario);
        return usuarios.get(indexUsuario).darAnimales().get(indexAnimal).darSalud();
    }

    public String obtenerEstadisticas() {
        StringBuilder sb = new StringBuilder();

        for(Usuario user : usuarios) {
            sb.append(user.toString()).append("\n");
            List<Animal> animales = user.darAnimales();
            sb.append("Animales ingresados: " + animales.size());

            for(Animal aux : animales) {
                sb.append(aux.toString()).append("\n");
            }

        }

        return sb.toString();
    }

    public String imprimirDatos(int indexUsuario) {
        Usuario usuario = usuarios.get(indexUsuario);
        List<Animal> animales = usuario.darAnimales();
        String datos = "\nUsuario: " + usuario.darNombre() +
                "\nAnimales: \n";
        for(Animal animal : animales) {
            datos += "Fecha de ingreso: " + fechas.get(indexUsuario).toString() + "\n" + animal.toString();
        }

        return datos;
    }

    public String imprimirDatosGenerales() {
        StringBuilder sb = new StringBuilder();
        sb.append("No adoptados: ");

        for(Usuario user : usuarios) {
            user.darAnimales().forEach(x -> {
                if(!x.darAdopcion())
                    sb.append(x.toString());
            });
        }
        sb.append("\nAdoptados: ");
        for(Usuario user : usuarios) {
            user.darAnimales().forEach(x -> {
                if(x.darAdopcion())
                    sb.append(x.toString());
            });
        }

        return sb.toString();
    }

    private int buscarAnimal(List<Animal> animals, Animal animal) throws IndexOutOfBoundsException {
        System.out.println(animal);
        int i = 0;
        for(Animal temp : animals) {
            System.out.println(temp);
            if(temp.equals(animal))
                return i;
            i++;
        }
        return -1;
    }

    private int buscarUsuario(Usuario usuario) throws IndexOutOfBoundsException {
        System.out.println(usuario);
        int i = 0;
        for(Usuario user : usuarios) {
            System.out.println(user);
            if(usuario.equals(user))
                return  i;
            i++;
        }
        return -1;
    }


}
