/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Arduino.AcessaArduino;
import gui.menuPrincipal;
import gnu.io.SerialPortEvent;
import java.util.Date;

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
        try {


//            SerialPortEvent serialPortEvent;
//            serialPortEvent = new SerialPortEvent(acessaArduino.getSerialPort(), 1, true, true);
//            acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "negado");

           

//        acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "liberado");
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
