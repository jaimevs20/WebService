/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdcesta.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author UESB-USR
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(bdcesta.service.AlterarPesquisasFacadeREST.class);
        resources.add(bdcesta.service.CidadesFacadeREST.class);
        resources.add(bdcesta.service.ClasseProdutosFacadeREST.class);
        resources.add(bdcesta.service.DecretosFacadeREST.class);
        resources.add(bdcesta.service.EnderecoEstabelecimentosFacadeREST.class);
        resources.add(bdcesta.service.EstabelecimentosFacadeREST.class);
        resources.add(bdcesta.service.EstadosFacadeREST.class);
        resources.add(bdcesta.service.GruposFacadeREST.class);
        resources.add(bdcesta.service.ItensFacadeREST.class);
        resources.add(bdcesta.service.MigrationsFacadeREST.class);
        resources.add(bdcesta.service.ModelHasPermissionsFacadeREST.class);
        resources.add(bdcesta.service.ModelHasRolesFacadeREST.class);
        resources.add(bdcesta.service.PermissionsFacadeREST.class);
        resources.add(bdcesta.service.PesquisaProdutosFacadeREST.class);
        resources.add(bdcesta.service.PonderacoesFacadeREST.class);
        resources.add(bdcesta.service.ProdutosFacadeREST.class);
        resources.add(bdcesta.service.RegioesFacadeREST.class);
        resources.add(bdcesta.service.RolesFacadeREST.class);
        resources.add(bdcesta.service.SalarioMinimosFacadeREST.class);
        resources.add(bdcesta.service.TelefoneEstabelecimentosFacadeREST.class);
        resources.add(bdcesta.service.TipoEstabelecimentosFacadeREST.class);
        resources.add(bdcesta.service.UsersFacadeREST.class);
    }
    
}
