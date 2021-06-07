/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author gusta
 */
@Entity
@Table(name = "aluga")
@NamedQueries({
    @NamedQuery(name = "Aluga.findAll", query = "SELECT a FROM Aluga a")})
public class Aluga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tempoAlugado")
    @Temporal(TemporalType.DATE)
    private Date tempoAlugado;
    @JoinColumn(name = "carro_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Carro carroId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public Aluga() {
    }

    public Aluga(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTempoAlugado() {
        return tempoAlugado;
    }

    public void setTempoAlugado(Date tempoAlugado) {
        this.tempoAlugado = tempoAlugado;
    }

    public Carro getCarroId() {
        return carroId;
    }

    public void setCarroId(Carro carroId) {
        this.carroId = carroId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof Aluga)) {
            return false;
        }
        Aluga other = (Aluga) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.model.Aluga[ id=" + id + " ]";
    }
    
}