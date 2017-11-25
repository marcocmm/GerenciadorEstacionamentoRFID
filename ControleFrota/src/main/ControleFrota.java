/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Arduino.AcessaArduino;
import gui.menuPrincipal;
import gnu.io.SerialPortEvent;

/**
 *
 * @author a1602020
 */
public class ControleFrota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menuPrincipal mp = new menuPrincipal();
        mp.setVisible(true);
        // TODO code application logic here
//        AcessaArduino acessaArduino;
//        try {
//
//        acessaArduino = new AcessaArduino();
//        System.out.println("Porta: " + acessaArduino.getPortaSelecionada() + "");
//
//        SerialPortEvent serialPortEvent;
//        serialPortEvent = new SerialPortEvent(acessaArduino.getSerialPort(), 1, true, true);
//        acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "negado");
//
//
//        Thread t;
//        t = new Thread() {
//            public void run() {
//                //the following line will keep this app alive for 1000 seconds,
//                //waiting for events to occur and responding to them (printing incoming messages to console).
//                try {
//                    while (0 == 0) {
//                        System.out.println("Porta: " + acessaArduino.getPortaSelecionada() + "");
//                        System.out.println("Dados: " + acessaArduino.getDadosArduino() + "");
//                        System.out.println("Porta: " + acessaArduino.getSerialPort() + "");
//                        System.out.println("Evento: ");
//                        acessaArduino.serialEvent(serialPortEvent);
//                        Thread.sleep(1000);
//                    }
//                } catch (InterruptedException ie) {
//                }
//            }
//        };
//        t.start();
//
//        acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "liberado");
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }

    }

}
