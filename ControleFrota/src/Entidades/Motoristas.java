/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author marco
 */
@Entity
@Table(name = "Motoristas")
@NamedQueries({
    @NamedQuery(name = "Motoristas.findAll", query = "SELECT m FROM Motoristas m")})
public class Motoristas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMotorista")
    private Integer idMotorista;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "RFIDMotorista")
    private String rFIDMotorista;
    @OneToMany(mappedBy = "motoristas")
    private List<Logs> logsList;

    public Motoristas() {
    }

    public Motoristas(Integer idMotorista) {
        this.idMotorista = idMotorista;
    }

    public Motoristas(Integer idMotorista, String cpf, String nome, String rFIDMotorista, List<Logs> logsList) {
        this.idMotorista = idMotorista;
        this.cpf = cpf;
        this.nome = nome;
        this.rFIDMotorista = rFIDMotorista;
        this.logsList = logsList;
    }

    public Motoristas(String cpf, String nome, String rFIDMotorista) {
        this.cpf = cpf;
        this.nome = nome;
        this.rFIDMotorista = rFIDMotorista;
    }

    public Motoristas(Integer idMotorista, String cpf, String nome, String rFIDMotorista) {
        this.idMotorista = idMotorista;
        this.cpf = cpf;
        this.nome = nome;
        this.rFIDMotorista = rFIDMotorista;
    }
    public Integer getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(Integer idMotorista) {
        this.idMotorista = idMotorista;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRFIDMotorista() {
        return rFIDMotorista;
    }

    public void setRFIDMotorista(String rFIDMotorista) {
        this.rFIDMotorista = rFIDMotorista;
    }

    public List<Logs> getLogsList() {
        return logsList;
    }

    public void setLogsList(List<Logs> logsList) {
        this.logsList = logsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMotorista != null ? idMotorista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motoristas)) {
            return false;
        }
        Motoristas other = (Motoristas) object;
        if ((this.idMotorista == null && other.idMotorista != null) || (this.idMotorista != null && !this.idMotorista.equals(other.idMotorista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Motoristas[ idMotorista=" + idMotorista + " ]";
    }
    
}
