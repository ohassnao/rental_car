package ClientDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import DTO.Client; 

@WebServlet("/Login")
public class ClientLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private SessionFactory factory;

    @Override
    public void init() throws ServletException {
        super.init();
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        factory = configuration.buildSessionFactory();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            Client client = (Client) session.createQuery("FROM Client WHERE username = :username")
                    .setParameter("username", username)
                    .uniqueResult();

            if (client != null && client.getMotdepasse().equals(password)) {
                // Set the ID_CLIENT in the session upon successful login
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("ID_CLIENT", client.getId());
                httpSession.setAttribute("nom", client.getNom());
                httpSession.setAttribute("prenom", client.getPrenom());
                String nom = client.getNom();
                request.setAttribute("nom", nom);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                response.getWriter().write("Login failed. Please check your username and password.");
            }

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            response.getWriter().write("Login failed. An error occurred.");
        } finally {
            session.close();
        }
    }


    @Override
    public void destroy() {
        super.destroy();
        factory.close();
    }
}
