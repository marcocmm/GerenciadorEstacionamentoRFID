/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOLogs;
import Entidades.Destinos;
import Entidades.Logs;
import Entidades.Motoristas;
import Entidades.Veiculos;
import java.util.Date;
import java.util.List;

/**
 *
 * @author a1602020
 */
public class LogsController {

    DAOLogs daomot;

    public LogsController() {
        daomot = new DAOLogs();
    }

    public void cadastrar(Date data, Destinos destinos, Motoristas motoristas, Veiculos veiculos) {
        Logs m1 = new Logs(data, destinos, motoristas, veiculos);
//        m1.setNome(nome);
//        m1.setCpf(cpf);
//        m1.setRFIDLog(rfid);

        try {
            daomot.inserir(m1);
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }

    }

    public void excluir(Date date) {
        Logs m1 = new Logs(date);
        try {
            daomot.remover(m1);
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
    }

    public void alterar(int idLog, Date data, Destinos destinos, Motoristas motoristas, Veiculos veiculos) {
        Logs m1 = new Logs(idLog, data, destinos, motoristas, veiculos);
        try {
            daomot.atualizar(m1);
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
    }
}
