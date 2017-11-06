/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
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

/**
 *
 * @author a1602020
 */
@Entity
@Table(name = "Destinos")
@NamedQueries({
    @NamedQuery(name = "Destinos.findAll", query = "SELECT d FROM Destinos d")})
public class Destinos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDestino")
    private Integer idDestino;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "Endereco")
    private String endereco;
    @Column(name = "Numero")
    private String numero;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "Logs_Motoristas_idMotorista")
    private int logsMotoristasidMotorista;
    @JoinColumn(name = "Logs_idLog", referencedColumnName = "idLog")
    @ManyToOne(optional = false)
    private Logs logsidLog;

    public Destinos() {
    }

    public Destinos(Integer idDestino) {
        this.idDestino = idDestino;
    }

    public Destinos(Integer idDestino, String nome, int logsMotoristasidMotorista) {
        this.idDestino = idDestino;
        this.nome = nome;
        this.logsMotoristasidMotorista = logsMotoristasidMotorista;
    }

    public Integer getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(Integer idDestino) {
        this.idDestino = idDestino;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLogsMotoristasidMotorista() {
        return logsMotoristasidMotorista;
    }

    public void setLogsMotoristasidMotorista(int logsMotoristasidMotorista) {
        this.logsMotoristasidMotorista = logsMotoristasidMotorista;
    }

    public Logs getLogsidLog() {
        return logsidLog;
    }

    public void setLogsidLog(Logs logsidLog) {
        this.logsidLog = logsidLog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDestino != null ? idDestino.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destinos)) {
            return false;
        }
        Destinos other = (Destinos) object;
        if ((this.idDestino == null && other.idDestino != null) || (this.idDestino != null && !this.idDestino.equals(other.idDestino))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Destinos[ idDestino=" + idDestino + " ]";
    }
    
}
