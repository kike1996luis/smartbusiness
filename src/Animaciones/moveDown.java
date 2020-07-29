/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animaciones;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author HOME
 */
public class moveDown extends Thread{
    
    private int yInit;
    private int yFinal;
    private int time;
    private JComponent component;
    private final int pixels;

    public moveDown(int yInit, int yFinal, int time, int pixels, JComponent panel_menu) {
        this.yInit = yInit;
        this.yFinal = yFinal;
        this.time = time;
        this.component = panel_menu;
        this.pixels = pixels;
    }
    
    public void run() {
        while(component.getY() < yFinal) {
            try {
                Thread.sleep( time );
            } catch (InterruptedException ex) {
                Logger.getLogger(moveRight.class.getName()).log(Level.SEVERE, null, ex);
            }
            component.setLocation(component.getX(), component.getY()+pixels);
        }
    }
}
