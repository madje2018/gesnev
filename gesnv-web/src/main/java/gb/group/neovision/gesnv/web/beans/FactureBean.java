/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.web.beans;

import gb.group.neovision.exceptions.BusinessExceptions;
import gb.group.neovision.gesnv.entities.Facture;
import gb.group.neovision.gesnv.entities.Prestation;
import gb.group.neovision.gesnv.service.PrestationServiceBeanRemote;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Messages;
import gb.group.neovision.gesnv.service.FactureServiceBeanRemote;

/**
 *
 * @author attia
 */
@ManagedBean
@ViewScoped
public class FactureBean {
    
    @EJB
    private FactureServiceBeanRemote factureService;
    
    @EJB
    private PrestationServiceBeanRemote prestationService;
    
    private List<Facture> factures;
    
    private Facture facture;
    
    private Prestation prestation;
    
    private Long idFacture;

    public FactureBean() {
    }
    
    @PostConstruct
    public void initList(){
        this.factures = this.factureService.lister();
    }
    
    public void initFacture(){
        if(this.idFacture!= null){
            this.facture = this.factureService.trouver(idFacture);
        }else{
            this.facture = new Facture();
        }
    }
    
    public String enregistrer(){
      try{
        if(this.idFacture==null){
        this.factureService.ajouter(this.facture);
        Messages.addGlobalInfo("Devis ajouté avec succès");
        }else{
            this.factureService.modifier(this.facture);
            Messages.addGlobalInfo("Devis modifié avec succès");
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

    
    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }
       
    
}
