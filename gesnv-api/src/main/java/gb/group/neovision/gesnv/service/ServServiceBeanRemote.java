/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.service;

import gb.group.neovision.gesnv.entities.Prestation;
import gb.group.neovision.gesnv.entities.Service;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author attia
 */
@Remote
public interface ServServiceBeanRemote {
    
    void ajouter(Service service);
    
    Service modifier (Service service);
    
    Service trouver(Long id);
    
    void supprimer(Long id);
    
    void supprime(Service s);
    
    List<Service> lister();
    
    List<Service> getAll(Prestation prestation);
    
    double getPrixUnitaire(Service service);
    
    
    
}
