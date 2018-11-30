/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdcesta;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UESB-USR
 */
@Entity
@Table(name = "itens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itens.findAll", query = "SELECT i FROM Itens i")
    , @NamedQuery(name = "Itens.findById", query = "SELECT i FROM Itens i WHERE i.id = :id")
    , @NamedQuery(name = "Itens.findByTipo", query = "SELECT i FROM Itens i WHERE i.tipo = :tipo")
    , @NamedQuery(name = "Itens.findByUnidadeMedida", query = "SELECT i FROM Itens i WHERE i.unidadeMedida = :unidadeMedida")
    , @NamedQuery(name = "Itens.findByStatus", query = "SELECT i FROM Itens i WHERE i.status = :status")
    , @NamedQuery(name = "Itens.findByCreatedAt", query = "SELECT i FROM Itens i WHERE i.createdAt = :createdAt")
    , @NamedQuery(name = "Itens.findByUpdatedAt", query = "SELECT i FROM Itens i WHERE i.updatedAt = :updatedAt")})
public class Itens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "unidade_medida")
    private String unidadeMedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status")
    private String status;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkItem")
    private Collection<Produtos> produtosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkItem")
    private Collection<Ponderacoes> ponderacoesCollection;

    public Itens() {
    }

    public Itens(Integer id) {
        this.id = id;
    }

    public Itens(Integer id, String tipo, String unidadeMedida, String status) {
        this.id = id;
        this.tipo = tipo;
        this.unidadeMedida = unidadeMedida;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @XmlTransient
    public Collection<Produtos> getProdutosCollection() {
        return produtosCollection;
    }

    public void setProdutosCollection(Collection<Produtos> produtosCollection) {
        this.produtosCollection = produtosCollection;
    }

    @XmlTransient
    public Collection<Ponderacoes> getPonderacoesCollection() {
        return ponderacoesCollection;
    }

    public void setPonderacoesCollection(Collection<Ponderacoes> ponderacoesCollection) {
        this.ponderacoesCollection = ponderacoesCollection;
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
        if (!(object instanceof Itens)) {
            return false;
        }
        Itens other = (Itens) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdcesta.Itens[ id=" + id + " ]";
    }
    
}
