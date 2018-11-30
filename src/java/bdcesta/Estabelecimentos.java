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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "estabelecimentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estabelecimentos.findAll", query = "SELECT e FROM Estabelecimentos e")
    , @NamedQuery(name = "Estabelecimentos.findById", query = "SELECT e FROM Estabelecimentos e WHERE e.id = :id")
    , @NamedQuery(name = "Estabelecimentos.findByNome", query = "SELECT e FROM Estabelecimentos e WHERE e.nome = :nome")
    , @NamedQuery(name = "Estabelecimentos.findByEmail", query = "SELECT e FROM Estabelecimentos e WHERE e.email = :email")
    , @NamedQuery(name = "Estabelecimentos.findByResponsavel", query = "SELECT e FROM Estabelecimentos e WHERE e.responsavel = :responsavel")
    , @NamedQuery(name = "Estabelecimentos.findByStatus", query = "SELECT e FROM Estabelecimentos e WHERE e.status = :status")
    , @NamedQuery(name = "Estabelecimentos.findByCreatedAt", query = "SELECT e FROM Estabelecimentos e WHERE e.createdAt = :createdAt")
    , @NamedQuery(name = "Estabelecimentos.findByUpdatedAt", query = "SELECT e FROM Estabelecimentos e WHERE e.updatedAt = :updatedAt")})
public class Estabelecimentos implements Serializable {

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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "responsavel")
    private String responsavel;
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
    @JoinColumn(name = "fk_tipo_estabelecimento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoEstabelecimentos fkTipoEstabelecimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEstabelecimento")
    private Collection<TelefoneEstabelecimentos> telefoneEstabelecimentosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEstabelecimento")
    private Collection<EnderecoEstabelecimentos> enderecoEstabelecimentosCollection;

    public Estabelecimentos() {
    }

    public Estabelecimentos(Integer id) {
        this.id = id;
    }

    public Estabelecimentos(Integer id, String nome, String responsavel, String status) {
        this.id = id;
        this.nome = nome;
        this.responsavel = responsavel;
        this.status = status;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
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

    public TipoEstabelecimentos getFkTipoEstabelecimento() {
        return fkTipoEstabelecimento;
    }

    public void setFkTipoEstabelecimento(TipoEstabelecimentos fkTipoEstabelecimento) {
        this.fkTipoEstabelecimento = fkTipoEstabelecimento;
    }

    @XmlTransient
    public Collection<TelefoneEstabelecimentos> getTelefoneEstabelecimentosCollection() {
        return telefoneEstabelecimentosCollection;
    }

    public void setTelefoneEstabelecimentosCollection(Collection<TelefoneEstabelecimentos> telefoneEstabelecimentosCollection) {
        this.telefoneEstabelecimentosCollection = telefoneEstabelecimentosCollection;
    }

    @XmlTransient
    public Collection<EnderecoEstabelecimentos> getEnderecoEstabelecimentosCollection() {
        return enderecoEstabelecimentosCollection;
    }

    public void setEnderecoEstabelecimentosCollection(Collection<EnderecoEstabelecimentos> enderecoEstabelecimentosCollection) {
        this.enderecoEstabelecimentosCollection = enderecoEstabelecimentosCollection;
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
        if (!(object instanceof Estabelecimentos)) {
            return false;
        }
        Estabelecimentos other = (Estabelecimentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdcesta.Estabelecimentos[ id=" + id + " ]";
    }
    
}
