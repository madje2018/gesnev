/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author attia
 */
@Entity
@Table(name = "prestations_services")
public class PrestationService implements Serializable{
    
   @EmbeddedId
   private IdPrestationService id;
   
   @Column(name = "quantite", nullable = false)
   private int quantite;
   
   @Column(name = "remise", nullable = true)
   private double remise;  
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_prestation", nullable = false, insertable = false, updatable = false)
   private Prestation prestation;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_service", nullable = false, insertable = false, updatable = false)
   private Service service;

   public PrestationService() {
       this.id = new IdPrestationService();
    }

   public PrestationService(Prestation prestation, Service service) {
        this.prestation = prestation;
        this.service = service;
    }

    public PrestationService(int quantite, double remise, Prestation prestation, Service service) {
        this();
        this.quantite = quantite;
        this.remise = remise;
        this.prestation = prestation;
        this.service = service;
        this.id.setIdPrestation(this.prestation.getId());
        this.id.setIdService(this.service.getId());
    }
    

   public double getMontant(){
       return service.getPrixUnitaire()*quantite-remise;
   }   

   public IdPrestationService getId() {
        return id;
    }

   public void setId(IdPrestationService id) {
        this.id = id;
    }

   public double getRemise() {
        return remise;
    }

   public void setRemise(double remise) {
        this.remise = remise;
    }

   public int getQuantite() {
        return quantite;
    }

   public void setQuantite(int quantite) {
        this.quantite = quantite;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PrestationService other = (PrestationService) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PrestationService{" + "id=" + id + ", quantite=" + quantite + ", remise=" + remise + '}';
    }

    
   
   
    
}
