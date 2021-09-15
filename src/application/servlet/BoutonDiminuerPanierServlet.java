package application.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.bean.Panier;
import application.bean.User;
import service.panier.imp.PanierService;

/**
 * Servlet implementation class BoutonDiminuerPanierServlet
 */
@WebServlet("/BoutonDiminuerPanierServlet")
public class BoutonDiminuerPanierServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoutonDiminuerPanierServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final PanierService panierService = PanierService.getInstance();
        final HttpSession session = request.getSession();
        final User user = (User) session.getAttribute("User");

        Panier panier = (Panier) session.getAttribute("Panier");
        String idString = request.getParameter("id");
        Integer id = Integer.parseInt(idString);
        
        panier = panierService.diminuerProduitPanier(panier, id);
        
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
