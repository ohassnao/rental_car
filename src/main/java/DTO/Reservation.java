package DTO;
import java.sql.Date;

import jakarta.persistence.*;
import jakarta.persistence.Entity;


@Entity
@Table(name = "reservation")
public class Reservation  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_RESERVATION;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @Column(name="nbr_jour")
    private int nbr_jour;
    
    @ManyToOne
    @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID_CLIENT")
    private Client client;
    
    @OneToOne
    @JoinColumn(name = "ID_VOITURE", referencedColumnName = "ID_VOITURE")
    private Voiture voiture;
    
    



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
    public int getId() {
        return ID_RESERVATION;
    }

    public void setId(int idClient) {
        this.ID_RESERVATION = idClient;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date startDate) {
        this.dateDebut = startDate;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date startdDate) {
        this.dateFin = startdDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    // Other methods
    public double calculerCoûtTotal() {
        // Add your logic to calculate the total cost of the reservation here
        return 0.0; // Replace with the actual calculation
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + ID_RESERVATION +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
//                ", client=" + client +
//                ", voiture=" + voiture +
                '}';
    }
    
    public void setNbr_jour(int nbr_jour) {
		this.nbr_jour = nbr_jour;
	}

	public int getNbr_jour() {
		return nbr_jour;
    }
    

}
