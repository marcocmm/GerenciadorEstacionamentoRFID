/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOVeiculos;
import Entidades.Motoristas;
import Entidades.Veiculos;
import java.util.List;

/**
 *
 * @author marco
 */
public class VeiculosController {

    DAOVeiculos daoVeiculos;

    public VeiculosController() {
        daoVeiculos = new DAOVeiculos();
    }

    public void cadastrar(String placa, String marca, String modelo, String rFIDVeiculo) {
        Veiculos veiculo = new Veiculos(marca, modelo, placa, rFIDVeiculo);

        try {
            daoVeiculos.inserir(veiculo);
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }

    }

    public void excluir(Integer id) {
        Veiculos m1 = new Veiculos(id);
        try {
            daoVeiculos.remover(m1);
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
    }

    public void alterar(Integer id, String marca, String modelo, String placa, String rfid) {
        Veiculos m1 = new Veiculos(id, marca, modelo, placa, rfid);
        try {
            daoVeiculos.atualizar(m1);
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
    }

    public Veiculos getByPlaca(String placa) {
        try {
            List<Veiculos> listaVeiculos;
            listaVeiculos = daoVeiculos.listByPlaca(placa);
            return listaVeiculos.get(0);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Veiculos> listarId(Integer id) {
        List<Veiculos> lista = null;
        try {
            lista = daoVeiculos.listById(id);
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
        return lista;
    }

    public Veiculos getByRFID(String rfid) {
        try {
            return daoVeiculos.getByRfid(rfid);

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
