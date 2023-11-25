package DAO;

import java.util.List;


import DTO.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;


public class ClientDAO {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("milind");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();

    // Save client
    public Client saveClient(Client client) {
        entityTransaction.begin();
        entityManager.persist(client);
        entityTransaction.commit();
        return client;
    }

    // Update client
    public Client updateClient(Client client) {
        Client existingClient = entityManager.find(Client.class, client.getId());

        existingClient.setNom(client.getNom());
        existingClient.setPrenom(client.getPrenom());
        existingClient.setAdresse(client.getAdresse());
        existingClient.setEmail(client.getEmail());
        existingClient.setUsername(client.getUsername());
        existingClient.setMotdepasse(client.getMotdepasse());

        entityTransaction.begin();
        entityManager.merge(existingClient);
        entityTransaction.commit();
        return existingClient;
    }

    // Get client by ID
    public Client getClientById(int id) {
        Client client = entityManager.find(Client.class, id);
        return client;
    }

    // Get all clients
    public List<Client> getAllClients() {
        String sql = "SELECT client FROM Client client";
        Query query = entityManager.createQuery(sql);
        List<Client> clients = query.getResultList();
        return clients;
    }

    // Delete client
    public Client deleteClient(int id) {
        Client client = entityManager.find(Client.class, id);
        entityTransaction.begin();
        entityManager.remove(client);
        entityTransaction.commit();
        return client;
    }
}
