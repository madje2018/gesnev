/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.service;

import gb.group.neovision.gesnv.entities.Societe;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author attia
 */
@Remote
public interface ClientSctServiceBeanRemote {
    void ajouter(Societe societe);
    
    Long add(Societe societe);
    
    Societe modifier(Societe  societe);
    
    Societe trouver(Long id);
    
    void  supprimer(Societe societe); 
    
    List<Societe> lister();
}
