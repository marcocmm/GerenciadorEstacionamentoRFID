/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author a1602020
 */
public class cadVeiculo extends javax.swing.JFrame {

    /**
     * Creates new form cadVeiculo
     */
    public cadVeiculo() {
        initComponents();
        setTitle("Cadastro de Veículos");
        setSize(255, 355);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JLabel labelBusca = new JLabel("Informe a Placa");
        labelBusca.setBounds(20, 10, 120, 20);
        add(labelBusca);
        
        JTextField tfBusca = new JTextField();
        tfBusca.setSize(80,25);
        tfBusca.setLocation(20, 30);
        add(tfBusca);
        
        JButton buttonBusca = new JButton("Buscar");
        buttonBusca.setSize(90,30);
        buttonBusca.setLocation(140, 27);
        add(buttonBusca);
        
        JLabel labelMarca = new JLabel("Marca");
        labelMarca.setBounds(20, 60, 100, 20);
        add(labelMarca);
        
        JTextField tfMarca = new JTextField();
        tfMarca.setSize(170,25);
        tfMarca.setLocation(20, 80);
        add(tfMarca);
        
        JLabel labelModelo = new JLabel("Modelo");
        labelModelo.setBounds(20, 110, 100, 20);
        add(labelModelo);
        
        JTextField tfModelo = new JTextField();
        tfModelo.setSize(150,25);
        tfModelo.setLocation(20, 130);
        add(tfModelo);
        
        JLabel labelPlaca = new JLabel("Placa");
        labelPlaca.setBounds(20, 160, 100, 20);
        add(labelPlaca);
        
        JTextField tfPlaca = new JTextField();
        tfPlaca.setSize(80,25);
        tfPlaca.setLocation(20, 180);
        add(tfPlaca);
        
        JLabel labelRFID = new JLabel("RFID");
        labelRFID.setBounds(20, 210, 100, 20);
        add(labelRFID);
        
        JTextField tfRFID = new JTextField();
        tfRFID.setSize(100,25);
        tfRFID.setLocation(20, 230);
        add(tfRFID);
        
        JButton buttonSave = new JButton("Salvar");
        buttonSave.setSize(100,30);
        buttonSave.setLocation(20, 270);
        add(buttonSave);
        
        JButton buttonCancel = new JButton("Cancelar");
        buttonCancel.setSize(100,30);
        buttonCancel.setLocation(130, 270);
        add(buttonCancel);
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
            java.util.logging.Logger.getLogger(cadVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadVeiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
