package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/myannounces")
public class myAnnouncesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public myAnnouncesController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		int userId =(int) session.getAttribute("userId");
	    session.setAttribute("userId", userId);
		request.getRequestDispatcher("myAnnouncesView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
