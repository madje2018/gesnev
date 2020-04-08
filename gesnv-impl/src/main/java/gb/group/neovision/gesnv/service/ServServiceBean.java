/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.service;

import gb.group.neovision.exceptions.BusinessExceptions;
import gb.group.neovision.gesnv.entities.Prestation;
import gb.group.neovision.gesnv.entities.Service;
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
public class ServServiceBean implements ServServiceBeanRemote{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void ajouter(Service service) {
        try{
           this.em.persist(service);
        }catch(Exception e){
            throw new BusinessExceptions("impossible d'ajouter un service");
        }
    }

    @Override
    public Service modifier(Service service) {       
           return this.em.merge(service);       
    }

    @Override
    public Service trouver(Long id) {
        return this.em.find(Service.class, id);
    }

    @Override
    public void supprimer(Long id) {
        this.em.remove(this.trouver(id));
    }

    @Override
    public List<Service> lister() {
        String jpql = "SELECT s FROM Service s "
                + "ORDER BY s.id ASC";
        Query query = this.em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public List<Service> getAll(Prestation p) {
        String jpql = "SELECT DISTINCT ps.service FROM PrestationService ps "
                + "WHERE ps.prestation = :paramPrestation";
        Query query = this.em.createQuery(jpql);
        query.setParameter("paramPrestation", p);
        return query.getResultList();
        
    }

    @Override
    public double getPrixUnitaire(Service service) {        
       return service.getPrixUnitaire();
    }

    @Override
    public void supprime(Service s) {
        this.em.remove(this.em.merge(s));
    }
    
}
