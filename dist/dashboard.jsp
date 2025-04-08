<%@ page import="modele.*" %>
<%@ page import="java.util.Vector" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h3>Dashboard :</h3>
    <table cellpadding="10px">
        <tr>
            <td>Libelle du credit</td>
            <td>Montant credit</td>
            <td>Montant depense</td>
            <td>Reste</td>
        </tr>
        <% Vector<Depense> depenses = (Vector<Depense>) request.getAttribute("depenses"); %>
            <% for (Depense depense : depenses) { %>
                <tr>
                    <td><%= (depense.getCredit()).getNom() %></td>
                    <td><%= (depense.getCredit()).getMontant() %></td>
                    <td><%= depense.getDepense() %></td>
                </tr>
            <% } %>
    </table>
</body>
</html>