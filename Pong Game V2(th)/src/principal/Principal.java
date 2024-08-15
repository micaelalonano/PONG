package principal;

import clases.Ventana;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;


public class Principal {
   
    public static void main(String[] args) {
        
        Ventana ventana = new Ventana();
        ventana.getContentPane().setForeground(new Color(0, 0, 0));
        ventana.getContentPane().setBackground(new Color(255, 255, 255));
        ventana.getContentPane().setLayout(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
}
