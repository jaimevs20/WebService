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
@Table(name = "tipo_estabelecimentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEstabelecimentos.findAll", query = "SELECT t FROM TipoEstabelecimentos t")
    , @NamedQuery(name = "TipoEstabelecimentos.findById", query = "SELECT t FROM TipoEstabelecimentos t WHERE t.id = :id")
    , @NamedQuery(name = "TipoEstabelecimentos.findByTipo", query = "SELECT t FROM TipoEstabelecimentos t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "TipoEstabelecimentos.findByStatus", query = "SELECT t FROM TipoEstabelecimentos t WHERE t.status = :status")
    , @NamedQuery(name = "TipoEstabelecimentos.findByCreatedAt", query = "SELECT t FROM TipoEstabelecimentos t WHERE t.createdAt = :createdAt")
    , @NamedQuery(name = "TipoEstabelecimentos.findByUpdatedAt", query = "SELECT t FROM TipoEstabelecimentos t WHERE t.updatedAt = :updatedAt")})
public class TipoEstabelecimentos implements Serializable {

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
    @Column(name = "status")
    private String status;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkTipoEstabelecimento")
    private Collection<Estabelecimentos> estabelecimentosCollection;

    public TipoEstabelecimentos() {
    }

    public TipoEstabelecimentos(Integer id) {
        this.id = id;
    }

    public TipoEstabelecimentos(Integer id, String tipo, String status) {
        this.id = id;
        this.tipo = tipo;
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
    public Collection<Estabelecimentos> getEstabelecimentosCollection() {
        return estabelecimentosCollection;
    }

    public void setEstabelecimentosCollection(Collection<Estabelecimentos> estabelecimentosCollection) {
        this.estabelecimentosCollection = estabelecimentosCollection;
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
        if (!(object instanceof TipoEstabelecimentos)) {
            return false;
        }
        TipoEstabelecimentos other = (TipoEstabelecimentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdcesta.TipoEstabelecimentos[ id=" + id + " ]";
    }
    
}
