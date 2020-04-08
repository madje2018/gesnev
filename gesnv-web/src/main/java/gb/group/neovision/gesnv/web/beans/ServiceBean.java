/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.web.beans;

import gb.group.neovision.exceptions.BusinessExceptions;
import gb.group.neovision.gesnv.entities.Service;
import gb.group.neovision.gesnv.service.ServServiceBeanRemote;
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
public class ServiceBean {
    
    @EJB
    private ServServiceBeanRemote servService;
    
    private List<Service> services;
    
    private Service service;
    
    private Long idService;
    
    public ServiceBean() {
    }
    
    @PostConstruct
    public void initList(){
        this.services = this.servService.lister();
    }
    
    public void initService(){
        if(this.idService!=null){
            this.service = this.servService.trouver(this.idService);
        }else{
            this.service = new Service();
        }
    }
    
    public String enregistrer(){       
        try{
        if(this.idService==null){
        this.servService.ajouter(this.service);
        Messages.addGlobalInfo("Service ajouté avec succès");
        }else{
            this.servService.modifier(this.service);
            Messages.addGlobalInfo("Service modifié avec succès");
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
    
    public String supprimer(Service s){
        try{
           this.servService.supprime(s);
           Messages.addGlobalInfo("Opération effectuée avec succes");
        }catch (BusinessExceptions e){
            Messages.addGlobalError(e.getMessage());
        }
        catch (Exception e){
            Messages.addGlobalError("erreur inconnu");
        }
      return "list?faces-redirect=true";  
    }
    

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
    }
    
    
}
