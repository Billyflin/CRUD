import vista.CrearPersona;
import vista.MostrarTrabajadores;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
       runList();
    }

    public static void runCreator(){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CrearPersona GUI =  new CrearPersona();
                GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GUI.setVisible(true);
            }
        });
    }
    public static void runList(){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MostrarTrabajadores GUI =  new MostrarTrabajadores();
                GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GUI.setVisible(true);
            }
        });
    }
}
