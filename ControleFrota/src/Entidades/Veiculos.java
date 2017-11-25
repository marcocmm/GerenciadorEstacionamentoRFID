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
@Table(name = "Veiculos")
@NamedQueries({
    @NamedQuery(name = "Veiculos.findAll", query = "SELECT v FROM Veiculos v")})
public class Veiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVeiculo")
    private Integer idVeiculo;
    @Column(name = "Marca")
    private String marca;
    @Column(name = "Modelo")
    private String modelo;
    @Column(name = "Placa")
    private String placa;
    @Column(name = "RFIDVeiculo")
    private String rFIDVeiculo;
    @OneToMany(mappedBy = "veiculos")
    private List<Logs> logsList;

    public Veiculos() {
    }

    public Veiculos(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Veiculos(Integer idVeiculo, String marca, String modelo, String placa, String rFIDVeiculo) {
        this.idVeiculo = idVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.rFIDVeiculo = rFIDVeiculo;
    }

    public Veiculos(String marca, String modelo, String placa, String rFIDVeiculo) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.rFIDVeiculo = rFIDVeiculo;
    }

//    }
    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRFIDVeiculo() {
        return rFIDVeiculo;
    }

    public void setRFIDVeiculo(String rFIDVeiculo) {
        this.rFIDVeiculo = rFIDVeiculo;
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
        hash += (idVeiculo != null ? idVeiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculos)) {
            return false;
        }
        Veiculos other = (Veiculos) object;
        if ((this.idVeiculo == null && other.idVeiculo != null) || (this.idVeiculo != null && !this.idVeiculo.equals(other.idVeiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Veiculos[ idVeiculo=" + idVeiculo + " ]";
    }
    
}
