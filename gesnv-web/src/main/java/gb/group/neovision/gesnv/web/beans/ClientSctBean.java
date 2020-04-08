/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.web.beans;

import gb.group.neovision.exceptions.BusinessExceptions;
import gb.group.neovision.gesnv.entities.Societe;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Messages;
import gb.group.neovision.gesnv.service.ClientSctServiceBeanRemote;

/**
 *
 * @author attia
 */
@ManagedBean
@ViewScoped
public class ClientSctBean{
    
    @EJB
    private ClientSctServiceBeanRemote societeService;
    
    
    private List<Societe> societes;
      
    private Societe societe;
    
    private Long idClient;
   

    public ClientSctBean() {
    }
    
    
    @PostConstruct
    public void initList(){
        this.societes = societeService.lister();
    }
    
    public void initClient(){
        if(this.idClient!=null){
            this.societe = this.societeService.trouver(this.idClient);
        }else{
            this.societe = new Societe();
        }
    }
    
    public String enregistrer(){
      try{
        if(this.idClient==null){
        this.societeService.ajouter(this.societe);
        Messages.addGlobalInfo("Client ajouté avec succès");
        }else{
            this.societeService.modifier(this.societe);
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
    
    public  String supprimer(Societe s){
        try{
           this.societeService.supprimer(s);
           Messages.addGlobalInfo("Opération effectuée avec succes");
        }catch (BusinessExceptions e){
            Messages.addGlobalError(e.getMessage());
        }
        catch (Exception e){
            Messages.addGlobalError("erreur inconnu");
        }
        return "list?faces-redirect=true";
    }

    public List<Societe> getSocietes() {
        return societes;
    }

    public void setSocietes(List<Societe> societes) {
        this.societes = societes;
    }
    
    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }   
    
}
