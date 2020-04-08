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
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author attia
 */
@Stateless
public class PrestationServiceBean implements PrestationServiceBeanRemote{
    
    @EJB
    private ServServiceBeanRemote serviceService;
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void ajouter(Prestation prestation) {
       try{
           this.em.persist(prestation);
       }catch (Exception e){
           throw new BusinessExceptions("impossible d'ajouter une prestation");
       }
    }

    @Override
    public Prestation modifier(Prestation prestation) {
        return this.em.merge(prestation);
    }

    @Override
    public Prestation trouver(Long id) {
        return this.em.find(Prestation.class, id);
    }

    @Override
    public void supprimer(Long id) {
        this.em.remove(this.trouver(id));
    }

    @Override
    public List<Prestation> lister() {
        String jpql = "SELECT p FROM Prestation p "
                + "ORDER BY p.id ASC";
        Query query = this.em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public List<Service> getService(Prestation p) {
        String jpql = "SELECT DISTINCT ps.service FROM Prestation p LEFT JOIN p.prestationservice ps "
                + "where p = :paramPrestation";
        Query query = this.em.createQuery(jpql);
        query.setParameter("paramPrestation", p);
        return query.getResultList();
    }

    @Override
    public Long add(Prestation prestation) {
        try{
            this.em.persist(prestation);
        }catch(Exception e){
            throw new BusinessExceptions("impossible d'ajouter une prestation");
        }
        em.flush();
        return prestation.getId();
    }  

    @Override
    public Prestation addwithflush(Prestation prestation) {
        try{
            this.em.persist(prestation);
        }catch(Exception e){
          throw new BusinessExceptions("impossible d'ajouter une prestation");  
        }
        em.flush();
        return prestation;
    }   

    @Override
    public void supprimer(Prestation p) {
        this.em.remove(this.em.merge(p));
    }
    
}
