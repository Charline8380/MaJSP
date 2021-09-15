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
 * Servlet CreerProduitServlet
 */
@WebServlet("/CreerProduitServlet")
public class CreerProduitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    final ProduitService      produitService   = ProduitService.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();

        // on récupère la liste de personnes de la session
        @SuppressWarnings("unchecked")
        List<Produit> listeDesProduits = (List<Produit>) session.getAttribute("ListeProduits");

        if (listeDesProduits == null) {
            listeDesProduits = produitService.findAllProduit();
            session.setAttribute("ListeProduits", listeDesProduits);

        }
        
        final User user = (User) session.getAttribute("User");

        if (user == null) {
            request.getRequestDispatcher("/jsp/connexion.jsp").forward(request, response);
        } else {
        request.getRequestDispatcher("/ListeProduitsServlet").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        
        final HttpSession session = request.getSession();
        String designation = request.getParameter("designation");
        String categorie = request.getParameter("categorie");
        String prix = request.getParameter("prix");
        String description = request.getParameter("description");
        String lienImage = request.getParameter("lienImage");
        final Produit produit = new Produit(designation, categorie, prix, description, lienImage);

        if (produit.getDesignation().equals("") || produit.getPrix().equals("")|| produit.getCategorie().equals("Choisir la catégorie du produit") ) {
            final String messageCreerProduit = "Les Champs Designation, Prix et Categorie sont obligatoires !";
            session.setAttribute("messageCreerProduit", messageCreerProduit);
            response.sendRedirect(request.getContextPath() + "/VoirCreerProduitServlet");
        }else {
            
        produitService.createProduit(produit);
        response.sendRedirect(request.getContextPath() + "/CreerProduitServlet");
        }
    }

}
