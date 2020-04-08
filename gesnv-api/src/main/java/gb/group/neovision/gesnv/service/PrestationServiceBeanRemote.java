/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.service;

import gb.group.neovision.gesnv.entities.Prestation;
import gb.group.neovision.gesnv.entities.PrestationService;
import gb.group.neovision.gesnv.entities.Service;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author attia
 */
@Remote
public interface PrestationServiceBeanRemote {
    
    void ajouter(Prestation prestation);
    
    Long add(Prestation prestation);
    
    Prestation addwithflush(Prestation prestation);
    
    Prestation modifier(Prestation prestation);
    
    Prestation trouver(Long id);
    
    void supprimer(Long id);
    
    void supprimer(Prestation p);
    
    List<Prestation>lister();
    
    List<Service> getService(Prestation p);    
    
}
