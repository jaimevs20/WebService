/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdcesta;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UESB-USR
 */
@Entity
@Table(name = "ponderacoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ponderacoes.findAll", query = "SELECT p FROM Ponderacoes p")
    , @NamedQuery(name = "Ponderacoes.findById", query = "SELECT p FROM Ponderacoes p WHERE p.id = :id")
    , @NamedQuery(name = "Ponderacoes.findByQuantidade", query = "SELECT p FROM Ponderacoes p WHERE p.quantidade = :quantidade")
    , @NamedQuery(name = "Ponderacoes.findByCreatedAt", query = "SELECT p FROM Ponderacoes p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "Ponderacoes.findByUpdatedAt", query = "SELECT p FROM Ponderacoes p WHERE p.updatedAt = :updatedAt")})
public class Ponderacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private double quantidade;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "fk_decreto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Decretos fkDecreto;
    @JoinColumn(name = "fk_item", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Itens fkItem;

    public Ponderacoes() {
    }

    public Ponderacoes(Integer id) {
        this.id = id;
    }

    public Ponderacoes(Integer id, double quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Decretos getFkDecreto() {
        return fkDecreto;
    }

    public void setFkDecreto(Decretos fkDecreto) {
        this.fkDecreto = fkDecreto;
    }

    public Itens getFkItem() {
        return fkItem;
    }

    public void setFkItem(Itens fkItem) {
        this.fkItem = fkItem;
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
        if (!(object instanceof Ponderacoes)) {
            return false;
        }
        Ponderacoes other = (Ponderacoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdcesta.Ponderacoes[ id=" + id + " ]";
    }
    
}
