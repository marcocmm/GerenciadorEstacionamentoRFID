/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Arduino.AcessaArduino;
import java.awt.Color;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.Image;

/**
 *
 * @author a1602020
 */
public class menuPrincipal extends javax.swing.JFrame {
    
    
    AcessaArduino acessaArduino;
    /**
     * Creates new form menuPrincipal
     */
    public menuPrincipal() {
        initComponents();
        setTitle("Controle de Frota");
        setSize(500, 500);
        setContentPane(new JLabel(new ImageIcon("src/gui/img/background.png")));        
        
        /*try {
            acessaArduino = new AcessaArduino();
            System.out.println("porta detectada: " + acessaArduino.getPortaSelecionada());

        } catch (Exception e) {
            System.out.println("Erro ao acionar o arduino");
        }*/
        
        cadMotorista cm = new cadMotorista();
        cadDestinos cd = new cadDestinos();
        cadVeiculo cv = new cadVeiculo();
        registroLogs rl = new registroLogs();
        searchLog sl = new searchLog();
        // Cria uma barra de menu para o JFrame
        JMenuBar menuBar = new JMenuBar();
        
        // Adiciona a barra de menu ao  frame
        setJMenuBar(menuBar);
        
        // Define e adiciona dois menus drop down na barra de menus
        JMenu cadMenu = new JMenu("Cadastros");
        JMenu consMenu = new JMenu("Consultas");
        menuBar.add(cadMenu);
        menuBar.add(consMenu);
        
        // Cria e adiciona um item simples para o menu
        JMenuItem cadMot = new JMenuItem("Motoristas");
        cadMot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cm.setVisible(true);
            }
        });
        JMenuItem cadVei = new JMenuItem("Veículos");
        cadVei.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cv.setVisible(true);
            }
        });
        JMenuItem cadDest = new JMenuItem("Destinos");
        cadDest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cd.setVisible(true);
            }
        });
        JMenuItem consLogs = new JMenuItem("Logs");
        consLogs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rl.setVisible(true);
            }
        });
        JMenuItem searchLogs = new JMenuItem("Search Logs");
        searchLogs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sl.setVisible(true);
            }
        });
        
        
        cadMenu.add(cadMot);
        cadMenu.add(cadVei);
        cadMenu.add(cadDest);
        consMenu.add(consLogs); 
        consMenu.add(searchLogs);
       
        Icon iconeMoto = new ImageIcon("src/gui/img/btnMoto.png");
        JButton buttonMoto = new JButton(iconeMoto);
        buttonMoto.setBorder(null);
        buttonMoto.setSize(70,70);
        buttonMoto.setLocation(15, 15);
        buttonMoto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cm.setVisible(true);
            }
        });
        add(buttonMoto);
        
        Icon iconeVeic = new ImageIcon("src/gui/img/btnVeic.png");
        JButton buttonVeic = new JButton(iconeVeic);
        buttonVeic.setBorder(null);
        buttonVeic.setSize(70,70);
        buttonVeic.setLocation(90, 15);
        buttonVeic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cv.setVisible(true);
            }
        });
        add(buttonVeic);
        
        Icon iconeDest = new ImageIcon("src/gui/img/btnDest.png");
        JButton buttonDest = new JButton(iconeDest);
        buttonDest.setBorder(null);
        buttonDest.setSize(70,70);
        buttonDest.setLocation(165, 15);
        buttonDest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cd.setVisible(true);
            }
        });
        add(buttonDest);
        
        Icon iconeLog = new ImageIcon("src/gui/img/btnLogs.png");
        JButton buttonLog = new JButton(iconeLog);
        buttonLog.setBorder(null);
        buttonLog.setSize(70,70);
        buttonLog.setLocation(400, 15);
        buttonLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rl.setVisible(true);
            }
        });
        add(buttonLog);
        
        Icon iconeSearchLogs = new ImageIcon("src/gui/img/btnSearchLogs.png");
        JButton buttonSearchLog = new JButton(iconeSearchLogs);
        buttonSearchLog.setBorder(null);
        buttonSearchLog.setSize(70,70);
        buttonSearchLog.setLocation(325, 15);
        buttonSearchLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sl.setVisible(true);
            }
        });
        add(buttonSearchLog);
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
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
