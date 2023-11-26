package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.PersonnelAgence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

@WebServlet("/LoginAdmin")
public class LoginAdmin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        super.init();
        emf = Persistence.createEntityManagerFactory("milind");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        EntityManager em = emf.createEntityManager();

        try {
            Query query = em.createQuery("FROM PersonnelAgence WHERE username = :username", PersonnelAgence.class)
                    .setParameter("username", username);

            PersonnelAgence admin = (PersonnelAgence) query.getSingleResult();

            if (admin != null && admin.getMotdepasse().equals(password)) {
                String nom = admin.getNom();
                request.setAttribute("nom", nom);
                request.getRequestDispatcher("ADMIN.jsp").forward(request, response);
            } else {
                response.getWriter().write("Login failed. Please check your username and password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Login failed. An error occurred.");
        } finally {
            em.close();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        emf.close();
    }
}
