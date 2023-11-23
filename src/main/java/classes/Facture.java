package classes;

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
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double montant;

    @Temporal(TemporalType.DATE)
    private Date dateFacturation;


    @OneToOne
    @JoinColumn(name="ID_RESERVATION")
    private Reservation reservation;

    public Facture() {
        // Default no-argument constructor
    }

    public Facture(double montant, Date dateFacturation, Client client, Reservation reservation) {
        this.montant = montant;
        this.dateFacturation = dateFacturation;
        this.reservation = reservation;
    }

    // Getters and Setters

    // Other methods
    public void genererFacturePDF() {
        // Add logic to generate a PDF invoice here
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", montant=" + montant +
                ", dateFacturation=" + dateFacturation +
                ", reservation=" + reservation +
                '}';
    }
}
