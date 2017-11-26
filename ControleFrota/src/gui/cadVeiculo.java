/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.VeiculosController;
import Entidades.Veiculos;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        VeiculosController veiculosController;
        veiculosController = new VeiculosController();
        Veiculos veiculoBuscado;
        veiculoBuscado = new Veiculos();
        initComponents();
        setTitle("Cadastro de Veículos");
        setSize(355, 310);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel labelBusca = new JLabel("Informe a Placa");
        labelBusca.setBounds(70, 10, 120, 20);

        JTextField tfBusca = new JTextField();
        tfBusca.setSize(100, 25);
        tfBusca.setLocation(70, 30);

        JButton buttonBusca = new JButton("Buscar");
        buttonBusca.setSize(90, 30);
        buttonBusca.setLocation(180, 27);

        JLabel labelMarca = new JLabel("Marca");
        labelMarca.setBounds(20, 60, 100, 20);

        JTextField tfMarca = new JTextField();
        tfMarca.setSize(170, 25);
        tfMarca.setLocation(20, 80);

        JLabel labelModelo = new JLabel("Modelo");
        labelModelo.setBounds(20, 110, 100, 20);

        JTextField tfModelo = new JTextField();
        tfModelo.setSize(150, 25);
        tfModelo.setLocation(20, 130);

        JLabel labelPlaca = new JLabel("Placa");
        labelPlaca.setBounds(20, 160, 100, 20);

        JTextField tfPlaca = new JTextField();
        tfPlaca.setSize(80, 25);
        tfPlaca.setLocation(20, 180);

        JLabel labelRFID = new JLabel("RFID");
        labelRFID.setBounds(20, 210, 100, 20);

        JTextField tfRFID = new JTextField();
        tfRFID.setSize(100, 25);
        tfRFID.setLocation(20, 230);

        JButton buttonSave = new JButton("Salvar");
        buttonSave.setSize(100, 30);
        buttonSave.setLocation(20, 270);
        add(buttonSave);

        JButton buttonUpdate = new JButton("Alterar");
        buttonUpdate.setSize(100, 30);
        buttonUpdate.setLocation(130, 270);
        add(buttonUpdate);

        JButton buttonCancel = new JButton("Cancelar");
        buttonCancel.setSize(100, 30);
        buttonCancel.setLocation(240, 270);

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String marca;
                String modelo;
                String rfid;
                String placa;
                marca = tfMarca.getText();
                modelo = tfModelo.getText();
                rfid = tfRFID.getText();
                placa = tfPlaca.getText();
                if (marca.equals("") | modelo.equals("") | placa.equals("") | rfid.equals("")) {
                    JOptionPane.showMessageDialog(null, "Preencha todos campos");
                } else {
                    try {
                        veiculosController.alterar(veiculoBuscado.getIdVeiculo(), marca, modelo, placa, rfid);
                        JOptionPane.showMessageDialog(null, "Alterado");
                    } catch (HeadlessException he) {
                        JOptionPane.showMessageDialog(null, "Não foi possível alterar");
                        System.out.println(he);
                    }
                }
            }
        });
        buttonBusca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String placa;
                placa = tfBusca.getText();
                try {
                    Veiculos veiculos = veiculosController.getByPlaca(placa);
                    tfPlaca.setText(placa);
                    tfModelo.setText(veiculos.getModelo());
                    tfMarca.setText(veiculos.getMarca());
                    tfRFID.setText(veiculos.getRFIDVeiculo());
                    veiculoBuscado.setIdVeiculo(veiculos.getIdVeiculo());
                    JOptionPane.showMessageDialog(null, "Encontrado");

                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, "Não encontrado Encontrado");
                    System.out.println(ee);
                }
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String marca;
                String modelo;
                String rfid;
                String placa;
                marca = tfMarca.getText();
                modelo = tfModelo.getText();
                rfid = tfRFID.getText();
                placa = tfPlaca.getText();
                if (marca.equals("") | modelo.equals("") | placa.equals("") | rfid.equals("")) {
                    JOptionPane.showMessageDialog(null, "Preencha todos campos");
                } else {
                    try {
                        veiculosController.cadastrar(placa, marca, modelo, rfid);
                        JOptionPane.showMessageDialog(null, "Cadastrado");
                    } catch (HeadlessException he) {
                        JOptionPane.showMessageDialog(null, "Não foi possível cadastrar");
                        System.out.println(he);
                    }
                }
            }
        });
        
        add(buttonCancel);
        add(labelBusca);
        add(tfBusca);
        add(buttonBusca);
        add(labelMarca);
        add(tfMarca);
        add(labelModelo);
        add(tfModelo);
        add(labelPlaca);
        add(tfPlaca);
        add(labelRFID);
        add(tfRFID);
        add(buttonSave);
        
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
