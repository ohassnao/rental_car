package service;

import java.util.List;

import DAO.ReservationDAO;
import DTO.Reservation;

public class reservationService {
	
//	save reservation
	public Reservation saveReservation(Reservation res) {
		ReservationDAO teacherDao = new ReservationDAO();
		return teacherDao.saveReservation(res);
	}
	
//	update reservation
	public Reservation updateReservation(Reservation res) {
		ReservationDAO resDao = new ReservationDAO();
		return resDao.updateReservation(res);
	}
	
//	get reservation by id
	public Reservation getReservationById(int id) {
		ReservationDAO resDao = new ReservationDAO();
		return resDao.getReservationById(id);
	}
	
//	get all reservation
	public List<Reservation> getAllReservation() {
		ReservationDAO resDao = new ReservationDAO();
		return resDao.getAllReservations();
	}
	
// Get reservations for a specific client
	public List<Reservation> getReservationsForClient(int clientId) {
		ReservationDAO resDao = new ReservationDAO();
		return resDao.getReservationsForClient( clientId);
	}
	
//	delete Reseravation
	public Reservation deleteReservation(int id) {
		ReservationDAO ReservationDao = new ReservationDAO();
		return 	ReservationDao.deleteReservation(id);
	}
}