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
@Table(name = "telefone_estabelecimentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelefoneEstabelecimentos.findAll", query = "SELECT t FROM TelefoneEstabelecimentos t")
    , @NamedQuery(name = "TelefoneEstabelecimentos.findById", query = "SELECT t FROM TelefoneEstabelecimentos t WHERE t.id = :id")
    , @NamedQuery(name = "TelefoneEstabelecimentos.findByContato", query = "SELECT t FROM TelefoneEstabelecimentos t WHERE t.contato = :contato")
    , @NamedQuery(name = "TelefoneEstabelecimentos.findByStatus", query = "SELECT t FROM TelefoneEstabelecimentos t WHERE t.status = :status")
    , @NamedQuery(name = "TelefoneEstabelecimentos.findByCreatedAt", query = "SELECT t FROM TelefoneEstabelecimentos t WHERE t.createdAt = :createdAt")
    , @NamedQuery(name = "TelefoneEstabelecimentos.findByUpdatedAt", query = "SELECT t FROM TelefoneEstabelecimentos t WHERE t.updatedAt = :updatedAt")})
public class TelefoneEstabelecimentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "contato")
    private String contato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "fk_estabelecimento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estabelecimentos fkEstabelecimento;

    public TelefoneEstabelecimentos() {
    }

    public TelefoneEstabelecimentos(Integer id) {
        this.id = id;
    }

    public TelefoneEstabelecimentos(Integer id, String contato, boolean status) {
        this.id = id;
        this.contato = contato;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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

    public Estabelecimentos getFkEstabelecimento() {
        return fkEstabelecimento;
    }

    public void setFkEstabelecimento(Estabelecimentos fkEstabelecimento) {
        this.fkEstabelecimento = fkEstabelecimento;
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
        if (!(object instanceof TelefoneEstabelecimentos)) {
            return false;
        }
        TelefoneEstabelecimentos other = (TelefoneEstabelecimentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdcesta.TelefoneEstabelecimentos[ id=" + id + " ]";
    }
    
}
