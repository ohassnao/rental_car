package DAO;

import java.util.List;

import DTO.PaiementEnLigne;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PaiementEnLigneDAO {

    private EntityManagerFactory entityManagerFactory;

    public PaiementEnLigneDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("milind");
    }

    public void addPaiementEnLigne(PaiementEnLigne paiementEnLigne) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(paiementEnLigne);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public PaiementEnLigne getPaiementEnLigneById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        PaiementEnLigne paiementEnLigne = entityManager.find(PaiementEnLigne.class, id);
        entityManager.close();
        return paiementEnLigne;
    }

    public List<PaiementEnLigne> getAllPaiementsEnLigne() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<PaiementEnLigne> paiementsEnLigne = entityManager.createQuery("SELECT p FROM PaiementEnLigne p", PaiementEnLigne.class).getResultList();
        entityManager.close();
        return paiementsEnLigne;
    }

    public void updatePaiementEnLigne(PaiementEnLigne paiementEnLigne) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(paiementEnLigne);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deletePaiementEnLigne(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        PaiementEnLigne paiementEnLigne = entityManager.find(PaiementEnLigne.class, id);
        if (paiementEnLigne != null) {
            entityManager.remove(paiementEnLigne);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void close() {
        entityManagerFactory.close();
    }
}
