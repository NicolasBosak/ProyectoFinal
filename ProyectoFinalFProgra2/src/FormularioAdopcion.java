import com.sun.jdi.Value;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FormularioAdopcion {
    private JTabbedPane tabbedPane1;
    private JTextField NombreUsuario;
    private JTextField CedulaUsuario;
    private JTextField Dia;
    private JTextField Mes;
    private JTextField Anio;
    private JButton registrarUsuarioButton;
    private JTextField NombreAnimal;
    private JTextArea ConceptoAnimal;
    private JButton registrarAnimalButton;
    private JComboBox UsuarioAdopta;
    private JComboBox MascotaAdopta;
    private JButton adoptarButton;
    private JTextField cedConsulta;
    private JTextField nomConsulta;
    private JButton consultarPorDatosButton;
    private JTextArea resulConsulta;
    private JTextArea UsuariosRegistrados;
    private JComboBox UsuarioDeja;
    private JComboBox estadoSalud;
    private JButton consultaGeneralAnimalesButton;
    private JButton consultaGeneralUsuariosButton;
    private JPanel Olis;
    private JTextField RazaAnimal;
    private JTextField PesoAnimal;
    private JTextField EdadEstimada;
    private List<Usuario> usuarios = new ArrayList<>();
    private RegistroAnimal registro = new RegistroAnimal(usuarios);

    public FormularioAdopcion() {
    registrarUsuarioButton.addActionListener(e -> {


        try {
            String nombre = NombreUsuario.getText();
            String cedula = CedulaUsuario.getText();
            int dia = Integer.parseInt(Dia.getText());
            int mes = Integer.parseInt(Mes.getText());
            int anio = Integer.parseInt(Anio.getText());



                    Usuario usuario = new Usuario(nombre, cedula, dia, mes, anio);

                    if (!usuarioExiste(usuario)) {
                        UsuariosRegistrados.setText("");
                        usuarios.add(new Usuario(nombre, cedula, dia, mes, anio));
                        initCboUsuarios();
                        registro.actualizarUsuarios(usuarios);
                        usuarios.forEach(x -> {
                            System.out.println(x.toString());
                            UsuariosRegistrados.append(x.toString());
                        });
                    } else
                        JOptionPane.showMessageDialog(null, "El usuario ya existe.");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }


    });

        //Panel de registro
        registrarAnimalButton.addActionListener(e -> {
            try {
                int indexUsuario = UsuarioDeja.getSelectedIndex();
                String nombre = NombreAnimal.getText();
                String raza = RazaAnimal.getText();
                float peso = Float.parseFloat(PesoAnimal.getText());
                int edad = Integer.parseInt(EdadEstimada.getText());
                LocalDate fechaIngreso = LocalDate.now();
                boolean salud = (estadoSalud.getSelectedItem().toString().equals("Sano"));
                String descripcion = ConceptoAnimal.getText();

                usuarios.get(indexUsuario).darAnimales().add(new Animal(nombre, raza, peso, edad, salud, descripcion));
                registro.actualizarUsuarios(usuarios);
                System.out.println(usuarios.get(indexUsuario).darAnimales().size());
                JOptionPane.showMessageDialog(null, "Agregado.");
                initCboAnimales();
                limpiarCamposRegistroAnimal();
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        //Panel de adopcion
        adoptarButton.addActionListener(e -> {
            try {
                int indexUsuario = UsuarioAdopta.getSelectedIndex();
                int indexAnimal = MascotaAdopta.getSelectedIndex();
                Animal animal = usuarios.get(indexUsuario).darAnimales().get(indexAnimal);
                usuarios.get(indexUsuario).adoptar(animal, registro);
                initCboAnimales();
                JOptionPane.showMessageDialog(null, "Adoptado");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        consultarPorDatosButton.addActionListener(e -> {
            try {
                String cedula = cedConsulta.getText();
                int indexUsuario = buscarUsuario(cedula);
                resulConsulta.setText(registro.imprimirDatos(indexUsuario));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        consultaGeneralAnimalesButton.addActionListener(e -> {
            if(usuarios.size() != 0)
                resulConsulta.setText(registro.imprimirDatosGenerales());
            else resulConsulta.setText("No hay usuarios diponibles.");
        });

        consultaGeneralUsuariosButton.addActionListener(e -> {
            if(usuarios.size() != 0)
                resulConsulta.setText(registro.obtenerEstadisticas());
            else resulConsulta.setText("No hay usuarios diponibles.");
        });
    }

    private void limpiarCamposRegistroAnimal() {
        UsuarioDeja.setSelectedIndex(0);
        NombreAnimal.setText("");
        RazaAnimal.setText("");
        PesoAnimal.setText("");
        EdadEstimada.setText("");
        estadoSalud.setSelectedIndex(0);
        ConceptoAnimal.setText("");
    }

    private boolean usuarioExiste(Usuario usuario) {
        System.out.println(usuarios.stream().anyMatch(x -> x.darCedula().equals(usuario.darCedula())));
        return usuarios.stream().anyMatch(x -> x.darCedula().equals(usuario.darCedula()));
    }

    private int buscarUsuario(String cedula) throws Exception {
        int index = -1;
        for(int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).darCedula().equals(cedula)) {
                index = i;
                break;
            }
        }

        if(index == -1)
            throw new Exception("No se encontró el usuario");
        else
            return index;
    }

    public boolean validarTexto(String texto) {
        return texto.matches("^[a-zA-Z]+$");
    }


    private void initCboUsuarios() {
        UsuarioDeja.removeAllItems();
        UsuarioAdopta.removeAllItems();

        usuarios.forEach(x -> {
            UsuarioDeja.addItem(x.darNombre() + " | " + x.darCedula());
            UsuarioAdopta.addItem(x.darNombre() + " | " + x.darCedula());
        });
    }

    private void initCboAnimales() {
        MascotaAdopta.removeAllItems();
        int indexUsuario = UsuarioAdopta.getSelectedIndex();
        List<Animal> animales = usuarios.get(indexUsuario).darAnimales();
        animales.stream().filter(x -> !x.darAdopcion() && x.darSalud()).forEach(x -> MascotaAdopta.addItem(x));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormularioAdopcion");
        frame.setContentPane(new FormularioAdopcion().Olis);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
