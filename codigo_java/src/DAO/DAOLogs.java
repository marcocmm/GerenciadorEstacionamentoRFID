/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAOGenerico.em;
import Entidades.Logs;
import Entidades.Logs;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marco
 */
public class DAOLogs extends DAOGenerico<Logs>{
    
    public DAOLogs() {
        super(Logs.class);
    }

    public List<Logs> listByNome(Date data) {
        return em.createQuery("SELECT e FROM Logs e WHERE e.data LIKE :data").setParameter("data", "%" + data + "%").getResultList();
    }

//    public List<Logs> listById(int id) {
//        return em.createQuery("SELECT e FROM Logs e WHERE e.idLog = :id").setParameter("id", id).getResultList();
//    }

    public List<Logs> listInOrderMotoristas() {
        return em.createQuery("SELECT e FROM Logs e ORDER BY e.motoristas").getResultList();
    }

    public List<Logs> listInOrderDestinos() {
        return em.createQuery("SELECT e FROM Logs e ORDER BY e.destinos").getResultList();
    }
    
}
