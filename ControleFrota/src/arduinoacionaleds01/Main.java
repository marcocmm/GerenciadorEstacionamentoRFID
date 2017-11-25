package arduinoacionaleds01;
//@author radames

import Arduino.AcessaArduino;
import gnu.io.SerialPortEvent;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        AcessaArduino acessaArduino;
        try {

            acessaArduino = new AcessaArduino();
            System.out.println("Porta: " + acessaArduino.getPortaSelecionada() + "");

            SerialPortEvent serialPortEvent;
//        serialPortEvent = new SerialPortEvent(acessaArduino.getSerialPort(), 1, true, true);

            Thread t;
            t = new Thread() {
                public void run() {
                    //the following line will keep this app alive for 1000 seconds,
                    //waiting for events to occur and responding to them (printing incoming messages to console).
                    try {
                        while (0 == 0) {
                            System.out.println("Porta: " + acessaArduino.getPortaSelecionada() + "");
                            System.out.println("Dados: " + acessaArduino.getDadosArduino() + "");
                            System.out.println("Porta: " + acessaArduino.getSerialPort() + "");
                            System.out.println("Evento: ");
//                        acessaArduino.serialEvent(serialPortEvent);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException ie) {
                    }
                }
            };
            t.start();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
