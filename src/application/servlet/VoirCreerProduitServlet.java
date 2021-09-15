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
 * Servlet VoirCreerProduitServlet
 */
@WebServlet("/VoirCreerProduitServlet")
public class VoirCreerProduitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoirCreerProduitServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        final HttpSession session = request.getSession();
        final User user = (User) session.getAttribute("User");
        
        final String messageCreerProduit = "";
        session.setAttribute("messageCreerProduit", messageCreerProduit);

        if (user == null) {
            request.getRequestDispatcher("/jsp/connexion.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/jsp/creerProduit.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(final HttpServletRequest request,final  HttpServletResponse response) throws ServletException, IOException {
        // empty method
        doGet(request, response);
    }

}
