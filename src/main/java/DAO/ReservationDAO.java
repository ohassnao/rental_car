package DAO;
import java.sql.Date;

import java.util.List;

import DTO.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
public class ReservationDAO {
	
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("milind");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();

    // Sauvegarder la réservation
    public Reservation saveReservation(Reservation reservation) {
        reservation.setDateDebut(reservation.getDateDebut());
        reservation.setDateFin(reservation.getDateFin());
        reservation.setVoiture(reservation.getVoiture());
        reservation.setClient(reservation.getClient());
        reservation.setNbr_jour(reservation.getNbr_jour());
        entityTransaction.begin();
        entityManager.persist(reservation);
        entityTransaction.commit();
        
        return reservation;
    }

    // Mettre à jour la réservation
    public Reservation updateReservation(Reservation reservation) {
        Reservation existingReservation = entityManager.find(Reservation.class, reservation.getId());
        
        existingReservation.setDateDebut(reservation.getDateDebut());
        existingReservation.setDateFin(reservation.getDateFin());
        existingReservation.setNbr_jour(reservation.getNbr_jour());
        
        entityTransaction.begin();
        entityManager.merge(existingReservation);
        entityTransaction.commit();
        
        return existingReservation;
    }



	

    // Get reservation by ID
    public Reservation getReservationById(int id) {
        Reservation reservation = entityManager.find(Reservation.class, id);
        return reservation;
    }

 // Get all reservations
    public List<Reservation> getAllReservations() {
        String sql = "SELECT reservation FROM Reservation reservation";
        Query query = entityManager.createQuery(sql);
        List<Reservation> reservations = query.getResultList();
        return reservations;
	}
    // Get reservations for a specific client
    public static List<Reservation> getReservationsForClient(int clientId) {
        String sql = "SELECT reservation FROM Reservation reservation WHERE reservation.client.id = :clientId";
        Query query = entityManager.createQuery(sql);
        query.setParameter("clientId", clientId);
        List<Reservation> reservations = query.getResultList();
        return reservations;
    }


 // Delete reservation
    public Reservation deleteReservation(int id) {
        Reservation reservation = entityManager.find(Reservation.class, id);
        entityTransaction.begin();
        entityManager.remove(reservation);
        entityTransaction.commit();
        return reservation;
    }
}