package DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;



@Entity
@Table(name = "compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_COMPTE;
    
    @Column(name = "USERNAME", length=100 , nullable= false)
    private String username;
    	
    @Column(name = "PASSWORD", length=100 , nullable= false)
    private String motdepasse;
    
    @ManyToOne
    @JoinColumn(name="ID_CLIENT", nullable = false)
    private Client clients;

    public Compte() {
        // Default no-argument constructor
    }

    public Compte(String username, String motdepasse,Integer ID_COMPTE) {
        this.username = username;
        this.ID_COMPTE = ID_COMPTE;
        this.motdepasse = motdepasse;
    }

    public Client getclient() {
        return clients;
    }

    public void setClient(Client clients) {
        this.clients = clients;
    }
    
    public Integer getId_Compte() {
        return ID_COMPTE;
    }

    public void setID_COMPTE(Integer ID_COMPTE) {
        this.ID_COMPTE = ID_COMPTE;
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

    @Override
    public String toString() {
        return "Compte{" +
                ", ID_COMPTE='" + ID_COMPTE + '\'' +
                ", motdepasse='" + motdepasse + '\'' +
                '}';
    }
}

