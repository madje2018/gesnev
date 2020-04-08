
package gb.group.neovision.gesnv.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author attia
 */
@Entity
@Table(name = "prestations")
public class Prestation implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "num_prestation", nullable = false)
    private String numPrestation;
    
    @Column(name = "reference", nullable = true)
    private String reference;
    
    @Column(name = "date", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date datePrestation;   
    
    @Column(name = "lib_main_Oeuvre", nullable = true)
    private String libmainOeuvre;
    
    @Column(name = "main_Oeuvre", nullable = true)
    private double mainOeuvre;   
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_taxe", nullable = true)
    private Taxe taxe;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "prestation", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<PrestationService> prestationServices ;

    public Prestation() {
        this.datePrestation = new Date();
        this.prestationServices = new ArrayList<>();
    }

    public Prestation(PrestationService prestationService) {
        this();    
        addprestationService(prestationService);
    }
    
    public  void addprestationService(PrestationService prestationService){
        this.prestationServices.add(prestationService);
    }
    
    public double getMontant(){
        double montant = 0;
        for(PrestationService service:prestationServices){
            montant += service.getMontant();
        }
        return montant;
    }
    
    public double getRemiseTotale(){
        double remis = 0;
        for(PrestationService service:prestationServices){
            remis += service.getRemise();
        }
        return remis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatePrestation() {
        return datePrestation;
    }

    public void setDatePrestation(Date datePrestation) {
        this.datePrestation = datePrestation;
    }    


    public double getMainOeuvre() {
        return mainOeuvre;
    }

    public void setMainOeuvre(double mainOeuvre) {
        this.mainOeuvre = mainOeuvre;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getNumPrestation() {
        return numPrestation;
    }

    public void setNumPrestation(String numPrestation) {
        this.numPrestation = numPrestation;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLibmainOeuvre() {
        return libmainOeuvre;
    }

    public void setLibmainOeuvre(String libmainOeuvre) {
        this.libmainOeuvre = libmainOeuvre;
    }  

    public Taxe getTaxe() {
        return taxe;
    }

    public void setTaxe(Taxe taxe) {
        this.taxe = taxe;
    }

    public List<PrestationService> getPrestationServices() {
        return prestationServices;
    }

    public void setPrestationServices(List<PrestationService> prestationServices) {
        this.prestationServices = prestationServices;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Prestation other = (Prestation) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prestation{" + "id=" + id + ", numPrestation=" + numPrestation + ", reference=" + reference + ", datePrestation=" + datePrestation + ", libmainOeuvre=" + libmainOeuvre + ", mainOeuvre=" + mainOeuvre + '}';
    }   
 
}
