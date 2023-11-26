package service;

import java.util.List;
import DAO.ClientDAO;
import DTO.Client;

public class ClientService {
    
    // Save client
    public Client saveClient(Client client) {
        ClientDAO clientDao = new ClientDAO();
        return clientDao.saveClient(client);
    }
    
    // Update client
    public Client updateClient(Client client) {
        ClientDAO clientDao = new ClientDAO();
        return clientDao.updateClient(client);
    }
    
    // Get client by ID
    public Client getClientById(int id) {
        ClientDAO clientDao = new ClientDAO();
        return clientDao.getClientById(id);
    }
    
    // Get all clients
    public List<Client> getAllClients() {
        ClientDAO clientDao = new ClientDAO();
        return clientDao.getAllClients();
    }
    
    // Delete client
    public Client deleteClient(int id) {
        ClientDAO clientDao = new ClientDAO();
        return clientDao.deleteClient(id);
    }
}
