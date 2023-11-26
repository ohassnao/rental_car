package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ReservationDAO;

@WebServlet("/DeleteResAdminServlet")
public class DeleteResAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve the reservation ID from the request parameter
            int reservationId = Integer.parseInt(request.getParameter("reservationId"));
            
            // Pass the reservation ID to the DAO for deletion
            ReservationDAO reservationDAO = new ReservationDAO();
            reservationDAO.deleteReservation(reservationId);
            
            // Redirect to a success page or display a success message
            response.sendRedirect("reservationAdmin.jsp");
        } catch (NumberFormatException e) {
            // Handle invalid ID format or missing parameter
            response.sendRedirect("error.jsp");
        }
    }
}
