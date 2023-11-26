package service;

import DAO.PaiementEnLigneDAO;
import DTO.PaiementEnLigne;

import java.util.List;

public class PaiementEnLigneService {

    private final PaiementEnLigneDAO paiementEnLigneDAO;

    public PaiementEnLigneService() {
        this.paiementEnLigneDAO = new PaiementEnLigneDAO();
    }

    public void addPaiementEnLigne(PaiementEnLigne paiementEnLigne) {
        paiementEnLigneDAO.addPaiementEnLigne(paiementEnLigne);
    }

    public PaiementEnLigne getPaiementEnLigneById(Long id) {
        return paiementEnLigneDAO.getPaiementEnLigneById(id);
    }

    public List<PaiementEnLigne> getAllPaiementsEnLigne() {
        return paiementEnLigneDAO.getAllPaiementsEnLigne();
    }

    public void updatePaiementEnLigne(PaiementEnLigne paiementEnLigne) {
        paiementEnLigneDAO.updatePaiementEnLigne(paiementEnLigne);
    }

    public void deletePaiementEnLigne(Long id) {
        paiementEnLigneDAO.deletePaiementEnLigne(id);
    }

    public void close() {
        paiementEnLigneDAO.close();
    }
}
