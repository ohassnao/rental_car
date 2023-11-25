package DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "voiture")
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_VOITURE;
    
    @Column(name="Marque")
    private String marque;
    
    @Column(name="Modele")
    private String modele;
    
    @Column(name="Annee")
    private int annee;
    
    @Column(name="Disponibilite")
    private boolean disponibilite;
    
    @Column(name="prix_jour")
    private float prix_jour;
     
    public Long getID_VOITURE() {
		return ID_VOITURE;
	}

	public void setID_VOITURE(Long iD_VOITURE) {
		ID_VOITURE = iD_VOITURE;
	}

	public float getPrix_jour() {
		return prix_jour;
	}

	public void setPrix_jour(float prix_jour) {
		this.prix_jour = prix_jour;
	}

	public Voiture() {
        // Default no-argument constructor
    }

    public Voiture(String marque, String modele, int annee, boolean disponibilite, float prix_jour) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.disponibilite = disponibilite;
        this.prix_jour = prix_jour;
    }

    // Getters and Setters
    public Long getId() {
        return ID_VOITURE;
    }

    public void setId(Long id) {
        this.ID_VOITURE = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    // Other methods
    @Override
    public String toString() {
        return "Voiture{" +
                "id=" + ID_VOITURE +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", annee=" + annee +
                ", disponibilite=" + disponibilite +
                '}';
    }
}
