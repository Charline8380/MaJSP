package application.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.bean.Panier;
import application.bean.Produit;
import application.bean.User;
import service.panier.imp.PanierService;
import service.produit.imp.ProduitService;

/**
 * Servlet implementation class AjouterPanierServlet
 */
@WebServlet("/BoutonAjouterPanierServlet")
public class BoutonAjouterPanierServlet extends HttpServlet {
    final PanierService panierService = PanierService.getInstance();
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoutonAjouterPanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        final User user = (User) session.getAttribute("User");

        Panier panier = (Panier) session.getAttribute("Panier");
        String idString = request.getParameter("id");
        Integer id = Integer.parseInt(idString);
        
        panier = panierService.addProduitPanier(panier, id);
        
        session.setAttribute("Panier", panier);

        if (user == null) {
            request.getRequestDispatcher("/jsp/connexion.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/VoirPanierServlet").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
