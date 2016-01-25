/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.riflemansd.jxsortabletable;

import java.awt.*;
import javax.swing.*;

/**
 * @version 1.0 02/26/99
 */
public class BlankIcon implements Icon {

    private Color fillColor;
    private int size;

    public BlankIcon() {
        this(null, 11);
    }

    public BlankIcon(Color color, int size) {
    //UIManager.getColor("control")
        //UIManager.getColor("controlShadow")
        fillColor = color;

        this.size = size;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (fillColor != null) {
            g.setColor(fillColor);
            g.drawRect(x, y, size - 1, size - 1);
        }
    }

    public int getIconWidth() {
        return size;
    }

    public int getIconHeight() {
        return size;
    }
}
