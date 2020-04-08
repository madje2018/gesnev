/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.service;

import gb.group.neovision.gesnv.entities.Client;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author attia
 */
@Remote
public interface ClientServiceBeanRemote {
    void ajouter(Client client);
    
    Client modifier(Client client);
    
    Client trouver(Long id);
    
    void  supprimer(Client client); 
    
    List<Client> lister();
    
    List<Client> getAll();
    
    List<Client> getList();
}
