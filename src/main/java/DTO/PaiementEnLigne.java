package DTO;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class PaiementEnLigne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double montant;

    @Temporal(TemporalType.DATE)
    private Date datePaiement;


    
    @OneToOne
    @JoinColumn(name= "ID_RECU")
    private Recu recu;
    
    @OneToOne
    @JoinColumn(name= "ID_FACTURE")
    private Facture factures;

    public PaiementEnLigne() {
        // Default no-argument constructor
    }

    public PaiementEnLigne(double montant, Date datePaiement) {
        this.montant = montant;
        this.datePaiement = datePaiement;
    }

    // Getters and Setters

    // Other methods
    public void effectuerPaiement() {
        // Add logic to process online payment here
    }

    @Override
    public String toString() {
        return "PaiementEnLigne{" +
                "id=" + id +
                ", montant=" + montant +
                ", datePaiement=" + datePaiement +
                '}';
    }
}
