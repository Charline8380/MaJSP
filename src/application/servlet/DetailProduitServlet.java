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
 * Servlet DetailProduitServlet
 */
@WebServlet("/DetailProduitServlet")
public class DetailProduitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    final ProduitService      produitService   = ProduitService.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        String idString = request.getParameter("id");
        Integer id = Integer.parseInt(idString);

        final Produit produit = produitService.findProduitById(id);

        session.setAttribute("Produit", produit);
        
        final User user = (User) session.getAttribute("User");

        if (user == null) {
            request.getRequestDispatcher("/jsp/connexion.jsp").forward(request, response);
        } else {
        request.getRequestDispatcher("/jsp/detailProduit.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
