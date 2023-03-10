package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/announcescontroller")
public class AnnouncesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AnnouncesController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String category = request.getParameter("category");
		
		 
		HttpSession session = request.getSession(true);
		String category =(String) session.getAttribute("category");
	    session.setAttribute("category", category);
		request.getRequestDispatcher("announcesView.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
