package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import service.UserService;


@WebServlet("/connect")
public class ConnectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserService service;
	public ConnectController() {
		service = new UserService();
	}	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true); 
		session.invalidate();

		request.getRequestDispatcher("connect.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("pw");
		
		boolean erreurSaisie = false;
		String emailErreur = "";
		String email2Erreur = "";
		String passwordErreur = "";
		String password2Erreur = "";
		
		
		if(email==null || "".equals(email)) {
			erreurSaisie = true;
			emailErreur =  "Vous devez remplir le champ e-mail!";
		} else if(!email.contains("@")) {
			erreurSaisie = true;
			email2Erreur =  "Vous devez remplir le champ e-mail au bon format : exemple@gmail.com";
		}
		if(password==null || "".equals(password)) {
			erreurSaisie = true;
			passwordErreur = "Vous devez remplir le champ mot de passe!";
		} else if(password.length()<2) {
			erreurSaisie = true;
			password2Erreur = "Le mot de passe doit contenir plus de 8 caractères!";
		}
		
		
		HttpSession s = request.getSession(true);
		if(erreurSaisie) {
			
			s.setAttribute("email", email);
			s.setAttribute("password", password);
			
			
			s.setAttribute("emailErreur", emailErreur);
			s.setAttribute("email2Erreur", email2Erreur);
			s.setAttribute("passwordErreur", passwordErreur);
			s.setAttribute("password2Erreur", password2Erreur);
			
			doGet(request,response);
		} 
		
		//Recherche dans la base de données de l'id de l'utilisateur
		
		//boolean erreurPasTrouve = false;
		String messageErreur = "";
		int idSaisi = service.getByEmail(email, password);
		
		if(idSaisi == -1) {
			//erreurPasTrouve = true;
			messageErreur = "Email et/ou mot de passe incorrect";
			s.setAttribute("messageErreur", messageErreur);
			
			doGet(request,response);
		} else {
			s.setAttribute("id", idSaisi);
			System.out.println(idSaisi);
			request.getRequestDispatcher("accueil").forward(request, response);
		}
		
		
		
	}

}