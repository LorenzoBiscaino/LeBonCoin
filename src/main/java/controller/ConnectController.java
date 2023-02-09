package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class User
 */
@WebServlet("/connect")
public class ConnectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("connect.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		


		boolean erreur = false;
		String emailErreur = "";
		String email2Erreur = "";
		String passwordErreur = "";
		String password2Erreur = "";
		
		
		if(email==null || "".equals(email)) {
			erreur = true;
			emailErreur =  "Vous devez remplir le champ e-mail!";
		} else if(!email.contains("@")) {
			erreur = true;
			email2Erreur =  "Vous devez remplir le champ e-mail au bon format : exemple@gmail.com";
		}
		if(password==null || "".equals(password)) {
			erreur = true;
			passwordErreur = "Vous devez remplir le champ mot de passe!";
		} else if(password.length()<8) {
			erreur = true;
			password2Erreur = "Le mot de passe doit contenir plus de 8 caractères!";
		}
		
		HttpSession s = request.getSession(true);
		if(erreur) {

			s.setAttribute("email", email);
			s.setAttribute("password", password);
			
			
			s.setAttribute("emailErreur", emailErreur);
			s.setAttribute("email2Erreur", email2Erreur);
			s.setAttribute("passwordErreur", passwordErreur);
			s.setAttribute("password2Erreur", password2Erreur);
			
			doGet(request,response);
		} else {
			
//			s.setAttribute("nom", nom);
//			s.setAttribute("prenom", prenom);
			request.getRequestDispatcher("accueilView.jsp").forward(request, response);
		}
		
		
	}

}