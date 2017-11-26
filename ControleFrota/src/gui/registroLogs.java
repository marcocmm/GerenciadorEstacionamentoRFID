/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.LogsController;
import Entidades.Logs;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author a1602020
 */
public class registroLogs extends javax.swing.JFrame {

    /**
     * Creates new form registroLogs
     */
    public registroLogs() {
        initComponents();
        LogsController logsController;
        logsController = new LogsController();
        List<Logs> listLogs = null;
        setTitle("Registro de Logs");
        setSize(700, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        listLogs = logsController.listAll();
        String[] row = new String[5];
        String[][] matrix = new String[listLogs.size()][5];
        Logs log;
        for (int i = 0; i < listLogs.size(); i++) {
            log = listLogs.get(i);
            row[0] = log.getMotoristas().getNome();
            row[1] = log.getVeiculos().getModelo();
            row[2] = log.getVeiculos().getPlaca();
            row[3] = log.getData().toGMTString();
            row[4] = log.getDestinos().getNome();
            matrix[i] = row;
        }
        String[] columnNames = {"Motorista", "Veículo", "Placa", "Data/Hora", "Destino"};
        JTable table;
        table = new JTable(matrix, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        table.setFillsViewportHeight(true);
        setLayout(new BorderLayout());
        add(table.getTableHeader(), BorderLayout.PAGE_START);
        add(table, BorderLayout.CENTER);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(registroLogs.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registroLogs.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registroLogs.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registroLogs.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registroLogs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
