/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.web.beans;

import gb.group.neovision.exceptions.BusinessExceptions;
import gb.group.neovision.gesnv.entities.Client;
import gb.group.neovision.gesnv.entities.Prestation;
import gb.group.neovision.gesnv.entities.PrestationService;
import gb.group.neovision.gesnv.entities.Service;
import gb.group.neovision.gesnv.entities.Taxe;
import gb.group.neovision.gesnv.service.ClientServiceBeanRemote;
import gb.group.neovision.gesnv.service.PrestationServiceBeanRemote;
import gb.group.neovision.gesnv.service.ServServiceBeanRemote;
import gb.group.neovision.gesnv.service.TaxeServiceBeanRemote;
import gb.group.neovision.gesnv.web.utils.ServiceChoisi;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.omnifaces.util.Messages;

/**
 *
 * @author attia
 */
@ManagedBean
@ViewScoped
public class PrestationBean {
    
    @EJB
    private PrestationServiceBeanRemote prestationService;
    
    @EJB
    private ServServiceBeanRemote serviceService;
    
    @EJB
    private ClientServiceBeanRemote clientService;
    
    @EJB
    private TaxeServiceBeanRemote taxeService;
    
    private List<Prestation> prestations;
    
    private List<Service> services; 
    
    private List<Client> clients;
    
    private List<Taxe> taxes;
    
    private List<ServiceChoisi> servicesChoisis;
    
    private Prestation prestation;
    
    private Service service;
    
    private Client client; 
    
    private Taxe taxe;
    
    private ServiceChoisi serviceChoisi;
    
    private Long idPrestation;
    
    private Integer qte;
    
    private double remise;
    
    private double totalHT;
       

    public PrestationBean() {
    }
    
    
    @PostConstruct
    public void initList(){       
        this.prestations = this.prestationService.lister();  
        
        servicesChoisis = new ArrayList<>();
    }
    
    public void initPrestation(){
        if (this.idPrestation != null){
            this.prestation = this.prestationService.trouver(idPrestation);
        }else{
            this.prestation = new Prestation();
        }
        this.services = this.serviceService.lister(); 
        this.clients = this.clientService.lister();
        this.taxes = this.taxeService.lister();
    }
    
    public String enregistrer(){ 
        
        List<PrestationService> prestsServices = new ArrayList<>();
               
        try{
          if(this.idPrestation==null) { 
              
            this.prestation = this.prestationService.addwithflush(prestation);
            
            for(ServiceChoisi sc : this.servicesChoisis){
            PrestationService prestServ = new PrestationService(sc.getQuantite(), sc.getRemise(), this.prestation, sc.getService());
            
            prestServ.setPrestation(prestation);
            
            prestServ.getId().setIdPrestation(prestation.getId());
            
            prestsServices.add(prestServ);
            } 
            
            prestation.setPrestationServices(prestsServices);
            
            this.prestationService.modifier(prestation);
            
            this.idPrestation = this.prestation.getId();
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("la prestation a été enregistrer avec succes"));
          }else {
              this.prestationService.modifier(prestation);
          }
       }catch (BusinessExceptions e){
           Messages.addGlobalError(e.getMessage());
           e.printStackTrace();
       }catch(Exception e){
           Messages.addGlobalError("echec");
           e.printStackTrace();
       }
        return "list?faces-redirect=true";
    }
    
    public String supprimer(Prestation p){
        try{
         this.prestationService.supprimer(p);
         Messages.addGlobalInfo("Opération effectuée avec succes");
        }catch (BusinessExceptions e){
            Messages.addGlobalError(e.getMessage());
        } catch (Exception e){
           Messages.addGlobalError("Erreur inconnu"); 
        }
        return "list?faces-redirect=true";
        
    }
    
    public void afficherPrix(){
        this.serviceService.getPrixUnitaire(service);
    }
     
    public void afficherTaux(){
       this.taxeService.getTaux(taxe);
    }
    
    public void afficherTotalHT(){
       
    }
    
    public void  listServicesChoisis(){       
        this.serviceChoisi = new ServiceChoisi(this.service, this.qte, this.remise);              
    }
        
            
    public List<Prestation> getPrestations() {
        return prestations;
    }

    public void setPrestations(List<Prestation> prestations) {
        this.prestations = prestations;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    } 

    public List<Taxe> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Taxe> taxes) {
        this.taxes = taxes;
    }   
    
    public List<ServiceChoisi> getServicesChoisis() {
        return servicesChoisis;
    }

    public void setServicesChoisis(List<ServiceChoisi> servicesChoisis) {
        this.servicesChoisis = servicesChoisis;
    }

    public Prestation getPrestation() {
        return prestation;
    }

    public void setPrestation(Prestation prestation) {
        this.prestation = prestation;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public Taxe getTaxe() {
        return taxe;
    }

    public void setTaxe(Taxe taxe) {
        this.taxe = taxe;
    }   
    
    public ServiceChoisi getServiceChoisi() {
        return serviceChoisi;
    }

    public void setServiceChoisi(ServiceChoisi serviceChoisi) {
        this.serviceChoisi = serviceChoisi;
    }

    public Long getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(Long idPrestation) {
        this.idPrestation = idPrestation;
    }   

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }   

    public double getTotalHT() {
        return totalHT;
    }

    public void setTotalHT(double totalHT) {
        this.totalHT = totalHT;
    }

      
}
