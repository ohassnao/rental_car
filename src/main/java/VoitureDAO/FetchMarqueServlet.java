package VoitureDAO;

import VoitureDAO.MarqueDAO;
import session.Sessionfactory; // Import your SessionFactory class
import org.hibernate.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FetchMarqueServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = Sessionfactory.getSession(); // Get the Hibernate session using your SessionFactory class

        MarqueDAO marqueDAO = new MarqueDAO(session);
        List<String> marqueList = marqueDAO.fetchMarqueData();

        request.setAttribute("marqueList", marqueList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
        session.close(); // Close the Hibernate session when done
    }
}
