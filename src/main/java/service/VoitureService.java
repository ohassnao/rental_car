package service;

import java.util.List;

import DAO.VoitureDao;
import DTO.Voiture;

public class VoitureService {
	
//	save voiture
	public Voiture saveVoiture(Voiture voiture) {
		VoitureDao teacherDao = new VoitureDao();
		return teacherDao.saveVoiture(voiture);
	}
	
//	update voiture
	public Voiture updateVoiture(Voiture voiture) {
		VoitureDao voitureDao = new VoitureDao();
		return voitureDao.updateVoiture(voiture);
	}
	
//	get voiture by id
	public Voiture getVoitureById(int id) {
		VoitureDao voitureDao = new VoitureDao();
		return voitureDao.getVoitureById(id);
	}
	
//	get all voiture
	public List<Voiture> getAllVoiture() {
		VoitureDao voitureDao = new VoitureDao();
		return voitureDao.getAllVoiture();
	}
	

//	delete voiture
	public Voiture deleteVoiture(int id) {
		VoitureDao voitureDao = new VoitureDao();
		return voitureDao.deleteVoiture(id);
	}
}