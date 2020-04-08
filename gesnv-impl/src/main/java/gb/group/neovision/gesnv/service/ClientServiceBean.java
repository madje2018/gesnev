/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.service;



import gb.group.neovision.exceptions.BusinessExceptions;
import gb.group.neovision.gesnv.entities.Client;
import gb.group.neovision.gesnv.entities.Particulier;
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
public class ClientServiceBean implements ClientServiceBeanRemote{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void ajouter(Client client) {
        try{
           this.em.persist(client);
        }catch(Exception e){
            throw new BusinessExceptions("impossible d'ajouter un client");
        }
    }

    @Override
    public Client modifier(Client client) {        
           return this.em.merge(client);        
    }

    @Override
    public void supprimer(Client client) {
        this.em.remove(this.em.merge(client));
    }

    @Override
    public List<Client> lister() {
        String jpql = "SELECT c  FROM Client c "
                + "ORDER BY c.id ASC";
        Query query = this.em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public Client trouver(Long id) {
        return this.em.find(Client.class, id);
    }

    @Override
    public List<Client> getAll() {
        List<Client> liste = this.lister();
        for(Client client : liste){
            if(client instanceof Societe){
              ((Societe)client).getRaisonSociale();
              ((Societe)client).getNif();
            }else if(client instanceof Particulier){
                ((Particulier)client).getNom();
                ((Particulier)client).getPrenom();
                ((Particulier)client).getEmail();
            }
        }
        return liste;
    }

    @Override
    public List<Client> getList() {
       Query query = this.em.createQuery("SELECT s FROM Societe s");
       List<Client> clients = query.getResultList();
       
       query = this.em.createQuery("SELECT p FROM Particulier p");
       clients = query.getResultList();
       
       return clients;
    }
    
}
