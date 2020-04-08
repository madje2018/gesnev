/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.service;

import gb.group.neovision.gesnv.entities.Facture;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author attia
 */
@Remote
public interface FactureServiceBeanRemote {
    
    void ajouter(Facture docFinancier);
    
    Facture modifier (Facture docFinancier);
    
    Facture trouver(Long id);
    
    void supprimer(Facture docFinancier);
    
    List<Facture> lister();
    
    double getMontantHT();
    
}
