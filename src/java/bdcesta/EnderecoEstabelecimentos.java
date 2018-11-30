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
@Table(name = "endereco_estabelecimentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnderecoEstabelecimentos.findAll", query = "SELECT e FROM EnderecoEstabelecimentos e")
    , @NamedQuery(name = "EnderecoEstabelecimentos.findById", query = "SELECT e FROM EnderecoEstabelecimentos e WHERE e.id = :id")
    , @NamedQuery(name = "EnderecoEstabelecimentos.findByEndereco", query = "SELECT e FROM EnderecoEstabelecimentos e WHERE e.endereco = :endereco")
    , @NamedQuery(name = "EnderecoEstabelecimentos.findByStatus", query = "SELECT e FROM EnderecoEstabelecimentos e WHERE e.status = :status")
    , @NamedQuery(name = "EnderecoEstabelecimentos.findByCreatedAt", query = "SELECT e FROM EnderecoEstabelecimentos e WHERE e.createdAt = :createdAt")
    , @NamedQuery(name = "EnderecoEstabelecimentos.findByUpdatedAt", query = "SELECT e FROM EnderecoEstabelecimentos e WHERE e.updatedAt = :updatedAt")})
public class EnderecoEstabelecimentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "endereco")
    private String endereco;
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
    @JoinColumn(name = "fk_cidade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cidades fkCidade;
    @JoinColumn(name = "fk_estabelecimento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estabelecimentos fkEstabelecimento;

    public EnderecoEstabelecimentos() {
    }

    public EnderecoEstabelecimentos(Integer id) {
        this.id = id;
    }

    public EnderecoEstabelecimentos(Integer id, String endereco, boolean status) {
        this.id = id;
        this.endereco = endereco;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public Cidades getFkCidade() {
        return fkCidade;
    }

    public void setFkCidade(Cidades fkCidade) {
        this.fkCidade = fkCidade;
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
        if (!(object instanceof EnderecoEstabelecimentos)) {
            return false;
        }
        EnderecoEstabelecimentos other = (EnderecoEstabelecimentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdcesta.EnderecoEstabelecimentos[ id=" + id + " ]";
    }
    
}
