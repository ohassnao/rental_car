package DTO;
import java.sql.Date;

import jakarta.persistence.*;
import jakarta.persistence.Entity;


@Entity
@Table(name = "reservation")
public class Reservation  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID_CLIENT")
    private Client client;
    
    @OneToOne
    @JoinColumn(name = "ID_VOITURE", referencedColumnName = "ID_VOITURE")
    private Voiture voitures;



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
