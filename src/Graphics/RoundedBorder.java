/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;

/**
 *
 * @author HOME
 */
public class RoundedBorder extends AbstractBorder {

    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = 25;
        return insets;
    }

    public void paintBorder(Component c, Graphics g, int x, int y,
            int width, int height) {
        int w = width;
        int h = height;

        g.translate(x, y);
        //g.setColor(c.getBackground().darker());
        g.drawRoundRect(0, 0, w - 2, h - 2, 30, 30);
        g.translate(-x, -y);
    }

    public boolean isBorderOpaque() {
        return true;
    }
}
