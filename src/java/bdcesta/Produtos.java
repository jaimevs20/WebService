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
@Table(name = "produtos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p")
    , @NamedQuery(name = "Produtos.findById", query = "SELECT p FROM Produtos p WHERE p.id = :id")
    , @NamedQuery(name = "Produtos.findByNome", query = "SELECT p FROM Produtos p WHERE p.nome = :nome")
    , @NamedQuery(name = "Produtos.findBySazonal", query = "SELECT p FROM Produtos p WHERE p.sazonal = :sazonal")
    , @NamedQuery(name = "Produtos.findByDescricao", query = "SELECT p FROM Produtos p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "Produtos.findByMarca", query = "SELECT p FROM Produtos p WHERE p.marca = :marca")
    , @NamedQuery(name = "Produtos.findByCreatedAt", query = "SELECT p FROM Produtos p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "Produtos.findByUpdatedAt", query = "SELECT p FROM Produtos p WHERE p.updatedAt = :updatedAt")})
public class Produtos implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "sazonal")
    private boolean sazonal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "marca")
    private String marca;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProduto")
    private Collection<PesquisaProdutos> pesquisaProdutosCollection;
    @JoinColumn(name = "fk_classe_produto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClasseProdutos fkClasseProduto;
    @JoinColumn(name = "fk_grupo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Grupos fkGrupo;
    @JoinColumn(name = "fk_item", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Itens fkItem;

    public Produtos() {
    }

    public Produtos(Integer id) {
        this.id = id;
    }

    public Produtos(Integer id, String nome, boolean sazonal, String descricao, String marca) {
        this.id = id;
        this.nome = nome;
        this.sazonal = sazonal;
        this.descricao = descricao;
        this.marca = marca;
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

    public boolean getSazonal() {
        return sazonal;
    }

    public void setSazonal(boolean sazonal) {
        this.sazonal = sazonal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
    public Collection<PesquisaProdutos> getPesquisaProdutosCollection() {
        return pesquisaProdutosCollection;
    }

    public void setPesquisaProdutosCollection(Collection<PesquisaProdutos> pesquisaProdutosCollection) {
        this.pesquisaProdutosCollection = pesquisaProdutosCollection;
    }

    public ClasseProdutos getFkClasseProduto() {
        return fkClasseProduto;
    }

    public void setFkClasseProduto(ClasseProdutos fkClasseProduto) {
        this.fkClasseProduto = fkClasseProduto;
    }

    public Grupos getFkGrupo() {
        return fkGrupo;
    }

    public void setFkGrupo(Grupos fkGrupo) {
        this.fkGrupo = fkGrupo;
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
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdcesta.Produtos[ id=" + id + " ]";
    }
    
}
