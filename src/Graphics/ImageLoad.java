/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;

/**
 *
 * @author HOME
 */
public class ImageLoad extends Canvas {
    
    Image img;
    JComponent component;

    public void setComponent(JComponent component){
        this.component = component;
    }
    
    public ImageLoad(Image img) {
        this.img = img;
    }

    public void paint(Graphics g) {
        if (img != null) {
            g.drawImage(img, 100, 400, new Color(255, 255, 255, 255), component);
        }
    }

    public void setImage(Image img) {
        this.img = img;
    }
}
