/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Controler.MotoristasControler;
import DAO.DAOMotorista;
import Entidades.Motoristas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a1602020
 */
public class ControleFrota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MotoristasControler mc1 = new MotoristasControler();
        mc1.excluir(4);
    }
    
}
