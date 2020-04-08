/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.web.beans;

import gb.group.neovision.exceptions.BusinessExceptions;
import gb.group.neovision.gesnv.entities.Client;
import gb.group.neovision.gesnv.service.ClientServiceBeanRemote;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Messages;

/**
 *
 * @author attia
 */
@ManagedBean
@ViewScoped
public class ClientBean {
    
    @EJB 
    protected ClientServiceBeanRemote clientService;
    
    protected List<Client> clients;
    
    protected Client client;
    
    protected Long idClient;

    public ClientBean() {
    }
    
    @PostConstruct
    public void initList(){
        this.clients = clientService.getList();
    }
    
    
    public String enregistrer(){
      try{
        if(this.idClient==null){
        this.clientService.ajouter(this.client);
        Messages.addGlobalInfo("Client ajouté avec succès");
        }else{
            this.clientService.modifier(this.client);
            Messages.addGlobalInfo("Client modifié avec succès");
        }
      } catch (BusinessExceptions e){
          Messages.addGlobalError(e.getMessage());
          e.printStackTrace();
      }catch (Exception e){
          Messages.addGlobalError("Echec d'ajout");
          e.printStackTrace();
      }
      return "list?faces-redirect=true";
    }

    public  String supprimer(Client c){
        try{
           this.clientService.supprimer(c);
           Messages.addGlobalInfo("Opération effectuée avec succes");
        }catch (BusinessExceptions e){
            Messages.addGlobalError(e.getMessage());
        }
        catch (Exception e){
            Messages.addGlobalError("erreur inconnu");
        }
        return "list?faces-redirect=true";
    }


    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
    
    
    
    
}
