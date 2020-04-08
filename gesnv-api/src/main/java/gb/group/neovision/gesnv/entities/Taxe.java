/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author attia
 */
@Entity
@Table(name = "taxes")
public class Taxe implements Serializable{
    
    @Id
    @Column(name = "code", nullable = false)
    private String code;
    
    @Column(name = "taux", nullable = false)
    private double taux;
    

    public Taxe() {
    }

    public Taxe(String code, double taux) {
        this.code = code;
        this.taux = taux;
    }   

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.code);
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
        final Taxe other = (Taxe) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Taxe{" + "code=" + code + ", taux=" + taux + '}';
    }
       
}
