package clinicaveterinaria;

import Interfaz.PantallaUsuario;

public class ClinicaVeterinaria {
    public static void main(String[] args) {
       
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                
                PantallaUsuario pantallaU = new PantallaUsuario();
                pantallaU.setVisible(true);
            }
        });
    }
}
