package classes;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @ManyToOne
    private Client client;

//    @ManyToOne
//    @JoinColumn (name="ID")
//    private Voiture voiture;
//    
//    @OneToOne
//    @JoinColumn(name="ID")
//    private Facture facture;
    
//    @ManyToOne
//    @JoinColumn(name = "ID_PERSONNELAGENCE") // This creates a foreign key column in the Reservation table
//    private PersonnelAgence personnelAgence;

    public Reservation() {
        // Default no-argument constructor
    }

    public Reservation(Date dateDebut, Date dateFin, Client client, Voiture voiture) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
//        this.client = client;
//        this.voiture = voiture;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }
//
//    public Voiture getVoiture() {
//        return voiture;
//    }
//
//    public void setVoiture(Voiture voiture) {
//        this.voiture = voiture;
//    }

    // Other methods
    public double calculerCoûtTotal() {
        // Add your logic to calculate the total cost of the reservation here
        return 0.0; // Replace with the actual calculation
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
//                ", client=" + client +
//                ", voiture=" + voiture +
                '}';
    }
    

}
