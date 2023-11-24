package DTO;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
public class Recu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double montantPaye;

    @Temporal(TemporalType.DATE)
    private Date datePaiement;

    @ManyToOne
    private Reservation reservation;
    
    @OneToOne
    @JoinColumn(name= "ID")
    private PaiementEnLigne paiement;

    public Recu() {
        // Default no-argument constructor
    }

    public Recu(double montantPaye, Date datePaiement, Reservation reservation) {
        this.montantPaye = montantPaye;
        this.datePaiement = datePaiement;
        this.reservation = reservation;
    }

    // Getters and Setters

    // Other methods
    public void genererReçuPDF() {
        // Add logic to generate a PDF receipt here
    }

    @Override
    public String toString() {
        return "Recu{" +
                "id=" + id +
                ", montantPaye=" + montantPaye +
                ", datePaiement=" + datePaiement +
                ", reservation=" + reservation +
                '}';
    }
}
