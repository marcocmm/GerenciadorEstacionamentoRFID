/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.MotoristasController;
import Entidades.Motoristas;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author a1602020
 */
public class cadMotorista extends javax.swing.JFrame {
    
    
    
    /**
     * Creates new form cadMotorista
     */
    public cadMotorista() {
        MotoristasController motoristasController;
        motoristasController = new MotoristasController();
        Motoristas motoristaBuscado = new Motoristas();

        initComponents();
        setTitle("Cadastro de Motoristas");
        setSize(360, 270);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel labelBusca = new JLabel("Informe o CPF");
        labelBusca.setBounds(80, 10, 100, 20);

        JTextField tfBusca = new JTextField();
        tfBusca.setSize(110, 25);
        tfBusca.setLocation(70, 30);

        JButton buttonBusca = new JButton("Buscar");
        buttonBusca.setSize(90, 30);
        buttonBusca.setLocation(190, 27);

        JLabel labelNome = new JLabel("Nome");
        labelNome.setBounds(20, 60, 100, 20);

        JTextField tfNome = new JTextField();
        tfNome.setSize(210, 25);
        tfNome.setLocation(20, 80);

        JLabel labelCPF = new JLabel("CPF");
        labelCPF.setBounds(20, 110, 100, 20);

        JTextField tfCPF = new JTextField();
        tfCPF.setSize(110, 25);
        tfCPF.setLocation(20, 130);

        JLabel labelRFID = new JLabel("RFID");
        labelRFID.setBounds(20, 160, 100, 20);

        JTextField tfRFID = new JTextField();
        tfRFID.setSize(100, 25);
        tfRFID.setLocation(20, 180);

        JButton buttonSave = new JButton("Salvar");
        buttonSave.setSize(100, 30);
        buttonSave.setLocation(20, 220);
        add(buttonSave);

        JButton buttonUpdate = new JButton("Alterar");
        buttonUpdate.setSize(100, 30);
        buttonUpdate.setLocation(130, 220);
        add(buttonUpdate);

        JButton buttonCancel = new JButton("Cancelar");
        buttonCancel.setSize(100, 30);
        buttonCancel.setLocation(240, 220);
        
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome;
                String cpf;
                String rfid;
                nome = tfNome.getText();
                cpf = tfCPF.getText();
                rfid = tfRFID.getText();
                
                if (nome.equals("") | cpf.equals("") | rfid.equals("")) {
                    JOptionPane.showMessageDialog(null, "Preencha todos campos");
                } else {
                    try {
                        motoristasController.alterar(motoristaBuscado.getIdMotorista(), nome, cpf, rfid);
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
                String cpf;
                cpf = tfBusca.getText();
                try {
                    Motoristas motorista = motoristasController.getByCPF(cpf);
                    tfCPF.setText(cpf);
                    tfNome.setText(motorista.getNome());
                    tfRFID.setText(motorista.getRFIDMotorista());
                    motoristaBuscado.setIdMotorista(motorista.getIdMotorista());
                    JOptionPane.showMessageDialog(null, "Encontrado");

                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, "Não encontrado Encontrado");
                    System.out.println(ee);
                }
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome;
                String cpf;
                String rfid;
                nome = tfNome.getText();
                cpf = tfCPF.getText();
                rfid = tfRFID.getText();
                if (nome.equals("") | cpf.equals("") | rfid.equals("")) {
                    JOptionPane.showMessageDialog(null, "Preencha todos campos");
                } else {
                    try {
                        motoristasController.cadastrar(nome, cpf, rfid);
                        JOptionPane.showMessageDialog(null, "Cadastrado");
                        clear();
                    } catch (HeadlessException he) {
                        JOptionPane.showMessageDialog(null, "Não foi possível cadastrar");
                        System.out.println(he);
                    }
                }
            }

            public void clear() {
                tfCPF.setText("");
                tfBusca.setText("");
                tfNome.setText("");
                tfRFID.setText("");
            }
        });

        add(buttonUpdate);
        add(buttonCancel);
        add(labelNome);
        add(tfNome);
        add(tfCPF);
        add(buttonBusca);
        add(tfBusca);
        add(labelCPF);
        add(labelRFID);
        add(labelBusca);
        add(tfRFID);
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
            java.util.logging.Logger.getLogger(cadMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadMotorista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
