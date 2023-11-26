package DAO;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import DTO.Voiture; 

 public class VoitureDao {
	 
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("milind");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		
//		save voiture
		public Voiture saveVoiture(Voiture voiture) {
			voiture.setMarque(voiture.getMarque());
			voiture.setModele(voiture.getModele());
			voiture.setAnnee(voiture.getAnnee());
			voiture.setDisponibilite(voiture.isDisponibilite());
			entityTransaction.begin();
			entityManager.persist(voiture);
			entityTransaction.commit();
			return voiture;
		}

//		update voiture
		public Voiture updateVoiture(Voiture voiture) {
			Voiture voiture1 = entityManager.find(Voiture.class, voiture.getId());
			voiture1.setMarque(voiture1.getMarque());
			voiture1.setModele(voiture1.getModele());
			voiture1.setAnnee(voiture1.getAnnee());
			voiture1.setDisponibilite(voiture1.isDisponibilite());
			entityTransaction.begin();
			entityManager.merge(voiture1);
			entityTransaction.commit();
			return voiture1;
		}

//		get voiture by id
		public Voiture getVoitureById(int id) {
			Voiture voiture = entityManager.find(Voiture.class, id);
			return voiture;
		}
		
		public List<Voiture> getVoitureByMarque(String marque) {
		    String jpql = "SELECT v FROM Voiture v WHERE v.marque = :marque";
		    TypedQuery<Voiture> query = entityManager.createQuery(jpql, Voiture.class);
		    query.setParameter("marque", marque);

		    List<Voiture> voitures = null;
		    try {
		        voitures = query.getResultList();
		    } catch (NoResultException e) {
		        // Handle if no car is found for the given brand
		    }

		    return voitures;
		}


//		get all voiture
		public List<Voiture> getAllVoiture() {
			String sql = "SELECT voiture FROM Voiture voiture";
			Query query = entityManager.createQuery(sql);
			List<Voiture> voiture = query.getResultList();
			return voiture;
		}
		public List <Voiture> getAllMarque() {
			String sql2 = "Select marque FROM Voiture";
			Query query = entityManager.createQuery(sql2);
			List<Voiture> voiture2 = query.getResultList();
			return voiture2;
		}

//		delete voiture
		public Voiture deleteVoiture(int id) {
			Voiture voiture= entityManager.find(Voiture.class, id);
			entityTransaction.begin();
			entityManager.remove(voiture);
			entityTransaction.commit();
			return voiture;
		}
}
