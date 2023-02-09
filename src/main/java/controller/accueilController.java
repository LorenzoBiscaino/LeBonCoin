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
		int id = -1;
		
		try {
			id = Integer.parseInt( request.getParameter("id"));
		} catch (Exception e) {
		}
		
		User u = service.getById(id);
		
		request.setAttribute("user", u);
		request.getRequestDispatcher("accueilView.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("categoryChoice"));
		try {
			String category= request.getParameter("categoryChoice");
			//int id = Integer.parseInt( request.getParameter("id"));
			int id = 1;

			HttpSession s = request.getSession(true);
			s.setAttribute("category", category);
			s.setAttribute("id", id);
			request.getRequestDispatcher("announcesView.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			doGet(request,response);
		}
		
	}

}
