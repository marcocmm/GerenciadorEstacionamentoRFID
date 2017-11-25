package arduinoacionaleds01;

/**
 *
 * @author radames
 */
import Arduino.AcessaArduino;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI extends JFrame {

    JButton btAmarelo = new JButton("LED Amarelo");
    JButton btVermelho = new JButton("LED Vermelho");
    Container cp;
    AcessaArduino acessaArduino;

    public GUI() {

        try {
            acessaArduino = new AcessaArduino();
            System.out.println("porta detectada: " + acessaArduino.getPortaSelecionada());

        } catch (Exception e) {
            System.out.println("Erro ao acionar o arduino");
        }

        //System.out.println(ArduinoSerialPortListener.serial_port);
        setSize(200, 200);
        setLocation(2500, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new GridLayout(2, 1));

        setTitle("Ligar e desligar LED's");

        btAmarelo.setOpaque(true);
        btAmarelo.setBackground(Color.yellow);
        cp.add(btAmarelo);

        btVermelho.setOpaque(true);
        btVermelho.setBackground(Color.red);
        cp.add(btVermelho);

        try {            
            Thread.sleep(1000);
            acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "a");
            Thread.sleep(1000);
            acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "b");
        } catch (Exception e) {

            e.printStackTrace();
        }

        btAmarelo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "a");
            }
        });

        btVermelho.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "v");
            }
        });

        setVisible(true);
    }
}