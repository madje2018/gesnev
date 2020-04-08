/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.service;

import gb.group.neovision.exceptions.BusinessExceptions;
import gb.group.neovision.gesnv.entities.Particulier;
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
public class ClientPrtServiceBean implements ClientPrtServiceBeanRemote{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void ajouter(Particulier particulier) {
        try{
           this.em.persist(particulier);
        }catch(Exception e){
            throw new BusinessExceptions("impossible d'ajouter un client");
        }
    }

    @Override
    public Particulier modifier(Particulier particulier) {
        return this.em.merge(particulier);
    }

    @Override
    public Particulier trouver(Long id) {
        return this.em.find(Particulier.class, id);
    }

    @Override
    public void supprimer(Particulier particulier) {
        this.em.remove(this.em.merge(particulier));
    }

    @Override
    public List<Particulier> lister() {
        String jpql = "SELECT p FROM Particulier p "
                + "ORDER BY p.id ASC";
        Query query = this.em.createQuery(jpql);
        return query.getResultList();
    }
    
}
