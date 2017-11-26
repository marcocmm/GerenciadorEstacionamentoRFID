/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.DestinosController;
import Entidades.Destinos;
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
public class cadDestinos extends javax.swing.JFrame {

    /**
     * Creates new form cadDestinos
     */
    public cadDestinos() {
        initComponents();
        DestinosController destinosController;
        destinosController = new DestinosController();
        Destinos destinoBuscado;
        destinoBuscado = new Destinos();

        setTitle("Cadastro de Destinos");
        setSize(355, 320);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel labelBusca = new JLabel("Informe o Nome");
        labelBusca.setBounds(70, 10, 120, 20);

        JTextField tfBusca = new JTextField();
        tfBusca.setSize(110, 25);
        tfBusca.setLocation(70, 30);

        JButton buttonBusca = new JButton("Buscar");
        buttonBusca.setSize(90, 30);
        buttonBusca.setLocation(200, 27);

        JLabel labelNome = new JLabel("Nome");
        labelNome.setBounds(20, 60, 100, 20);

        JTextField tfNome = new JTextField();
        tfNome.setSize(210, 25);
        tfNome.setLocation(20, 80);

        JLabel labelCEP = new JLabel("CEP");
        labelCEP.setBounds(20, 110, 100, 20);

        JTextField tfCEP = new JTextField();
        tfCEP.setSize(100, 25);
        tfCEP.setLocation(20, 130);

        JLabel labelEndereco = new JLabel("Endereço");
        labelEndereco.setBounds(20, 160, 100, 20);

        JTextField tfEndereco = new JTextField();
        tfEndereco.setSize(210, 25);
        tfEndereco.setLocation(20, 180);

        JLabel labelNumero = new JLabel("Número");
        labelNumero.setBounds(20, 210, 100, 20);

        JTextField tfNumero = new JTextField();
        tfNumero.setSize(80, 25);
        tfNumero.setLocation(20, 230);

        JButton buttonSave = new JButton("Salvar");
        buttonSave.setSize(100, 30);
        buttonSave.setLocation(20, 270);
        JButton buttonUpdate = new JButton("Alterar");
        buttonUpdate.setSize(100, 30);
        buttonUpdate.setLocation(240, 270);
        add(buttonUpdate);
        JButton buttonCancel = new JButton("Cancelar");
        buttonCancel.setSize(100, 30);
        buttonCancel.setLocation(130, 270);
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome;
                String cep;
                String numero;
                String endereco;
                nome = tfNome.getText();
                cep = tfCEP.getText();
                numero = tfNumero.getText();
                endereco = tfEndereco.getText();
                if (nome.equals("") | cep.equals("") | numero.equals("") | endereco.equals("")) {
                    JOptionPane.showMessageDialog(null, "Preencha todos campos");
                } else {
                    try {
                        destinosController.alterar(destinoBuscado.getIdDestino(), cep, endereco, nome, numero);
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
                String nome;
                nome = tfBusca.getText();
                try {
                    Destinos destinos = destinosController.getByNome(nome);
                    tfNome.setText(destinos.getNome());
                    tfCEP.setText(destinos.getCep());
                    tfEndereco.setText(destinos.getEndereco());
                    tfNumero.setText(destinos.getNumero());
                    destinoBuscado.setIdDestino(destinos.getIdDestino());
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
                String cep;
                String numero;
                String endereco;
                nome = tfNome.getText();
                cep = tfCEP.getText();
                numero = tfNumero.getText();
                endereco = tfEndereco.getText();
                if (nome.equals("") | cep.equals("") | numero.equals("") | endereco.equals("")) {
                    JOptionPane.showMessageDialog(null, "Preencha todos campos");
                } else {
                    try {
                        destinosController.cadastrar(cep, endereco, nome, numero);
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
        add(labelNome);
        add(tfNome);
        add(labelCEP);
        add(tfCEP);
        add(tfEndereco);
        add(labelEndereco);
        add(labelNumero);
        add(tfNumero);
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
            java.util.logging.Logger.getLogger(cadDestinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadDestinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadDestinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadDestinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadDestinos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
