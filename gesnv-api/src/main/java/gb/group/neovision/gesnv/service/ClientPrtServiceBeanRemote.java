/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.service;

import gb.group.neovision.gesnv.entities.Particulier;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author attia
 */
@Remote
public interface ClientPrtServiceBeanRemote {
    
    void ajouter(Particulier particulier);  
    
    Particulier modifier(Particulier  particulier);
    
    Particulier trouver(Long id);
    
    void  supprimer(Particulier particulier); 
    
    List<Particulier> lister();
    
}
