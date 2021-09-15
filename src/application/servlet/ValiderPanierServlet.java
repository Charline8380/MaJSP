package application.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.bean.AchatInfo;
import application.bean.Panier;
import application.bean.User;
import persistance.achat.beanDo.Achat;
import service.panier.imp.PanierService;
import util.tools.FormatUtil;

/**
 * Servlet implementation class ValiderPanierServlet
 */
@WebServlet("/ValiderPanierServlet")
public class ValiderPanierServlet extends HttpServlet {
    final PanierService       panierService    = PanierService.getInstance();
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValiderPanierServlet() {
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
        AchatInfo achatInfo = new AchatInfo(FormatUtil.convertirEntierToString(user.getId()), user.getAdresse());
        Achat achat = panierService.validerPanier(panier, achatInfo,user.getNom());
        session.setAttribute("AchatDo", achat);

        panierService.viderPanierDto(panier);
        
        session.setAttribute("Panier", panier);

        request.getRequestDispatcher("/ListeProduitsServlet").forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
