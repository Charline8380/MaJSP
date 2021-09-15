package application.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.bean.User;
import service.produit.imp.ProduitService;

/**
 * Servlet SupprimerProduitServlet
 */
@WebServlet("/SupprimerProduitServlet")
public class SupprimerProduitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    final ProduitService      produitService   = ProduitService.getInstance();

    /**
     * Constructeur par defaut
     * 
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerProduitServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        final User user = (User) session.getAttribute("User");
        String idString = request.getParameter("id");

        Integer id = Integer.parseInt(idString);

        produitService.delete(id);

        //definir action servlet

        if (user == null) {
            request.getRequestDispatcher("/jsp/connexion.jsp").forward(request, response);
        } else {

            request.getRequestDispatcher("/ListeProduitsServlet").forward(request, response);
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
