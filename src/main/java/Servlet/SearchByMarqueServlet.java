package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DTO.Voiture;
import service.VoitureService;

@WebServlet("/SearchByMarqueServlet")
public class SearchByMarqueServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String marque = request.getParameter("marque");
        
        VoitureService voitureService = new VoitureService(); // Assuming this is your service class
        List<Voiture> voiture = voitureService.getVoitureByMarque(marque);
        
        // Perform further processing or pass the voiture object to a JSP page for display
        // For example:
        if (voiture != null) {
            request.setAttribute("voiture", voiture);
            RequestDispatcher dispatcher = request.getRequestDispatcher("detail.jsp");
            dispatcher.forward(request, response);
        } else {
            // Handle case where no voiture is found for the given marque
            response.getWriter().println("No car found for the provided brand.");
        }
    }
}