/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOMotorista;
import Entidades.Motoristas;
import java.util.List;

/**
 *
 * @author a1602020
 */
public class MotoristasController {

    DAOMotorista daomot;

    public MotoristasController() {
        daomot = new DAOMotorista();
    }

    public void cadastrar(String nome, String cpf, String rfid) {
        Motoristas m1 = new Motoristas(cpf, nome, rfid);
//        m1.setNome(nome);
//        m1.setCpf(cpf);
//        m1.setRFIDMotorista(rfid);

        try {
            daomot.inserir(m1);
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }

    }

    public void excluir(Integer id) {
        Motoristas m1 = new Motoristas(id);
        try {
            daomot.remover(m1);
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
    }

    public void alterar(Integer id, String nome, String cpf, String rfid) {
        Motoristas m1 = new Motoristas(id, cpf, nome, rfid);
        try {
            daomot.atualizar(m1);
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
    }

    public Motoristas getByCPF(String cpf) {
        try {
            List<Motoristas> listaMotoristas;
            listaMotoristas = daomot.getByCPF(cpf);
            return listaMotoristas.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Motoristas> listarById(Integer id) {
        List<Motoristas> lista = null;
        try {
            lista = daomot.listById(id);
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
        return lista;
    }
}
