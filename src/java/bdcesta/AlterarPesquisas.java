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
@Table(name = "alterar_pesquisas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlterarPesquisas.findAll", query = "SELECT a FROM AlterarPesquisas a")
    , @NamedQuery(name = "AlterarPesquisas.findById", query = "SELECT a FROM AlterarPesquisas a WHERE a.id = :id")
    , @NamedQuery(name = "AlterarPesquisas.findByDescricao", query = "SELECT a FROM AlterarPesquisas a WHERE a.descricao = :descricao")
    , @NamedQuery(name = "AlterarPesquisas.findByCreatedAt", query = "SELECT a FROM AlterarPesquisas a WHERE a.createdAt = :createdAt")
    , @NamedQuery(name = "AlterarPesquisas.findByUpdatedAt", query = "SELECT a FROM AlterarPesquisas a WHERE a.updatedAt = :updatedAt")})
public class AlterarPesquisas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "fk_pesquisa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PesquisaProdutos fkPesquisa;
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users fkUsuario;

    public AlterarPesquisas() {
    }

    public AlterarPesquisas(Integer id) {
        this.id = id;
    }

    public AlterarPesquisas(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public PesquisaProdutos getFkPesquisa() {
        return fkPesquisa;
    }

    public void setFkPesquisa(PesquisaProdutos fkPesquisa) {
        this.fkPesquisa = fkPesquisa;
    }

    public Users getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Users fkUsuario) {
        this.fkUsuario = fkUsuario;
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
        if (!(object instanceof AlterarPesquisas)) {
            return false;
        }
        AlterarPesquisas other = (AlterarPesquisas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdcesta.AlterarPesquisas[ id=" + id + " ]";
    }
    
}
