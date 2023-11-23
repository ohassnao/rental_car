package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import classes.Client;

@WebServlet("/Register")
public class ClientRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve user input from the form
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String adresse = request.getParameter("adresse");

        // Create a Hibernate SessionFactory
        Configuration configuration = new Configuration().configure();
        SessionFactory factory = configuration.buildSessionFactory();

        // Create a Hibernate session
        Session session = factory.openSession();

        // Begin a transaction
        Transaction tx = session.beginTransaction();

        try {
        	// Check if the username already exists in the database
            String usernameQuery = "FROM Client WHERE username = :username";
            Client existingClient = session.createQuery(usernameQuery, Client.class)
                .setParameter("username", username)
                .uniqueResult();

            if (existingClient != null) {
                // Username already exists, display an error message
                out.println("Registration failed. Username already exists.");
            } else {
                // Create a new Client entity and set its properties
                Client client = new Client();
                client.setNom(nom);
                client.setPrenom(prenom);
                client.setEmail(email);
                client.setUsername(username);
                client.setMotdepasse(password);
                client.setAdresse(adresse);
                // Set other properties as needed

                // Save the client entity to the database
                session.save(client);

                // Commit the transaction
                tx.commit();

                response.sendRedirect("index.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            out.println("Registration failed. Error: " + e.getMessage());
        } finally {
            // Close the Hibernate session and factory
            session.close();
            factory.close();
        }
    }
}
