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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UESB-USR
 */
@Entity
@Table(name = "regioes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regioes.findAll", query = "SELECT r FROM Regioes r")
    , @NamedQuery(name = "Regioes.findById", query = "SELECT r FROM Regioes r WHERE r.id = :id")
    , @NamedQuery(name = "Regioes.findByNome", query = "SELECT r FROM Regioes r WHERE r.nome = :nome")
    , @NamedQuery(name = "Regioes.findByCreatedAt", query = "SELECT r FROM Regioes r WHERE r.createdAt = :createdAt")
    , @NamedQuery(name = "Regioes.findByUpdatedAt", query = "SELECT r FROM Regioes r WHERE r.updatedAt = :updatedAt")})
public class Regioes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "fk_estado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estados fkEstado;

    public Regioes() {
    }

    public Regioes(Integer id) {
        this.id = id;
    }

    public Regioes(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Estados getFkEstado() {
        return fkEstado;
    }

    public void setFkEstado(Estados fkEstado) {
        this.fkEstado = fkEstado;
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
        if (!(object instanceof Regioes)) {
            return false;
        }
        Regioes other = (Regioes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdcesta.Regioes[ id=" + id + " ]";
    }
    
}
