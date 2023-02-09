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


@WebServlet("/updateaccount")
public class updateAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService service;
       
 
    public updateAccountController() {
        super();
        service = new UserService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(true);
			int userId =(int) session.getAttribute("userId");
			User u = service.getById(userId);
			
			request.setAttribute("user", u);
			request.setAttribute("userId", userId);
		}catch (Exception e) {
		}

		request.getRequestDispatcher("updateAccountView.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("txtFirstName");
		String lastName = request.getParameter("txtLastName");
        String userName = request.getParameter("txtUsername");
        String email = request.getParameter("txtEmail");
        String password = request.getParameter("txtPassword");
        String passwordConfirmation = request.getParameter("txtConfirmationPassword");
        String phone = request.getParameter("txtPhone");
       
        boolean erreur = false;
		String firstNameError = "";
		String lastNameError = "";
		String emailError = "";
		String passwordError = "";
		String confirmationError = "";
		String phoneError = "";
		
		if (firstName == null || "".equals(firstName)) {
			erreur = true;
			firstNameError = "first name not fill";
		}
		if (lastName == null || "".equals(lastName)) {
			erreur = true;
			lastNameError = "last name not fill";
		}
		if( email == null || !email.contains("@")) {
			erreur = true;
			emailError = "email does not contain '@'";
		}
		if (password == null || password.length() < 8) {
			passwordError = "Password length < 8";
			erreur = true;
		}
		if (phone == null || "".equals(phone)) {
			erreur = true;
			phoneError = "phone not fill";
		}
		if (passwordConfirmation == null || !passwordConfirmation.equals(password) || "".equals(passwordConfirmation)) {
			erreur = true;
			confirmationError = "confirmation and password not equals";
		}
		
		HttpSession session = request.getSession(true);
		
		if (erreur) {
			session.setAttribute("firstname", firstName);
			session.setAttribute("lastname", lastName);
			session.setAttribute("email", email);
			session.setAttribute("password", password);
			session.setAttribute("confirmation", passwordConfirmation);
			
			session.setAttribute("firstNameError", firstNameError);
			session.setAttribute("lastNameError", lastNameError);
			session.setAttribute("emailError", emailError);
			session.setAttribute("passwordError", passwordError);
			session.setAttribute("confirmationError", confirmationError);

			doGet(request, response);			
		} else {
			try {
				int userId =(int) session.getAttribute("userId");
				User u = new User(userId,firstName, lastName, userName, email, password, phone);
				service.update(u);
				
			} catch (Exception e) {
				 e.printStackTrace();
			}
			
			
			request.getRequestDispatcher("accueil").forward(request, response);
		}
}
	}



