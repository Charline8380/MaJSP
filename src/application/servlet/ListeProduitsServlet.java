package application.servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet ListeProduitsServlet
 */
@WebServlet("/ListeProduitsServlet")
public class ListeProduitsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    final ProduitService      produitService   = ProduitService.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeProduitsServlet() {
        super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException {

        final HttpSession session = request.getSession();

        // on récupère la liste de personnes de la session
        @SuppressWarnings("unchecked")
        List<Produit> listeDesProduits = (List<Produit>) session.getAttribute("ListeProduits");

        if (listeDesProduits == null) {
            listeDesProduits = produitService.findAllProduit();
            session.setAttribute("ListeProduits", listeDesProduits);

        }

            request.getRequestDispatcher("/jsp/listeProduits.jsp").forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(final HttpServletRequest request,final  HttpServletResponse response) throws ServletException, IOException {
        //empty
        doGet(request, response);
    }

}
