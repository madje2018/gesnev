/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.service;

import gb.group.neovision.exceptions.BusinessExceptions;
import gb.group.neovision.gesnv.entities.Societe;
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
public class ClientSctServiceBean implements ClientSctServiceBeanRemote{
    
    @PersistenceContext
    private EntityManager em;
    

    @Override
    public void ajouter(Societe societe) {
        try{
           this.em.persist(societe);
        }catch(Exception e){
            throw new BusinessExceptions("impossible d'ajouter un client");
        }
    }

    @Override
    public Societe modifier(Societe societe) {
        return this.em.merge(societe); 
    }

    @Override
    public Societe trouver(Long id) {
        return this.em.find(Societe.class, id);
    }

    @Override
    public void supprimer(Societe societe) {
        this.em.remove(this.em.merge(societe));
    }

    @Override
    public List<Societe> lister() {
        String jpql = "SELECT s FROM Societe s "
                + "ORDER BY s.id ASC";
        Query query = this.em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public Long add(Societe societe) {
        try{
            this.em.persist(societe);
        }catch (Exception e){
            throw new BusinessExceptions("Impossile d'ajouter un client");
        }
        em.flush();
        return societe.getId();
    }
    
}
