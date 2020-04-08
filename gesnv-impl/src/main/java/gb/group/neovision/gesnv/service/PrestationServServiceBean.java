/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.service;

import gb.group.neovision.exceptions.BusinessExceptions;
import gb.group.neovision.gesnv.entities.IdPrestationService;
import gb.group.neovision.gesnv.entities.PrestationService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author attia
 */
@Stateless
public class PrestationServServiceBean implements PrestationServServiceBeanRemote{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void supprimer(PrestationService prestationService) {
        this.em.remove(this.em.merge(prestationService));
    }

    @Override
    public List<PrestationService> lister() {
        String jpql = "SELECT ps FROM PrestationService ps "
                + "ORDER BY ps.id ASC";
        Query query = this.em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public PrestationService trouver(Long idService, Long idPrestation) {
        IdPrestationService idprestationService = new IdPrestationService(idPrestation, idService);
        return this.em.find(PrestationService.class, idprestationService);
    }
    
}
