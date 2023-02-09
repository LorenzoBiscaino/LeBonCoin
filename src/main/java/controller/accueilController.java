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


@WebServlet("/accueil")
public class accueilController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	UserService service;
	
    public accueilController() {
        super();
        service = new UserService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession(true);
			int id =(int) session.getAttribute("id");
			User u = service.getById(id);
			
			request.setAttribute("user", u);
		} catch (Exception e) {
		}
		
		request.getRequestDispatcher("accueilView.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String category= request.getParameter("categoryChoice");
		
		try {
			if(category!=null) {
				HttpSession s = request.getSession(true);
				s.setAttribute("category", category);
				request.getRequestDispatcher("announcescontroller").forward(request, response);
			} else {
				doGet(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			doGet(request,response);
		}
		
	}

}
