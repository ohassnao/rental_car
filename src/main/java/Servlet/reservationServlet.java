package Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.ParseException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
// ... (other imports)
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;
import DTO.*;

@WebServlet("/reservationServlet")
public class reservationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve form parameters
            int idClient = Integer.parseInt(request.getParameter("clientId"));
            String carMarque = request.getParameter("carmarque");
            String carModele = request.getParameter("carmodele");
            int idVoiture = Integer.parseInt(request.getParameter("idvoiture"));
            int nbr_jour = Integer.parseInt(request.getParameter("nbr_jour"));


            Voiture voiture = new Voiture();
            VoitureDao voituredao = new VoitureDao();
            voiture = voituredao.getVoitureById(idVoiture);
            
            Client client = new Client();
            ClientDAO clientdao = new ClientDAO();
            client = clientdao.getClientById(idClient);
            
            Reservation reservation = new Reservation();
            reservation.setVoiture(voiture);
            reservation.setNbr_jour(nbr_jour);
            reservation.setClient(client);

            // Save the reservation using ReservationDAO
            ReservationDAO reservationDAO = new ReservationDAO();
            reservationDAO.saveReservation(reservation);

            // Redirect or show success message as needed
            response.sendRedirect("reservation.jsp"); // Redirect to a success page
        } catch (Exception e) {
            e.printStackTrace();
            // Handle other exceptions or redirect to an error page
            response.sendRedirect("error.jsp");
        }
    }
}
