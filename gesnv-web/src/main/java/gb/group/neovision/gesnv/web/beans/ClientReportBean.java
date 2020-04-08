/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.web.beans;

import gb.group.neovision.gesnv.entities.Client;
import gb.group.neovision.gesnv.service.ClientServiceBeanRemote;
import gb.group.neovision.gesnv.web.dr.ClientDRDesign;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author attia
 */
@ManagedBean
@ViewScoped
public class ClientReportBean extends GenericDRBean{
    
    @EJB
    private ClientServiceBeanRemote clientService;
    
    private List<Client> clients;

    public ClientReportBean() {
    }
    
    @PostConstruct
    @Override
    public void init(){
        this.clients = this.clientService.lister();
        super.init();
        
    }
    
    public ClientDRDesign getDRDesign(){
        return new ClientDRDesign();
    }

    public List<Client> getClients() {
        return clients;
    }
    
    
}
