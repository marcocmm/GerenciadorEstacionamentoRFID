/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAOGenerico.em;
import Entidades.Veiculos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class DAOVeiculos extends DAOGenerico<Veiculos> {

    public DAOVeiculos() {
        super(Veiculos.class);
    }

    public List<Veiculos> listByPlaca(String placas) {
        return em.createQuery("SELECT e FROM Veiculos e WHERE e.placa = :placas").setParameter("placas", placas).getResultList();
    }

    public List<Veiculos> listById(int id) {
        return em.createQuery("SELECT e FROM Veiculos e WHERE e.idVeiculo = :id").setParameter("id", id).getResultList();
    }

    public List<Veiculos> listInOrderPlaca() {
        return em.createQuery("SELECT e FROM Veiculos e ORDER BY e.placa").getResultList();
    }

    public List<Veiculos> listInOrderId() {
        return em.createQuery("SELECT e FROM Veiculos e ORDER BY e.idVeiculo").getResultList();
    }

    public List<Veiculos> getByPlaca(String placa) {
        return em.createQuery("SELECT e FROM Veiculos e WHERE e.placa = :placa").setParameter("pĺaca", placa).getResultList();
    }
    
    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Veiculos> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderPlaca();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdVeiculo() + "-" + lf.get(i).getModelo());
        }
        return ls;
    }

}
