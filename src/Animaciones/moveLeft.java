/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animaciones;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 *
 * @author HOME
 */
public class moveLeft extends Thread{
    private int xInit;
    private int xFinal;
    private int time;
    private JComponent component;
    private final int pixels;

    public moveLeft(int xInit, int xFinal, int time, int pixels, JComponent panel_menu) {
        this.xInit = xInit;
        this.xFinal = xFinal;
        this.time = time;
        this.component = panel_menu;
        this.pixels = pixels;
    }
    
    public void run() {
        while(component.getX() > xFinal) {
            try {
                Thread.sleep( time );
                } catch (InterruptedException ex) {
                    Logger.getLogger(moveRight.class.getName()).log(Level.SEVERE, null, ex);
                }
            component.setLocation(component.getX()-pixels, component.getY());
        }
    }
}
