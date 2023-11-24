package VoitureDAO;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import sessionUtil.Sessionfactory; // Import your SessionFactory class
@WebServlet("/dropdown")
public class FetchMarqueServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = Sessionfactory.getSession(); // Get the Hibernate session using your SessionFactory class

        MarqueDAO marqueDAO = new MarqueDAO(session);
        List<String> marqueList = marqueDAO.fetchMarqueData();
        
        for (String marque : marqueList) {
            System.out.println(marque);
        }

        request.setAttribute("marqueList", marqueList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
        session.close(); // Close the Hibernate session when done
    }
}
