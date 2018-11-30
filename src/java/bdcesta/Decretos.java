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
@Table(name = "decretos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Decretos.findAll", query = "SELECT d FROM Decretos d")
    , @NamedQuery(name = "Decretos.findById", query = "SELECT d FROM Decretos d WHERE d.id = :id")
    , @NamedQuery(name = "Decretos.findByNumero", query = "SELECT d FROM Decretos d WHERE d.numero = :numero")
    , @NamedQuery(name = "Decretos.findByData", query = "SELECT d FROM Decretos d WHERE d.data = :data")
    , @NamedQuery(name = "Decretos.findByTitulo", query = "SELECT d FROM Decretos d WHERE d.titulo = :titulo")
    , @NamedQuery(name = "Decretos.findByUpload", query = "SELECT d FROM Decretos d WHERE d.upload = :upload")
    , @NamedQuery(name = "Decretos.findByStatus", query = "SELECT d FROM Decretos d WHERE d.status = :status")
    , @NamedQuery(name = "Decretos.findByCreatedAt", query = "SELECT d FROM Decretos d WHERE d.createdAt = :createdAt")
    , @NamedQuery(name = "Decretos.findByUpdatedAt", query = "SELECT d FROM Decretos d WHERE d.updatedAt = :updatedAt")})
public class Decretos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 255)
    @Column(name = "upload")
    private String upload;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkDecreto")
    private Collection<Ponderacoes> ponderacoesCollection;

    public Decretos() {
    }

    public Decretos(Integer id) {
        this.id = id;
    }

    public Decretos(Integer id, String numero, Date data, String titulo, String status) {
        this.id = id;
        this.numero = numero;
        this.data = data;
        this.titulo = titulo;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
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
        if (!(object instanceof Decretos)) {
            return false;
        }
        Decretos other = (Decretos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdcesta.Decretos[ id=" + id + " ]";
    }
    
}
