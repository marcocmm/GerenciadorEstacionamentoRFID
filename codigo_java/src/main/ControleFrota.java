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
       
        Motoristas motorista = new Motoristas("jao", "123", "321");
        DAOMotorista dAOMotorista = new DAOMotorista();
        dAOMotorista.inserir(motorista);
        
    }
    
}
