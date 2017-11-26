/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Motoristas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author a1602020
 */
public class DAOMotorista extends DAOGenerico<Motoristas> {

    public DAOMotorista() {
        super(Motoristas.class);
    }

    public int autoIdSensor() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idSensor) FROM Sensor e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Motoristas> getByCPF(String cpf) {
        return em.createQuery("SELECT e FROM Motoristas e WHERE e.cpf = :cpf").setParameter("cpf", cpf).getResultList();
    }

    public List<Motoristas> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Motoristas e WHERE e.Nome LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Motoristas> listById(int id) {
        return em.createQuery("SELECT e FROM Motoristas e WHERE e.idMotorista = :id").setParameter("id", id).getResultList();
    }

    public List<Motoristas> listInOrderNome() {
        return em.createQuery("SELECT e FROM Motoristas e ORDER BY e.nome").getResultList();
    }

    public List<Motoristas> listInOrderId() {
        return em.createQuery("SELECT e FROM Motoristas e ORDER BY e.idMotorista").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Motoristas> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdMotorista() + "-" + lf.get(i).getNome());
        }
        return ls;
    }
}
