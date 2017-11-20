/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Controller.MotoristasController;
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
       
        
        MotoristasController mc1 = new MotoristasController();
        List<Motoristas> lista = mc1.listarId(1);
        for (Motoristas motoristas : lista) {
            System.out.println("Teste ID "+motoristas.getNome());
        }
        
    }
    
}
