package clases;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Ventana extends JFrame implements Temporizador.TemporizadorListener {
      
   private final int ANCHO=800, ALTO=500;
  
   private TableroJuego lamina;
   
   private Hilo hilo;
   
   private Temporizador temporizador;
   
   
   
    public Ventana (){
        
        setTitle("PONG");
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(null);
        setResizable(false);
        
        lamina = new TableroJuego();
        getContentPane().add(lamina, BorderLayout.CENTER);
        addKeyListener(new EventoTeclado());
 
        
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        hilo = new Hilo(lamina);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 330, 30);
        lamina.add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(454, 0, 330, 30);
        lamina.add(panel_1);
        hilo.start();
        
        temporizador = new Temporizador(this);
        temporizador.start();
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/PONG.png")));
     
    }
    
    @Override
    public void onTiempoActualizado(int tiempoRestante) {
        
    }

    @Override
    public void onTiempoFinalizado() {
        
    }
    
}
