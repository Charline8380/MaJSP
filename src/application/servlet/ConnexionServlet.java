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
import service.user.imp.UserService;
import util.cryptage.MD5Encryption;

/**
 * Servlet ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
    final UserService userService = UserService.getInstance();
    private static final long serialVersionUID = 1L;

    /**
     * Constructeur par defaut
     * 
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        final User user = (User) session.getAttribute("User");
        
        if (user != null) {
            final Panier panier =new Panier();
            session.setAttribute("Panier", panier);
            request.getRequestDispatcher("/ListeProduitsServlet").forward(request, response);
        }else {
            final String messageErreur = "Email ou Mot de passe Incorect ! ";
            session.setAttribute("messageErreur", messageErreur);
            request.getRequestDispatcher("/jsp/connexion.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");
        // Je crypte le mot de passe
        final String motDePasseCrypte = MD5Encryption.cryptage(motDePasse);
        User user = userService.findUserDoForConnexion(email,motDePasseCrypte);
        
        session.setAttribute("User", user);
        
        response.sendRedirect(request.getContextPath() + "/ConnexionServlet");

    }

}
