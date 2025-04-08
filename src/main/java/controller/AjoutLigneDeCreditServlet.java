package controller;

import java.io.IOException;
import java.util.Vector;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import modele.*;
import dao.*;

public class AjoutLigneDeCreditServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String nom = req.getParameter("nom");
        double montant = Double.parseDouble(req.getParameter("montant"));
        LigneDeCredit ligneDeCredit = new LigneDeCredit(nom, montant);
        
        try {
            LigneDeCreditDAO ligneDeCreditDAO = new LigneDeCreditDAO();
            ligneDeCreditDAO.ajouterligneDeCredit(ligneDeCredit);
            Vector<LigneDeCredit> ligneDeCredits = ligneDeCreditDAO.getAll();
            req.setAttribute("ligneDeCredits", ligneDeCredits);

        } catch (Exception e) {
            // TODO: handle exception
        }

        req.getRequestDispatcher("liste-ligneDeCredit.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LigneDeCreditDAO ligneDeCreditDAO = new LigneDeCreditDAO();
        Vector<LigneDeCredit> ligneDeCredits;
        try {
            ligneDeCredits = ligneDeCreditDAO.getAll();
            req.setAttribute("ligneDeCredits", ligneDeCredits);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        req.getRequestDispatcher("ajouter-depense-form.jsp").forward(req, resp);
        
    }
    
}
