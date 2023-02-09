<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@page import="entity.Announce" %>
    <%@page import="service.AnnounceService" %>
    <%@page import="entity.User" %>
    <%@page import="service.UserService" %>
    <%@ page import = " java.util.* " %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Mes annonces</title>
	</head>
	<body>
	<h1>Liste de mes annonces</h1>

<table>
		<thead>
			<tr>
				<th>id</th>
				<th>Catégorie</th>
				<th>Titre</th>
				<th>Région</th>
				<th>Description</th>
				<th>Etat</th>
				<th>Photo</th>
				<th>Prix</th>
				<th>Vendeur</th>
			</tr>
		</thead>
	
	
		
			<tbody>
				<%int userId = (int) session.getAttribute("userId"); 
				 for ( Announce a : new AnnounceService().getByUserId(userId)) {%>
					<tr>
						<td> <%= a.getId() %> </td>
						<td> <%= a.getCategory() %> </td>
						<td> <%= a.getAnnounceTitle() %> </td>
						<td> <%= a.getRegion() %> </td>
						<td> <%= a.getDescription() %> </td>
						<td> <%= a.getState() %> </td>
						<td> <img src="<%= a.getPhotos() %>" alt="photo annonce"/> </td>
						<td> <%= a.getPrice() %> </td>
					</tr>
				<%} %>
			</tbody>
		</table>
		<a href='/LeBonCoin/accueil'>Retour à l'accueil</a>
	
	</body>
</html>