/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Arduino.AcessaArduino;
import Controller.DestinosController;
import Controller.LogsController;
import Controller.MotoristasController;
import Controller.VeiculosController;
import Entidades.Destinos;
import Entidades.Motoristas;
import Entidades.Veiculos;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author marco
 */
public class newLog extends javax.swing.JFrame {

    /**
     * Creates new form newLog
     */
    private volatile Destinos destinoThread;

    public newLog() {

        this.destinoThread = null;
        initComponents();

        setTitle("Novo Registro");
        setSize(355, 310);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel labelBusca = new JLabel("Informe o Destino");

        labelBusca.setBounds(70, 10, 120, 20);
        add(labelBusca);

        JTextField tfBusca = new JTextField();

        tfBusca.setSize(110, 25);
        tfBusca.setLocation(70, 30);
        add(tfBusca);

        JButton buttonBusca = new JButton("Buscar");

        buttonBusca.setSize(90, 30);
        buttonBusca.setLocation(190, 27);
        add(buttonBusca);

        JLabel labelNome = new JLabel("Nome");

        labelNome.setBounds(20, 60, 100, 20);
        add(labelNome);

        JTextField tfNome = new JTextField();

        tfNome.setSize(210, 25);
        tfNome.setLocation(20, 80);
        add(tfNome);

        DestinosController destinosController;
        destinosController = new DestinosController();
        Destinos destinoBuscado;
        destinoBuscado = new Destinos();

        buttonBusca.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String nome;
                nome = tfBusca.getText();
                try {
                    Destinos destinos = destinosController.getByNome(nome);
                    tfNome.setText(destinos.getNome());
                    destinoBuscado.setIdDestino(destinos.getIdDestino());
                    destinoThread = destinos;

                    JOptionPane.showMessageDialog(null, "Encontrado");

                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, "Não encontrado Encontrado");
                    System.out.println(ee);
                }
            }
        }
        );

        Thread t;
        t = new Thread() {
            AcessaArduino acessaArduino;
            Date date;
            String data;
            String primeiroRfid;
            String segundoRfid;

            public void run() {
                acessaArduino = new AcessaArduino();
                primeiroRfid = "";
                segundoRfid = "";
                System.out.println("Porta: " + acessaArduino.getPortaSelecionada() + "");
                //the following line will keep this app alive for 1000 seconds,
                //waiting for events to occur and responding to them (printing incoming messages to console).
                try {
                    while (0 == 0) {
                        data = acessaArduino.getDadosArduino();
                        if (primeiroRfid.equals("")) {
                            primeiroRfid = data;
                            System.out.println("Primeiro RFID");
                        } else if (segundoRfid.equals("")) {
                            segundoRfid = data;
                            System.out.println("Segundo RFID");
                        } else if (destinoThread != null) {
                            System.out.println("Destino");
                            date = new java.util.Date();
                            LogsController logsController = new LogsController();
                            MotoristasController motoristasController = new MotoristasController();
                            VeiculosController veiculosController = new VeiculosController();
                            Motoristas motorista;
                            Veiculos veiculo;
                            veiculo = veiculosController.getByRFID(primeiroRfid);
                            if (veiculo == null) {
                                veiculo = veiculosController.getByRFID(segundoRfid);
                                motorista = motoristasController.getByRFID(primeiroRfid);
                            } else {
                                motorista = motoristasController.getByRFID(segundoRfid);
                            }
                            logsController.cadastrar(date, destinoThread, motorista, veiculo);
                            System.out.println("Sucesso ----------");
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException ie) {
                }
            }
        };
        t.start();

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
            java.util.logging.Logger.getLogger(newLog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newLog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newLog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newLog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newLog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
