/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAODestinos;
import Entidades.Destinos;
import java.util.List;

/**
 *
 * @author a1602020
 */
public class DestinosController {

    DAODestinos daoDestinos;

    public DestinosController() {
        daoDestinos = new DAODestinos();
    }
    
    public void cadastrar (String cep, String endereco, String nome, String numero){
        Destinos destino = new Destinos(cep, endereco, nome, numero);

        try {
            daoDestinos.inserir(destino);
        } catch (Exception e) {
            System.out.println("Erro "+e);
        }
        
    }
    public void excluir (Integer id){
        Destinos m1 = new Destinos(id);
        try {
        daoDestinos.remover(m1);
        } catch (Exception e) {
            System.out.println("Erro "+e);
        }
    }
    public void alterar (Integer id, String cep, String endereco, String nome, String numero){
        Destinos m1 = new Destinos(id, cep, endereco, nome, numero);
        try {
        daoDestinos.atualizar(m1);
        } catch (Exception e) {
            System.out.println("Erro "+e);
        }
    }
    
     public Destinos getByNome(String nome) {
        try {
            List<Destinos> listaDestinos;
            listaDestinos = daoDestinos.listByNome(nome);
            return listaDestinos.get(0);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public List<Destinos> listarId (Integer id){
        List<Destinos> lista = null;
        try {            
            lista = daoDestinos.listById(id);
        } catch (Exception e) {
            System.out.println("Erro "+e);
        }
        return lista;
    }
}
