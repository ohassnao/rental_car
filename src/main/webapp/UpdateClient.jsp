<%@ page import="java.util.List" %>
<%@ page import="service.ClientService" %>
<%@ page import="DTO.Client" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Client</title>
</head>
<body>
    <h2>Update Client</h2>

    <%
        // Get the client ID from the request parameter
        int clientId = Integer.parseInt(request.getParameter("clientId"));
		System.out.println(clientId);
        // Initialize the ClientService
        ClientService clientService = new ClientService();

        // Get the client by ID
        Client client = clientService.getClientById(clientId);

        if (client != null) {
            // Display client details
    %>
            <form action="UpdateClientServlet" method="post">
                <input type="hidden" name="clientId" value="<%= client.getId() %>">
                <label for="nom">Nom:</label>
                <input type="text" id="nom" name="nom" value="<%= client.getNom() %>"><br>

                <label for="prenom">Prenom:</label>
                <input type="text" id="prenom" name="prenom" value="<%= client.getPrenom() %>"><br>

                <label for="username">Username:</label>
                <input type="text" id="username" name="username" value="<%= client.getUsername() %>"><br>
                <label for="username">Password</label>
                <input type="text" id="password" name="password" value="<%= client.getMotdepasse()%>"><br>

                <label for="email">Email:</label>
                <input type="text" id="email" name="email" value="<%= client.getEmail() %>"><br>
                <label for="email">Adresse:</label>
                <input type="text" id="adresse" name="adresse" value="<%= client.getAdresse() %>"><br>

                <input type="submit" value="Update">
            </form>

            <p><a href="ClientAdmin.jsp">Cancel</a></p>
    <%
        } else {
            // Client not found
    %>
            <p>Client not found.</p>
            <p><a href="ClientAdmin.jsp">Back to Client List</a></p>
    <%
        }
    %>
</body>
</html>