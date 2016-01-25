/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.riflemansd.jxsortabletable.example;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.jdesktop.swingx.JXTable;
import org.riflemansd.jxsortabletable.JXSortableTable;

/**
 *
 * @author sotir
 */
public class Test2 {
    
    public static void main(String[] args) {
        JFrame f = new JFrame("SortableTable Example");
        
        
        f.getContentPane().add(new JXSTable(), BorderLayout.CENTER);
        f.setSize(400, 160);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
