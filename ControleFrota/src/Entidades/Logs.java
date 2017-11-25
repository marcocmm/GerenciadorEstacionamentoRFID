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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLog")
    private Integer idLog;
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "Destinos_idDestino", referencedColumnName = "idDestino")
    @ManyToOne
    private Destinos destinos;
    @JoinColumn(name = "Motoristas_idMotorista", referencedColumnName = "idMotorista")
    @ManyToOne
    private Motoristas motoristas;
    @JoinColumn(name = "Veiculos_idVeiculo", referencedColumnName = "idVeiculo")
    @ManyToOne
    private Veiculos veiculos;

    public Logs() {
    }

    public Logs(Integer idLog) {
        this.idLog = idLog;
    }

    public Logs(Integer idLog, Date data, Destinos destinos, Motoristas motoristas, Veiculos veiculos) {
        this.idLog = idLog;
        this.data = data;
        this.destinos = destinos;
        this.motoristas = motoristas;
        this.veiculos = veiculos;
    }

    public Logs(Date data) {
        this.data = data;
    }

    public Logs(Date data, Destinos destinos, Motoristas motoristas, Veiculos veiculos) {
        this.data = data;
        this.destinos = destinos;
        this.motoristas = motoristas;
        this.veiculos = veiculos;
    }
    
    

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
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
        hash += (idLog != null ? idLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logs)) {
            return false;
        }
        Logs other = (Logs) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Logs[ idLog=" + idLog + " ]";
    }
    
}
