/*
 * Copyright © Kai Hofbauer – All Rights Reserved
 * 
 * EN
 * Unauthorized copying of this software, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Kai Hofbauer kaihofbauer@icloud.com, October 2023
 * All components of this software that have not been newly developed (compilers, package sources and archives), as well as the development environment, have been expressly released by the manufacturers for commercial use.
 * The newly designed source code and its compilations, however, are newly created intellectual property of Kai Hofbauer for commercial use.
 * 
 * DE
 * Unerlaubtes Kopieren dieser Software, egal mit welchem Medium, ist strengstens verboten.
 * Proprietär und vertraulich
 * Geschrieben von Kai Hofbauer kaihofbauer@icloud.com, Oktober 2023
 * Alle nicht neu entwickelten Bestandteile (Compiler, Paketquellen und Archive) dieser Software, sowie die Entwicklungsumgebung sind von den Herstellern für die kommerzielle Nutzung ausdrücklich freigegeben.
 * Der neu entworfene Quellcode und seine Kompilierungen sind hingegen für den kommerziellen Gebrauch neu erschaffenes, geistiges Eigentum von Kai Hofbauer.
 * 
 * 
 * Verwendete Software:
 * •	Entwicklungsumgebung:		Apache NetBeans IDE 19	https://netbeans.apache.org/
 * •	Programmiersprache:		JAVA
 * •	JDK:				21			https://adoptium.net
 * 
 * 
 * © Kai Hofbauer – 2023
 */
package uk.wu.kh.mlsal.GUIs;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import uk.wu.kh.mlsal.Fields.DropField;
import uk.wu.kh.mlsal.Fields.Field;
import uk.wu.kh.mlsal.Fields.LadderField;
import uk.wu.kh.mlsal.Maps.Map;

/**
 * This GUI displays the logical game map to the user. You can prove the program
 * is working right with this reference list. The GUI contains a JTable, to
 * display all inforamtion right to the user I had to override the abstract
 * mehtods of the TableModel Interface. Everything is already Documented.
 * @see TableModel
 *
 * @author Kai Hofbauer
 */
public class MapView extends javax.swing.JFrame {

    /**
     * Creates new form MapView
     *
     * @param map
     */
    public MapView(Map map) {
        initComponents();

        jTable1.setModel(new TableModel() {
            @Override
            public int getRowCount() {
                return map.getField_array().size();
            }

            @Override
            public int getColumnCount() {
                return 4;
            }

            @Override
            public String getColumnName(int columnIndex) {
                switch (columnIndex) {
                    case 0 -> {
                        return "Array-Index";
                    }
                    case 1 -> {
                        return "Field-Type";
                    }
                    case 2 -> {
                        return "Field-Number";
                    }
                    case 3 -> {
                        return "Connected-Field-Number";
                    }
                    default ->
                        throw new AssertionError();
                }
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return Field.class.getClass();
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return rowIndex;
                    case 1:
                        return map.getField_array().get(rowIndex).getClass().getSimpleName();
                    case 2:

                        return ((Field) map.getField_array().get(rowIndex)).getFiledNumber();
                    case 3:

                        if (map.getField_array().get(rowIndex).getClass().equals(Field.class)) {
                            return "";
                        } else {
                            if (map.getField_array().get(rowIndex).getClass().equals(DropField.class)) {
                                return ((DropField) map.getField_array().get(rowIndex)).getDropFieldNumber();
                            } else {
                                return ((LadderField) map.getField_array().get(rowIndex)).getLadderFieldNumber();
                            }
                        }

                    default:
                        throw new AssertionError();
                }
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void addTableModelListener(TableModelListener l) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void removeTableModelListener(TableModelListener l) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Map View");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Index", "Field-Type", "Field-Number", "Connected-Field-Number"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
