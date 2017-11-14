/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author marco
 */
@Embeddable
public class LogsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idLog")
    private int idLog;
    @Basic(optional = false)
    @Column(name = "Motoristas_idMotorista")
    private int motoristasidMotorista;
    @Basic(optional = false)
    @Column(name = "Veiculos_idVeiculo")
    private int veiculosidVeiculo;
    @Basic(optional = false)
    @Column(name = "Destinos_idDestino")
    private int destinosidDestino;

    public LogsPK() {
    }

    public LogsPK(int idLog, int motoristasidMotorista, int veiculosidVeiculo, int destinosidDestino) {
        this.idLog = idLog;
        this.motoristasidMotorista = motoristasidMotorista;
        this.veiculosidVeiculo = veiculosidVeiculo;
        this.destinosidDestino = destinosidDestino;
    }

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public int getMotoristasidMotorista() {
        return motoristasidMotorista;
    }

    public void setMotoristasidMotorista(int motoristasidMotorista) {
        this.motoristasidMotorista = motoristasidMotorista;
    }

    public int getVeiculosidVeiculo() {
        return veiculosidVeiculo;
    }

    public void setVeiculosidVeiculo(int veiculosidVeiculo) {
        this.veiculosidVeiculo = veiculosidVeiculo;
    }

    public int getDestinosidDestino() {
        return destinosidDestino;
    }

    public void setDestinosidDestino(int destinosidDestino) {
        this.destinosidDestino = destinosidDestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idLog;
        hash += (int) motoristasidMotorista;
        hash += (int) veiculosidVeiculo;
        hash += (int) destinosidDestino;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogsPK)) {
            return false;
        }
        LogsPK other = (LogsPK) object;
        if (this.idLog != other.idLog) {
            return false;
        }
        if (this.motoristasidMotorista != other.motoristasidMotorista) {
            return false;
        }
        if (this.veiculosidVeiculo != other.veiculosidVeiculo) {
            return false;
        }
        if (this.destinosidDestino != other.destinosidDestino) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.LogsPK[ idLog=" + idLog + ", motoristasidMotorista=" + motoristasidMotorista + ", veiculosidVeiculo=" + veiculosidVeiculo + ", destinosidDestino=" + destinosidDestino + " ]";
    }
    
}
