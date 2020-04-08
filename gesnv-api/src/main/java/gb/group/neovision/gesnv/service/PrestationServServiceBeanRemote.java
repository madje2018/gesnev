/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.service;

import gb.group.neovision.gesnv.entities.IdPrestationService;
import gb.group.neovision.gesnv.entities.PrestationService;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author attia
 */
@Remote
public interface PrestationServServiceBeanRemote {
    
    PrestationService trouver(Long idService , Long idPrestation);
    
    void supprimer(PrestationService prestationService);
    
    List<PrestationService> lister();
    
}
