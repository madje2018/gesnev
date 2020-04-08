/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.service;

import gb.group.neovision.gesnv.entities.Taxe;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author attia
 */
@Remote
public interface TaxeServiceBeanRemote {
    void ajouter(Taxe taxe);
    
    Taxe modifier (Taxe taxe);
    
    Taxe trouver(String id);
    
    void supprimer(String id);
    
    void supprime(Taxe taxe);
    
    List<Taxe> lister();
    
    double getTaux(Taxe taxe);
}
