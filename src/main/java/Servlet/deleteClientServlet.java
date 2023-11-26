package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;

@WebServlet("/deleteClientServlet")
public class deleteClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve the reservation ID from the request parameter
            int clientId = Integer.parseInt(request.getParameter("clientId"));
            
            // Pass the reservation ID to the DAO for deletion
            ClientDAO clientDAO = new ClientDAO();
            clientDAO.deleteClient(clientId);
            
            // Redirect to a success page or display a success message
            response.sendRedirect("ClientAdmin.jsp");
        } catch (NumberFormatException e) {
            // Handle invalid ID format or missing parameter
            response.sendRedirect("error.jsp");
        }
    }
}