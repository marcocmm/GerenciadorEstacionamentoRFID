/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAOGenerico.em;
import Entidades.Destinos;
import Entidades.Logs;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class DAOLogs extends DAOGenerico<Logs>{
    
    public DAOLogs() {
        super(Logs.class);
    }

    public List<Destinos> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Destinos e WHERE e.nome LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Destinos> listById(int id) {
        return em.createQuery("SELECT e FROM Destinos e WHERE e.idDestino = :id").setParameter("id", id).getResultList();
    }

    public List<Destinos> listInOrderNome() {
        return em.createQuery("SELECT e FROM Destinos e ORDER BY e.nome").getResultList();
    }

    public List<Destinos> listInOrderId() {
        return em.createQuery("SELECT e FROM Destinos e ORDER BY e.idDestino").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Destinos> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdDestino()+ "-" + lf.get(i).getNome());
        }
        return ls;
    }
    
}
