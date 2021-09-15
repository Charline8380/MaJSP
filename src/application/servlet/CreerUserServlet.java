package application.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.bean.User;
import service.user.imp.UserService;
import util.cryptage.MD5Encryption;

/**
 * Servlet implementation class CreerUserServlet
 */
@WebServlet("/CreerUserServlet")
public class CreerUserServlet extends HttpServlet {
    final UserService         userService      = UserService.getInstance();
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        final User user = (User) session.getAttribute("User");

        if (user == null) {
            request.getRequestDispatcher("/jsp/connexion.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/ConnexionServlet").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        final User user = new User();
        user.setNom(request.getParameter("nom"));
        user.setPrenom(request.getParameter("prenom"));
        user.setAdresse(request.getParameter("adresse"));
        user.setEmail(request.getParameter("email"));
        // Je crypte le mot de passe
        user.setMotDePasse(MD5Encryption.cryptage(request.getParameter("password")));

        if (user.getNom().equals("") || user.getPrenom().equals("") || user.getAdresse().equals("")) {
            final String messageCreerUser = "Les Champs Tous les champs sont obligatoires !";
            session.setAttribute("messageCreerUser", messageCreerUser);
            response.sendRedirect(request.getContextPath() + "/VoirCreerUserServlet");

        } else {

            final User UserConnected = userService.createUser(user);
            session.setAttribute("User", UserConnected);

            response.sendRedirect(request.getContextPath() + "/CreerUserServlet");
        }

    }

}
