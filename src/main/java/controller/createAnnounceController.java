package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Announce;
import entity.User;
import service.AnnounceService;
import service.UserService;


@WebServlet("/createAnnounce")
public class createAnnounceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AnnounceService service;
	UserService serviceUser;
 
    public createAnnounceController() {
        super();
        service = new AnnounceService();
        serviceUser = new UserService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("createAnnounceView.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession s = request.getSession(true);
		s.removeAttribute("categoryErreur");
		s.removeAttribute("regionErreur");
		s.removeAttribute("announceTitleErreur");
		s.removeAttribute("descriptionErreur");
		s.removeAttribute("photosErreur");
		s.removeAttribute("stateErreur");
		s.removeAttribute("priceErreur");
		
		
		String category = request.getParameter("category");
		String region = request.getParameter("region");
		String announceTitle = request.getParameter("announceTitle");
		String description = request.getParameter("description");
		String photos = request.getParameter("photos");
		String state = request.getParameter("state");
		String priceString = request.getParameter("price");
		
		
		boolean erreur = false;
		String categoryErreur = "";
		String regionErreur = "";
		String announceTitleErreur = "";
		String descriptionErreur = "";
		String photosErreur = "";
		String stateErreur = "";
		String priceErreur = "";

		
		
		if(category==null || "".equals(category)) {
			erreur = true;
			categoryErreur = "Vous devez remplir le champ Catégorie!";
		}
		if(region==null || "".equals(region)) {
			erreur = true;
			regionErreur = "Vous devez remplir le champ Région!";
		}
		if(announceTitle==null || "".equals(announceTitle)) {
			erreur = true;
			announceTitleErreur =  "Vous devez remplir le champ Titre!";
		}
		if(description==null || "".equals(description)) {
			erreur = true;
			descriptionErreur = "Vous devez remplir le champ Description!";
		}
		
		if(photos==null || "".equals(photos)) {
			erreur = true;
			photosErreur = "Vous devez remplir le champ photos!";
		}
		
		if(state==null || "".equals(state)) {
			erreur = true;
			stateErreur = "Vous devez remplir le champ Etat!";
		}
		if(priceString==null || "".equals(priceString)) {
			erreur = true;
			priceErreur = "Vous devez remplir le champ Prix!";
		}
		
		
		
		if(erreur) {
			
			s.setAttribute("category", category);
			s.setAttribute("region", region);
			s.setAttribute("announceTitle", announceTitle);
			s.setAttribute("description", description);
			s.setAttribute("photos", photos);
			s.setAttribute("price", priceString);
			
			s.setAttribute("categoryErreur", categoryErreur);
			s.setAttribute("regionErreur", regionErreur);
			s.setAttribute("announceTitleErreur", announceTitleErreur);
			s.setAttribute("descriptionErreur", descriptionErreur);
			s.setAttribute("photosErreur", photosErreur);
			s.setAttribute("stateErreur", stateErreur);
			s.setAttribute("priceErreur", priceErreur);
			
			doGet(request,response);
		} else {
			s.setAttribute("categoryErreur", null);
			s.setAttribute("regionErreur", null);
			s.setAttribute("announceTitleErreur", null);
			s.setAttribute("descriptionErreur", null);
			s.setAttribute("photosErreur", null);
			s.setAttribute("stateErreur", null);
			s.setAttribute("priceErreur", null);
			erreur = false;
			
			//int userId = Integer.parseInt( request.getParameter("id"));
			//int userId = 1;

			int userId =(int) s.getAttribute("userId");
			float price = Float.parseFloat(request.getParameter("price"));
			Announce a = new Announce(category,announceTitle,region,description,state,photos,userId,price);
			service.add(a);
			request.getRequestDispatcher("accueil").forward(request, response);
		}
		
	}

}
