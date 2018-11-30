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
@Table(name = "pesquisa_produtos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PesquisaProdutos.findAll", query = "SELECT p FROM PesquisaProdutos p")
    , @NamedQuery(name = "PesquisaProdutos.findById", query = "SELECT p FROM PesquisaProdutos p WHERE p.id = :id")
    , @NamedQuery(name = "PesquisaProdutos.findByValor", query = "SELECT p FROM PesquisaProdutos p WHERE p.valor = :valor")
    , @NamedQuery(name = "PesquisaProdutos.findByDataHora", query = "SELECT p FROM PesquisaProdutos p WHERE p.dataHora = :dataHora")
    , @NamedQuery(name = "PesquisaProdutos.findByOcorrencia", query = "SELECT p FROM PesquisaProdutos p WHERE p.ocorrencia = :ocorrencia")
    , @NamedQuery(name = "PesquisaProdutos.findByPromocao", query = "SELECT p FROM PesquisaProdutos p WHERE p.promocao = :promocao")
    , @NamedQuery(name = "PesquisaProdutos.findByObservaoes", query = "SELECT p FROM PesquisaProdutos p WHERE p.observaoes = :observaoes")
    , @NamedQuery(name = "PesquisaProdutos.findByCreatedAt", query = "SELECT p FROM PesquisaProdutos p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "PesquisaProdutos.findByUpdatedAt", query = "SELECT p FROM PesquisaProdutos p WHERE p.updatedAt = :updatedAt")})
public class PesquisaProdutos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ocorrencia")
    private String ocorrencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "promocao")
    private boolean promocao;
    @Size(max = 2147483647)
    @Column(name = "observaoes")
    private String observaoes;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "fk_produto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produtos fkProduto;
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users fkUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPesquisa")
    private Collection<AlterarPesquisas> alterarPesquisasCollection;

    public PesquisaProdutos() {
    }

    public PesquisaProdutos(Integer id) {
        this.id = id;
    }

    public PesquisaProdutos(Integer id, double valor, Date dataHora, String ocorrencia, boolean promocao) {
        this.id = id;
        this.valor = valor;
        this.dataHora = dataHora;
        this.ocorrencia = ocorrencia;
        this.promocao = promocao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public boolean getPromocao() {
        return promocao;
    }

    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    }

    public String getObservaoes() {
        return observaoes;
    }

    public void setObservaoes(String observaoes) {
        this.observaoes = observaoes;
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

    public Produtos getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(Produtos fkProduto) {
        this.fkProduto = fkProduto;
    }

    public Users getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Users fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    @XmlTransient
    public Collection<AlterarPesquisas> getAlterarPesquisasCollection() {
        return alterarPesquisasCollection;
    }

    public void setAlterarPesquisasCollection(Collection<AlterarPesquisas> alterarPesquisasCollection) {
        this.alterarPesquisasCollection = alterarPesquisasCollection;
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
        if (!(object instanceof PesquisaProdutos)) {
            return false;
        }
        PesquisaProdutos other = (PesquisaProdutos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdcesta.PesquisaProdutos[ id=" + id + " ]";
    }
    
}
