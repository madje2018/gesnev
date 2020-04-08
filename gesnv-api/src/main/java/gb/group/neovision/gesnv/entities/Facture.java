/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author attia
 */
@Entity
@Table(name = "factures")
public class Facture implements Serializable{
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id", nullable = false)
   private Long id;
   
   @Column(name = "num_facture", nullable = false)
   private String numFacture;
    
   @Column(name = "date_facture", nullable = false)
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date dateFacture;
   
   @Column(name = "reference", nullable = true)
   protected String reference;
   
   @Column(name = "montant_totalHT", nullable = false)
   private double montantTotalHT;
   
   @Column(name = "remise_total", nullable = false)
   private double remiseTotale;
   
   @Column(name = "montant_totalTTC", nullable = false)
   private double montantTotalTTC;
   
   @Column(name = "acompte", nullable = true)
   private double acompte;
   
   @Column(name = "net_apayer", nullable = false)
   private double netApayer;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_prestation", nullable = false)
   private Prestation prestation;
   
   

    public Facture() {
    }

    public Facture(String reference, double montantTotalHT, double remiseTotale, double montantTotalTTC, double netApayer) {
        this.reference = reference;
        this.montantTotalHT = montantTotalHT;
        this.remiseTotale = remiseTotale;
        this.montantTotalTTC = montantTotalTTC;
        this.netApayer = netApayer;
    }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getMontantTotalHT() {
        return montantTotalHT;
    }

    public void setMontantTotalHT(double montantTotalHT) {
        this.montantTotalHT = montantTotalHT;
    }

    public double getRemiseTotale() {
        return remiseTotale;
    }

    public void setRemiseTotale(double remiseTotale) {
        this.remiseTotale = remiseTotale;
    }

    public double getMontantTotalTTC() {
        return montantTotalTTC;
    }

    public void setMontantTotalTTC(double montantTotalTTC) {
        this.montantTotalTTC = montantTotalTTC;
    }

    public double getAcompte() {
        return acompte;
    }

    public void setAcompte(double acompte) {
        this.acompte = acompte;
    }

    public double getNetApayer() {
        return netApayer;
    }

    public void setNetApayer(double netApayer) {
        this.netApayer = netApayer;
    }

    public Prestation getPrestation() {
        return prestation;
    }

    public void setPrestation(Prestation prestation) {
        this.prestation = prestation;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Facture other = (Facture) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Facture{" + "id=" + id + ", numFacture=" + numFacture + ", dateFacture=" + dateFacture + ", reference=" + reference + ", montantTotalHT=" + montantTotalHT + ", remiseTotale=" + remiseTotale + ", montantTotalTTC=" + montantTotalTTC + ", acompte=" + acompte + ", netApayer=" + netApayer + '}';
    }
 
}
