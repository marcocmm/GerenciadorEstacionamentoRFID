/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author marco
 */
@Entity
@Table(name = "Logs")
@NamedQueries({
    @NamedQuery(name = "Logs.findAll", query = "SELECT l FROM Logs l")})
public class Logs implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LogsPK logsPK;
    @Basic(optional = false)
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "Destinos_idDestino", referencedColumnName = "idDestino", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Destinos destinos;
    @JoinColumn(name = "Motoristas_idMotorista", referencedColumnName = "idMotorista", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Motoristas motoristas;
    @JoinColumn(name = "Veiculos_idVeiculo", referencedColumnName = "idVeiculo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Veiculos veiculos;

    public Logs() {
    }

    public Logs(LogsPK logsPK) {
        this.logsPK = logsPK;
    }

    public Logs(LogsPK logsPK, Date data) {
        this.logsPK = logsPK;
        this.data = data;
    }

    public Logs(int idLog, int motoristasidMotorista, int veiculosidVeiculo, int destinosidDestino) {
        this.logsPK = new LogsPK(idLog, motoristasidMotorista, veiculosidVeiculo, destinosidDestino);
    }

    public LogsPK getLogsPK() {
        return logsPK;
    }

    public void setLogsPK(LogsPK logsPK) {
        this.logsPK = logsPK;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Destinos getDestinos() {
        return destinos;
    }

    public void setDestinos(Destinos destinos) {
        this.destinos = destinos;
    }

    public Motoristas getMotoristas() {
        return motoristas;
    }

    public void setMotoristas(Motoristas motoristas) {
        this.motoristas = motoristas;
    }

    public Veiculos getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Veiculos veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logsPK != null ? logsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logs)) {
            return false;
        }
        Logs other = (Logs) object;
        if ((this.logsPK == null && other.logsPK != null) || (this.logsPK != null && !this.logsPK.equals(other.logsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Logs[ logsPK=" + logsPK + " ]";
    }
    
}
