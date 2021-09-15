package application.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.bean.Produit;
import application.bean.User;
import service.produit.imp.ProduitService;

/**
 * Servlet VoirModifierProduitServlet
 */
@WebServlet("/VoirModifierProduitServlet")
public class VoirModifierProduitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    final ProduitService      produitService   = ProduitService.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoirModifierProduitServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(final HttpServletRequest request,final  HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");

        Integer id = Integer.parseInt(idString);

        final Produit produit = produitService.findProduitById(id);
        request.setAttribute("Produit", produit);

        final HttpSession session = request.getSession();
        final User user = (User) session.getAttribute("User");

        if (user == null) {
            request.getRequestDispatcher("/jsp/connexion.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/jsp/modifierProduit.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException {
        // empty method
        doGet(request, response);
    }

}
