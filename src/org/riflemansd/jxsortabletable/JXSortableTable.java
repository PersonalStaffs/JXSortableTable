package org.riflemansd.jxsortabletable;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import javax.swing.*;
import javax.swing.table.*;
import org.jdesktop.swingx.JXTable;

/**
 * JXSortableTable 
 * A JXTable that can be sorted by every column by clicking at header
 * Sort depend on column values: 
 * Numeric values will be sorted as numeric
 * String values will be sorted alpharithmetic
 * Date values will be sorted as Dates
 * etc
 * 
 * (c) Copyright | Sotiris Doudis | 2015-2016
 * Github: RiflemanSD - https://github.com/RiflemanSD
 * 
 * @author RiflemanSD
 * @version 1.0 - 25/1/2016
 */
public class JXSortableTable extends JXTable {
    private Class[] classes;
    private int numberOfColumns;

    public JXSortableTable(String columns, Object... dataTypes) {
        
        //setLayout(new BorderLayout());
        String[] c = columns.split(",");
        numberOfColumns = c.length;
        classes = new Class[numberOfColumns];

        for (int i = 0; i < numberOfColumns; i++) {
            if (i >= dataTypes.length) {
                classes[i] = String.class;
            } else if (dataTypes[i] instanceof Integer) {
                classes[i] = Integer.class;
            } else if (dataTypes[i] instanceof Double) {
                classes[i] = Double.class;
            } else if (dataTypes[i] instanceof Float) {
                classes[i] = Float.class;
            } else if (dataTypes[i] instanceof Long) {
                classes[i] = Long.class;
            } else if (dataTypes[i] instanceof String) {
                classes[i] = String.class;
            } else if (dataTypes[i] instanceof Date) {
                classes[i] = Date.class;
            } else {
                classes[i] = String.class;
            }
        }

        SortableTableModel dm = new SortableTableModel() {
            public Class getColumnClass(int col) {
                return classes[col];
            }

            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        for (int j = 0; j < numberOfColumns; j++) {
            dm.addColumn(c[j]);
        }

        this.setModel(dm);
        //table.setShowGrid(true);
        this.setShowVerticalLines(true);
        this.setShowHorizontalLines(true);
        SortButtonRenderer renderer = new SortButtonRenderer();
        TableColumnModel model = this.getColumnModel();

        for (int i = 0; i < numberOfColumns; i++) {
            model.getColumn(i).setHeaderRenderer(renderer);
            //model.getColumn(i).setPreferredWidth(columnWidth[i]);
        }

        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JTableHeader header = this.getTableHeader();
        header.removeMouseListener(header.getMouseListeners()[2]);
        header.addMouseListener(new HeaderListener(header, renderer));

        this.getTableHeader().setReorderingAllowed(false);
    }

    public void addRow(Object... objects) {
        SortableTableModel m = (SortableTableModel) this.getModel();

        m.addRow(objects);

        this.packAll();
    }

    private static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.JAPAN);

    private static Date getDate(String dateString) {
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException ex) {
            date = new Date();
        }
        return date;
    }

    class HeaderListener extends MouseAdapter {

        JTableHeader header;
        SortButtonRenderer renderer;

        HeaderListener(JTableHeader header, SortButtonRenderer renderer) {
            this.header = header;
            this.renderer = renderer;
        }

        public void mousePressed(MouseEvent e) {
            int col = header.columnAtPoint(e.getPoint());
            int sortCol = header.getTable().convertColumnIndexToModel(col);
            renderer.setPressedColumn(col);
            renderer.setSelectedColumn(col);
            header.repaint();

            if (header.getTable().isEditing()) {
                header.getTable().getCellEditor().stopCellEditing();
            }

            boolean isAscent;
            if (SortButtonRenderer.DOWN == renderer.getState(col)) {
                isAscent = true;
            } else {
                isAscent = false;
            }
            ((SortableTableModel) header.getTable().getModel())
                    .sortByColumn(sortCol, isAscent);
        }

        public void mouseReleased(MouseEvent e) {
            int col = header.columnAtPoint(e.getPoint());
            renderer.setPressedColumn(-1);                // clear
            header.repaint();
        }
    }
}
