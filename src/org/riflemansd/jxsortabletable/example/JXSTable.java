/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.riflemansd.jxsortabletable.example;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import org.riflemansd.jxsortabletable.JXSortableTable;

/**
 *
 * @author sotir
 */
public class JXSTable extends javax.swing.JPanel {

    /**
     * Creates new form JXTable
     */
    public JXSTable() {
        initComponents();
        
        JXSortableTable table = new JXSortableTable("ID,Name,Cost", 0, "string", 1000);
        table.addRow(0, "George", 1000);
        table.addRow(1, "Pete", 1200);
        table.addRow(2, "Jonh", 950);
        
        JScrollPane pane = new JScrollPane(table);
        
        add(pane, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
