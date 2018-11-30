/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdcesta;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UESB-USR
 */
@Entity
@Table(name = "model_has_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModelHasRoles.findAll", query = "SELECT m FROM ModelHasRoles m")
    , @NamedQuery(name = "ModelHasRoles.findByRoleId", query = "SELECT m FROM ModelHasRoles m WHERE m.modelHasRolesPK.roleId = :roleId")
    , @NamedQuery(name = "ModelHasRoles.findByModelType", query = "SELECT m FROM ModelHasRoles m WHERE m.modelHasRolesPK.modelType = :modelType")
    , @NamedQuery(name = "ModelHasRoles.findByModelId", query = "SELECT m FROM ModelHasRoles m WHERE m.modelHasRolesPK.modelId = :modelId")})
public class ModelHasRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModelHasRolesPK modelHasRolesPK;
    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Roles roles;

    public ModelHasRoles() {
    }

    public ModelHasRoles(ModelHasRolesPK modelHasRolesPK) {
        this.modelHasRolesPK = modelHasRolesPK;
    }

    public ModelHasRoles(int roleId, String modelType, long modelId) {
        this.modelHasRolesPK = new ModelHasRolesPK(roleId, modelType, modelId);
    }

    public ModelHasRolesPK getModelHasRolesPK() {
        return modelHasRolesPK;
    }

    public void setModelHasRolesPK(ModelHasRolesPK modelHasRolesPK) {
        this.modelHasRolesPK = modelHasRolesPK;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modelHasRolesPK != null ? modelHasRolesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModelHasRoles)) {
            return false;
        }
        ModelHasRoles other = (ModelHasRoles) object;
        if ((this.modelHasRolesPK == null && other.modelHasRolesPK != null) || (this.modelHasRolesPK != null && !this.modelHasRolesPK.equals(other.modelHasRolesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdcesta.ModelHasRoles[ modelHasRolesPK=" + modelHasRolesPK + " ]";
    }
    
}
