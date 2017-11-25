/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controller.DestinosController;
import Controller.LogsController;
import Controller.MotoristasController;
import Controller.VeiculosController;
import Entidades.Destinos;
import Entidades.Motoristas;
import Entidades.Veiculos;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;

/**
 *
 * @author marco
 */
public class TestDB {

    DestinosController destinoController;
    LogsController logsController;
    MotoristasController motoristasController;
    VeiculosController veiculosController;

    public TestDB() {
        destinoController = new DestinosController();
        logsController = new LogsController();
        motoristasController = new MotoristasController();
        veiculosController = new VeiculosController();
    }

    @Test
    public void cadastrar() {
        motoristasController.cadastrar("Jao", "123", "321");
        Motoristas mot = null;
        for (Motoristas motorista : motoristasController.listarId(0)) {
            mot = motorista;
            System.out.println(motorista.getNome() + "  " + motorista.getCpf());
        }
        veiculosController.cadastrar("avh", "vw", "fox", "321");
        Veiculos vei = null;
        for (Veiculos veiculo : veiculosController.listarId(0)) {
            vei = veiculo;
            System.out.println(veiculo.getMarca() + "  " + veiculo.getModelo());
        }
        destinoController.cadastrar("87302", "rua", "12", "oficina");
        Destinos dest = null;
        for (Destinos destinos : destinoController.listarId(0)) {
            dest = destinos;
            System.out.println(destinos.getNome() + "  " + destinos.getCep());

        }
        logsController.cadastrar(new Date(2017, 11, 21, 17, 19, 0), dest, mot, vei);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
