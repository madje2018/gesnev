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
@DiscriminatorValue("P")
public class Particulier extends Client{
    
    @Column(name = "nom",nullable = true, length = 127)
    private String nom;
    
    @Column(name = "prenom",nullable = true, length = 255)
    private String prenom;
    
    @Column(name = "email",nullable = true, length = 255)
    private String email;

    public Particulier() {
    }
    
    public Particulier(String nom, String prenom, String email, String contact, String adresse, String ville){
        super(contact, adresse, ville);
        this.nom = nom;
        this.prenom = prenom; 
        this.email = email;
    }
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
