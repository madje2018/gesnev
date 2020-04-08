/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author attia
 */
@Embeddable
public class IdPrestationService implements Serializable{
    
    @Column(name = "id_prestation", nullable = false)
    private Long idPrestation;
    
    @Column(name = "id_service", nullable = false)
    private Long idService;

    public IdPrestationService() {
    }

    public IdPrestationService(Long idPrestation, Long idService) {
        this.idPrestation = idPrestation;
        this.idService = idService;
    }

    public Long getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(Long idPrestation) {
        this.idPrestation = idPrestation;
    }

    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.idPrestation);
        hash = 29 * hash + Objects.hashCode(this.idService);
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
        final IdPrestationService other = (IdPrestationService) obj;
        if (!Objects.equals(this.idPrestation, other.idPrestation)) {
            return false;
        }
        if (!Objects.equals(this.idService, other.idService)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IdPrestationService{" + "idPrestation=" + idPrestation + ", idService=" + idService + '}';
    }

    

    
    
    
    
}
