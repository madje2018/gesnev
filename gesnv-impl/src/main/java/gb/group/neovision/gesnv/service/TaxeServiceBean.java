/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.service;

import gb.group.neovision.exceptions.BusinessExceptions;
import gb.group.neovision.gesnv.entities.Taxe;
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
public class TaxeServiceBean implements TaxeServiceBeanRemote{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void ajouter(Taxe taxe) {
        try{
           this.em.persist(taxe);
        }catch(Exception e){
            throw new BusinessExceptions("impossible d'ajouter un service");
        }
    }

    @Override
    public Taxe modifier(Taxe taxe) {
        return this.em.merge(taxe);
    }

    @Override
    public Taxe trouver(String id) {
        return this.em.find(Taxe.class, id);
    }

    @Override
    public void supprimer(String id) {
        this.em.remove(this.trouver(id));
    }

    @Override
    public void supprime(Taxe taxe) {
        this.em.remove(this.em.merge(taxe));
    }

    @Override
    public List<Taxe> lister() {
        String jpql = "SELECT t FROM Taxe t";                
        Query query = this.em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public double getTaux(Taxe taxe) {
        return taxe.getTaux();
    }
    
}
