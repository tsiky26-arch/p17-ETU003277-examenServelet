<%@ page import="modele.*" %>
    <%@ page import="java.util.Vector" %>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Title</title>
        </head>

        <body>
            <h1>Liste ligne credit</h1>
                <% Vector<LigneDeCredit> ligneDeCredits = (Vector<LigneDeCredit>) request.getAttribute("ligneDeCredits"); %>
                        <ul>
                            <% for (LigneDeCredit credit : ligneDeCredits) { %>
                                <li>
                                    <%= credit.getNom() %> : <%= credit.getMontant() %> 
                                    <a href="">Supprimer</a>  
                                    <a href="">Modifier</a>
                                </li>
                                <% } %>
                        </ul>
                        <a href="ajouter-credit">Ajouter une depense</a>
                        <br>
                        <a href="ajouter-credit">Ajout une nouvelle ligne de credit</a>
        </body>

        </html>