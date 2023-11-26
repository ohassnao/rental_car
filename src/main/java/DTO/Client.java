package DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_CLIENT;
    
    @Column(name = "NOM", length=100)
    private String nom;
    
    @Column(name = "PRENOM", length=100)
    private String prenom;
    
    @Column(name = "USERNAME", length=100 )
    private String username;
    	
    @Column(name = "PASSWORD", length=100 )
    private String motdepasse;
    
    @Column(name = "ADRESSE", length=100 )
    private String adresse;
    
    @Column(name = "ADRESSMAIL", length=100 )
    private String email;
    
    

 
    


    public Client() {
        // Default no-argument constructor
    }

    

    
    public Client(String nom, String prenom, String adresse, String email, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
    }

    // Getters and Setters
    public Integer getId() {
        return ID_CLIENT;
    }

    public void setId(Integer id) {
        this.ID_CLIENT = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    // Other methods
    @Override
    public String toString() {
        return "Client{" +
                "ID_CLIENT=" + ID_CLIENT +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", username'" + username + '\'' +
                ", motdepasse='" + motdepasse + '\'' +
                '}';
    }
}
