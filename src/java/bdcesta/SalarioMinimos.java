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
@Table(name = "salario_minimos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalarioMinimos.findAll", query = "SELECT s FROM SalarioMinimos s")
    , @NamedQuery(name = "SalarioMinimos.findById", query = "SELECT s FROM SalarioMinimos s WHERE s.id = :id")
    , @NamedQuery(name = "SalarioMinimos.findByMes", query = "SELECT s FROM SalarioMinimos s WHERE s.mes = :mes")
    , @NamedQuery(name = "SalarioMinimos.findByAno", query = "SELECT s FROM SalarioMinimos s WHERE s.ano = :ano")
    , @NamedQuery(name = "SalarioMinimos.findByValorBruto", query = "SELECT s FROM SalarioMinimos s WHERE s.valorBruto = :valorBruto")
    , @NamedQuery(name = "SalarioMinimos.findByValorLiquido", query = "SELECT s FROM SalarioMinimos s WHERE s.valorLiquido = :valorLiquido")
    , @NamedQuery(name = "SalarioMinimos.findByHoras", query = "SELECT s FROM SalarioMinimos s WHERE s.horas = :horas")
    , @NamedQuery(name = "SalarioMinimos.findByCreatedAt", query = "SELECT s FROM SalarioMinimos s WHERE s.createdAt = :createdAt")
    , @NamedQuery(name = "SalarioMinimos.findByUpdatedAt", query = "SELECT s FROM SalarioMinimos s WHERE s.updatedAt = :updatedAt")})
public class SalarioMinimos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mes")
    private String mes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ano")
    private String ano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_bruto")
    private double valorBruto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_liquido")
    private double valorLiquido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horas")
    @Temporal(TemporalType.TIME)
    private Date horas;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public SalarioMinimos() {
    }

    public SalarioMinimos(Integer id) {
        this.id = id;
    }

    public SalarioMinimos(Integer id, String mes, String ano, double valorBruto, double valorLiquido, Date horas) {
        this.id = id;
        this.mes = mes;
        this.ano = ano;
        this.valorBruto = valorBruto;
        this.valorLiquido = valorLiquido;
        this.horas = horas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public Date getHoras() {
        return horas;
    }

    public void setHoras(Date horas) {
        this.horas = horas;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalarioMinimos)) {
            return false;
        }
        SalarioMinimos other = (SalarioMinimos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdcesta.SalarioMinimos[ id=" + id + " ]";
    }
    
}
