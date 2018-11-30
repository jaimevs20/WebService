/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdcesta.service;

import bdcesta.ModelHasRoles;
import bdcesta.ModelHasRolesPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author UESB-USR
 */
@Stateless
@Path("bdcesta.modelhasroles")
public class ModelHasRolesFacadeREST extends AbstractFacade<ModelHasRoles> {

    @PersistenceContext(unitName = "CestaPU")
    private EntityManager em;

    private ModelHasRolesPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;roleId=roleIdValue;modelType=modelTypeValue;modelId=modelIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        bdcesta.ModelHasRolesPK key = new bdcesta.ModelHasRolesPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> roleId = map.get("roleId");
        if (roleId != null && !roleId.isEmpty()) {
            key.setRoleId(new java.lang.Integer(roleId.get(0)));
        }
        java.util.List<String> modelType = map.get("modelType");
        if (modelType != null && !modelType.isEmpty()) {
            key.setModelType(modelType.get(0));
        }
        java.util.List<String> modelId = map.get("modelId");
        if (modelId != null && !modelId.isEmpty()) {
            key.setModelId(new java.lang.Long(modelId.get(0)));
        }
        return key;
    }

    public ModelHasRolesFacadeREST() {
        super(ModelHasRoles.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(ModelHasRoles entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, ModelHasRoles entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        bdcesta.ModelHasRolesPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ModelHasRoles find(@PathParam("id") PathSegment id) {
        bdcesta.ModelHasRolesPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ModelHasRoles> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ModelHasRoles> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
