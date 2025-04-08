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
    <h3>Ajouter une depense :</h3>
    <form action="ajouter-depense">
        Ligne de credit :
        <select name="idCredit" id="">
            <% Vector<LigneDeCredit> ligneDeCredits = (Vector<LigneDeCredit>) request.getAttribute("ligneDeCredits"); %>
                <% for (LigneDeCredit credit : ligneDeCredits) { %>
                    <option value="<%= credit.getId() %>"><%= credit.getNom() %></option>
                <% } %>
        </select>
        <p><input type="text" name="depense" placeholder="Entrer le montant"></p>
        <p><input type="submit" value="Ajouter"></p>
    </form>
</body>
</html>