/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.web.utils;

import gb.group.neovision.gesnv.entities.Service;
import java.util.Objects;

/**
 *
 * @author attia
 */
public class ServiceChoisi {
    
    private Service service;
    private Integer quantite;
    private Double remise;
    
    public ServiceChoisi(){
        
    }

    public ServiceChoisi(Service service, Integer quantite, Double remise) {
        this.service = service;
        this.quantite = quantite;
        this.remise = remise;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Double getRemise() {
        return remise;
    }

    public void setRemise(Double remise) {
        this.remise = remise;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.service);
        hash = 23 * hash + Objects.hashCode(this.quantite);
        hash = 23 * hash + Objects.hashCode(this.remise);
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
        final ServiceChoisi other = (ServiceChoisi) obj;
        if (!Objects.equals(this.service, other.service)) {
            return false;
        }
        if (!Objects.equals(this.quantite, other.quantite)) {
            return false;
        }
        if (!Objects.equals(this.remise, other.remise)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ServiceChoisi{" + "service=" + service + ", quantite=" + quantite + ", remise=" + remise + '}';
    }
    
    
    
}
