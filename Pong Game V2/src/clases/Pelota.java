package clases;

import javax.swing.Timer;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pelota {
    private int x;
    private int y;
    private final int ANCHO = 15, ALTO = 15;
    private int dx = 1, dy = 1;
    private float velocidad = 1; // Velocidad inicial

    private Integer puntaje1 = 0, puntaje2 = 0;
    public static boolean finJuego = false;

    private Timer velocidadTimer;

    public Pelota(int x, int y) {
        this.x = x;
        this.y = y;

        // Configurar el Timer para incrementar la velocidad cada 15 segundos
        velocidadTimer = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incrementarVelocidad();
            }
        });
        velocidadTimer.start();
    }

    public Rectangle2D getPelota() {
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }

    public void mover(Rectangle limites, boolean colisionR1, boolean colisionR2) {
        x += dx * velocidad;
        y += dy * velocidad;

        if (colisionR1) {
            dx = -dx;
            x = 25;
        }

        if (colisionR2) {
            dx = -dx;
            x = 740;
        }

        if (x < limites.getMinX()) {
            puntaje2++;
            resetearPosicion(limites);
        }

        if (x + ANCHO >= limites.getMaxX()) {
            puntaje1++;
            resetearPosicion(limites);
        }

        if (y < limites.getMinY()) {
            y = (int) limites.getMinY();
            dy = -dy;
        }

        if (y + ALTO >= limites.getMaxY()) {
            y = (int) (limites.getMaxY() - ALTO);
            dy = -dy;
        }
    }

    private void resetearPosicion(Rectangle limites) {
        x = (int) limites.getCenterX() - (ANCHO / 2);
        y = (int) limites.getCenterY() - (ALTO / 2);
        dx = -dx; // Revertir la dirección horizontal
    }

    private void incrementarVelocidad() {
        velocidad += 0.5; // Incrementar la velocidad en 1
        System.out.println("Nueva velocidad: " + velocidad); // Debugging
    }

    
    public int getScore1() {
        return puntaje1;
    }

    public int getScore2() {
        return puntaje2;
    }
}
