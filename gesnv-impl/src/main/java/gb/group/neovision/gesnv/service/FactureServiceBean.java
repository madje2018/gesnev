/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.service;

import gb.group.neovision.exceptions.BusinessExceptions;
import gb.group.neovision.gesnv.entities.Facture;
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
public class FactureServiceBean implements FactureServiceBeanRemote{
    
    @PersistenceContext 
    private EntityManager em;
    

    @Override
    public void ajouter(Facture facture) {
        try{
           this.em.persist(facture);
        }catch (Exception e){
           throw new BusinessExceptions("Impossible d'ajouter le document");
        }
    }

    @Override
    public Facture modifier(Facture facture) {
        return this.em.merge(facture);
    }

    @Override
    public Facture trouver(Long id) {
        return this.em.find(Facture.class, id);
    }

    @Override
    public void supprimer(Facture facture) {
        this.em.remove(facture);
    }

    @Override
    public List<Facture> lister() {
        String jpql = "SELECT f FROM Facture f "
                + " ORDER BY dF.id ASC";
        Query query = this.em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public double getMontantHT() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
