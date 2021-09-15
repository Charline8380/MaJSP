package application.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.bean.User;

/**
 * Servlet VoirPanierServlet
 */
@WebServlet("/VoirPanierServlet")
public class VoirPanierServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Constructeur par defaut
     * 
     * @see HttpServlet#HttpServlet()
     */
    public VoirPanierServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        final User user = (User) session.getAttribute("User");
        

        if (user == null) {
            request.getRequestDispatcher("/jsp/connexion.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/jsp/panier.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        // empty method
        doGet(request, response);
    }

}
