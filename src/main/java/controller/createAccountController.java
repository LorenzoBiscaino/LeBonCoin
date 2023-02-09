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


@WebServlet("/createaccount")
public class createAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	UserService service = new UserService();
			
    public createAccountController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("createAccountView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
            String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
            String userName = request.getParameter("userName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String passwordConfirmation = request.getParameter("passwordConfirmation");
           
            boolean erreur = false;
    		String firstNameError = "";
    		String lastNameError = "";
    		String emailError = "";
    		String passwordError = "";
    		String confirmationError = "";
    		
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
    			session.setAttribute("firstName", firstName);
    			session.setAttribute("lastName", lastName);
    			session.setAttribute("lastName", lastName);
    			
    			
    			User u = new User(firstName, lastName, userName, email, password, passwordConfirmation);
                this.service.add(u);
    			request.getRequestDispatcher("acceuilView.jsp").forward(request, response);
    		}
	}
}