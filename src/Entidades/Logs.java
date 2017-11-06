/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author a1602020
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
    @Basic(optional = false)
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "Motoristas_idMotorista", referencedColumnName = "idMotorista")
    @ManyToOne(optional = false)
    private Motoristas motoristasidMotorista;
    @JoinColumn(name = "Veiculos_idVeiculo", referencedColumnName = "idVeiculo")
    @ManyToOne(optional = false)
    private Veiculos veiculosidVeiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logsidLog")
    private List<Destinos> destinosList;

    public Logs() {
    }

    public Logs(Integer idLog) {
        this.idLog = idLog;
    }

    public Logs(Integer idLog, Date data) {
        this.idLog = idLog;
        this.data = data;
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

    public Motoristas getMotoristasidMotorista() {
        return motoristasidMotorista;
    }

    public void setMotoristasidMotorista(Motoristas motoristasidMotorista) {
        this.motoristasidMotorista = motoristasidMotorista;
    }

    public Veiculos getVeiculosidVeiculo() {
        return veiculosidVeiculo;
    }

    public void setVeiculosidVeiculo(Veiculos veiculosidVeiculo) {
        this.veiculosidVeiculo = veiculosidVeiculo;
    }

    public List<Destinos> getDestinosList() {
        return destinosList;
    }

    public void setDestinosList(List<Destinos> destinosList) {
        this.destinosList = destinosList;
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
