/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gusta
 */
@Entity
@Table(name = "carro")
@NamedQueries({
    @NamedQuery(name = "Carro.findAll", query = "SELECT c FROM Carro c")})
public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @Column(name = "cor")
    private String cor;
    @Column(name = "ano")
    @Temporal(TemporalType.DATE)
    private Date ano;
    @Column(name = "carrocol")
    private String carrocol;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "disponibilidade")
    private Short disponibilidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carroId")
    private List<Aluga> alugaList;

    public Carro() {
    }

    public Carro(Integer id) {
        this.id = id;
    }

    public Carro(Integer id, String modelo) {
        this.id = id;
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public String getCarrocol() {
        return carrocol;
    }

    public void setCarrocol(String carrocol) {
        this.carrocol = carrocol;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Short getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Short disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public List<Aluga> getAlugaList() {
        return alugaList;
    }

    public void setAlugaList(List<Aluga> alugaList) {
        this.alugaList = alugaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carro)) {
            return false;
        }
        Carro other = (Carro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.model.Carro[ id=" + id + " ]";
    }
    
}
