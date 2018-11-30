/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdcesta;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "cidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidades.findAll", query = "SELECT c FROM Cidades c")
    , @NamedQuery(name = "Cidades.findById", query = "SELECT c FROM Cidades c WHERE c.id = :id")
    , @NamedQuery(name = "Cidades.findByNome", query = "SELECT c FROM Cidades c WHERE c.nome = :nome")
    , @NamedQuery(name = "Cidades.findByCodigoIbge", query = "SELECT c FROM Cidades c WHERE c.codigoIbge = :codigoIbge")
    , @NamedQuery(name = "Cidades.findByPopulacao2010", query = "SELECT c FROM Cidades c WHERE c.populacao2010 = :populacao2010")
    , @NamedQuery(name = "Cidades.findByDensidadeDemo", query = "SELECT c FROM Cidades c WHERE c.densidadeDemo = :densidadeDemo")
    , @NamedQuery(name = "Cidades.findByGentilico", query = "SELECT c FROM Cidades c WHERE c.gentilico = :gentilico")
    , @NamedQuery(name = "Cidades.findByArea", query = "SELECT c FROM Cidades c WHERE c.area = :area")
    , @NamedQuery(name = "Cidades.findByCreatedAt", query = "SELECT c FROM Cidades c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "Cidades.findByUpdatedAt", query = "SELECT c FROM Cidades c WHERE c.updatedAt = :updatedAt")})
public class Cidades implements Serializable {

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
    @Column(name = "codigo_ibge")
    private int codigoIbge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "populacao_2010")
    private int populacao2010;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "densidade_demo")
    private BigDecimal densidadeDemo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "gentilico")
    private String gentilico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "area")
    private BigDecimal area;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "fk_estado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estados fkEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCidade")
    private Collection<Users> usersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCidade")
    private Collection<EnderecoEstabelecimentos> enderecoEstabelecimentosCollection;

    public Cidades() {
    }

    public Cidades(Integer id) {
        this.id = id;
    }

    public Cidades(Integer id, String nome, int codigoIbge, int populacao2010, BigDecimal densidadeDemo, String gentilico, BigDecimal area) {
        this.id = id;
        this.nome = nome;
        this.codigoIbge = codigoIbge;
        this.populacao2010 = populacao2010;
        this.densidadeDemo = densidadeDemo;
        this.gentilico = gentilico;
        this.area = area;
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

    public int getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(int codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public int getPopulacao2010() {
        return populacao2010;
    }

    public void setPopulacao2010(int populacao2010) {
        this.populacao2010 = populacao2010;
    }

    public BigDecimal getDensidadeDemo() {
        return densidadeDemo;
    }

    public void setDensidadeDemo(BigDecimal densidadeDemo) {
        this.densidadeDemo = densidadeDemo;
    }

    public String getGentilico() {
        return gentilico;
    }

    public void setGentilico(String gentilico) {
        this.gentilico = gentilico;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
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

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
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
        if (!(object instanceof Cidades)) {
            return false;
        }
        Cidades other = (Cidades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdcesta.Cidades[ id=" + id + " ]";
    }
    
}
