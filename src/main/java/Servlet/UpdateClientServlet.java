package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Client;
import service.ClientService;

// Import statements...

@WebServlet("/UpdateClientServlet")
public class UpdateClientServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // Get the client details from the request parameters
	    int clientId = Integer.parseInt(request.getParameter("clientId"));
	    String nom = request.getParameter("nom");
	    String prenom = request.getParameter("prenom");
	    String username = request.getParameter("username");
	    String email = request.getParameter("email");
	    String adresse = request.getParameter("adresse");
	    String password = request.getParameter("password");
	    
	    // Check if the email is not null and not empty before updating the client
	    if (email != null && !email.isEmpty()) {
	        // Initialize the ClientService
	        ClientService clientService = new ClientService();

	        // Get the client by ID
	        Client client = clientService.getClientById(clientId);

	        if (client != null) {
	            // Update the client details
	            client.setNom(nom);
	            client.setPrenom(prenom);
	            client.setUsername(username);
	            client.setEmail(email);
	            client.setAdresse(adresse);
	            client.setMotdepasse(password);

	            // Update the client in the database
	            clientService.updateClient(client);

	            // Redirect to the client list page
	            response.sendRedirect("ClientAdmin.jsp");
	            return;
	        }
	    }

	    // Handle cases where email is empty or null
	    response.getWriter().write("Email is empty or null. Cannot update client.");
	}

}