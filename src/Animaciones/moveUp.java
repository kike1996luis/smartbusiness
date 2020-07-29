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
public class moveUp extends Thread{
    
    private int yInit;
    private int yFinal;
    private int time;
    private JComponent component;
    private final int pixels;
    private int width = 0;
    private int height = 0;

    public moveUp(int yInit, int yFinal, int time, int pixels, JComponent panel_menu, int width, int height) {
        this.yInit = yInit;
        this.yFinal = yFinal;
        this.time = time;
        this.component = panel_menu;
        this.pixels = pixels;
        this.width = width;
        this.height = height;
    }
    
    public void run() {
        while(component.getY() > yFinal) {
            try {
                Thread.sleep( time );
            } catch (InterruptedException ex) {
                Logger.getLogger(moveRight.class.getName()).log(Level.SEVERE, null, ex);
            }
            component.setLocation(component.getX(), component.getY()-pixels);
            component.setSize(width, height);
        }
    }
}
