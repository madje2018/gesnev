/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.web.beans;

import gb.group.neovision.exceptions.BusinessExceptions;
import gb.group.neovision.gesnv.entities.Taxe;
import gb.group.neovision.gesnv.service.TaxeServiceBeanRemote;
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
public class TaxeBean {
    
    @EJB
    private TaxeServiceBeanRemote taxeService;
    
    private List<Taxe> taxes;
    
    private Taxe taxe;
    
    private String idTaxe;
    

    public TaxeBean() {
    }
    
    @PostConstruct
    public void initList(){
        this.taxes  = this.taxeService.lister();
    }
    
    public void initTaxe(){
        if(this.idTaxe!=null){
            this.taxe = this.taxeService.trouver(this.idTaxe);
        }else{
            this.taxe = new Taxe();
        }
    }
    
    public String enregistrer(){       
        try{
        if(this.idTaxe==null){
        this.taxeService.ajouter(this.taxe);
        Messages.addGlobalInfo("Taxe ajouté avec succès");
        }else{
            this.taxeService.modifier(this.taxe);
            Messages.addGlobalInfo("Taxe modifié avec succès");
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
    
    public String supprimer(Taxe t){
        try{
           this.taxeService.supprime(t);
           Messages.addGlobalInfo("Opération effectuée avec succes");
        }catch (BusinessExceptions e){
            Messages.addGlobalError(e.getMessage());
        }
        catch (Exception e){
            Messages.addGlobalError("erreur inconnu");
        }
      return "list?faces-redirect=true";  
    }

    public List<Taxe> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Taxe> taxes) {
        this.taxes = taxes;
    }

    public Taxe getTaxe() {
        return taxe;
    }

    public void setTaxe(Taxe taxe) {
        this.taxe = taxe;
    }

    public String getIdTaxe() {
        return idTaxe;
    }

    public void setIdTaxe(String idTaxe) {
        this.idTaxe = idTaxe;
    }
    
    
    
}
