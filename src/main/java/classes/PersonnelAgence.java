package classes;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "personnelagence")
public class PersonnelAgence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "NOM", length=100 , nullable= false)
    private String nom;
    
    @Column(name = "PRENOM", length=100 , nullable= false)
    private String prenom;
    
    @Column(name = "USERNAME", length=100 , nullable= false)
    private String username;
    	
    @Column(name = "PASSWORD", length=100 , nullable= false)
    private String motdepasse;
    
    @Column(name = "ADRESSE", length=100 , nullable= false)
    private String adresse;
    
    @Column(name = "ADRESSMAIL", length=100 , nullable= false)
    private String email;
    
    
//    @OneToOne
//    @JoinColumn(name ="ID")
//    private Compte comptes;
//    
//    @OneToMany(cascade=CascadeType.PERSIST)
//    @JoinColumn(name="ID_client")
//    private List<Client> clients;
//    
//    @OneToMany(mappedBy = "personnelagence")
//    private List<Reservation> reservations;

    public PersonnelAgence() {
        // Default no-argument constructor
    }

    public PersonnelAgence(String nom, String prenom, String adresse, String email, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // Other methods
    @Override
    public String toString() {
        return "PersonnelAgence{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
