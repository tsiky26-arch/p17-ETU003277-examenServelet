package controller;

import java.io.IOException;
import java.util.Vector;

import dao.DepenseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Depense;

public class AjoutDepenseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idCredit = Integer.parseInt(req.getParameter("idCredit"));
        double montant = Double.parseDouble(req.getParameter("depense"));

        Depense depense = new Depense(idCredit, montant);
        DepenseDAO depenseDAO = new DepenseDAO();
        depenseDAO.ajouterDepense(depense);

        try {
            Vector<Depense> depenses = depenseDAO.getAll();
            req.setAttribute("depenses", depenses);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
    }
}
