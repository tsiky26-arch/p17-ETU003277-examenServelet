package controller;

import java.io.IOException;
// import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class AccueilServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        // PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String auth = (String) session.getAttribute("auth");

        if ("true".equals(auth)) {
            // out.println("<html><body>");
            // out.println("<p>Welcome, " + session.getAttribute("email") + "</p>");
            // out.println("</body></html>");
        } else {
            response.sendRedirect("index.jsp");
        }
        request.getRequestDispatcher("accueil.jsp").forward(request, response);
    }
}