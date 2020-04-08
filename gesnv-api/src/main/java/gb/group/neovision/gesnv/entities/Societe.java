/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author attia
 */
@Entity
@DiscriminatorValue("S")
public class Societe extends Client{
    
    @Column(name = "raison_sociale",nullable = true, length = 255)
    private String raisonSociale;
    
    @Column(name = "nif",nullable = true, length = 20)
    private String nif;

    public Societe() {
    }
    
    public Societe(String raisonSociale, String nif, String contact, String adresse, String ville){
        super(contact, adresse, ville);
        this.raisonSociale = raisonSociale;
        this.nif = nif;
    }
    

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }
    
    
    
}
