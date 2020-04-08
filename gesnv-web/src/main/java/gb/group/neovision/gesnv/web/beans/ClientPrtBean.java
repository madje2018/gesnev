/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.web.beans;

import gb.group.neovision.exceptions.BusinessExceptions;
import gb.group.neovision.gesnv.entities.Particulier;
import gb.group.neovision.gesnv.service.ClientPrtServiceBeanRemote;
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
public class ClientPrtBean {
    
    @EJB
    private ClientPrtServiceBeanRemote particulierService;
    
    private List<Particulier> particuliers;
    
    private Particulier particulier;
    
    protected Long idClient;
    

    public ClientPrtBean() {
    }
    
    
    @PostConstruct
    public void initList(){
        this.particuliers = this.particulierService.lister();
    }
    
    public void initClient(){
        if(this.idClient!=null){
            this.particulier = this.particulierService.trouver(this.idClient);
        }else{
            this.particulier = new Particulier();
        }
    }
    
    
    public String enregistrer(){
      try{
        if(this.idClient==null){
        this.particulierService.ajouter(this.particulier);
        Messages.addGlobalInfo("Client ajouté avec succès");
        }else{
            this.particulierService.modifier(this.particulier);
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
    
    public  String supprimer(Particulier p){
        try{
           this.particulierService.supprimer(p);
           Messages.addGlobalInfo("Opération effectuée avec succes");
        }catch (BusinessExceptions e){
            Messages.addGlobalError(e.getMessage());
        }
        catch (Exception e){
            Messages.addGlobalError("erreur inconnu");
        }
        return "list?faces-redirect=true";
    }

    public List<Particulier> getParticuliers() {
        return particuliers;
    }

    public void setParticuliers(List<Particulier> particuliers) {
        this.particuliers = particuliers;
    }

    public Particulier getParticulier() {
        return particulier;
    }

    public void setParticulier(Particulier particulier) {
        this.particulier = particulier;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
     
     

}
