package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import classes.Client; // Replace "Client" with your entity class for clients

@WebServlet("/Login")
public class ClientLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Create a Hibernate SessionFactory
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();

        // Create a Hibernate session
        Session session = factory.openSession();

        // Begin a transaction
        Transaction tx = session.beginTransaction();

        try {
            // Fetch the client by username from the database
            Client client = (Client) session.createQuery("FROM Client WHERE username = :username")
                .setParameter("username", username)
                .uniqueResult();

            if (client != null && client.getMotdepasse().equals(password)) {
                // Successful login
                response.getWriter().write("Login successful! Welcome, " + client.getNom());
            } else {
                // Failed login
                response.getWriter().write("Login failed. Please check your username and password.");
            }

            // Commit the transaction
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            response.getWriter().write("Login failed. An error occurred: " + e.getMessage());
        } finally {
            // Close the Hibernate session and factory
            session.close();
            factory.close();
        }
    }
}
