<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="entity.Announce" %>
    <%@page import="service.AnnounceService" %>
    <%@page import="entity.User" %>
    <%@page import="service.UserService" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Announces View</title>
</head>
<body>
<h1>Liste des annonces pour la catégorie : ${category}</h1>

<table>
		<thead>
			<tr>
				<th>id</th>
				<th>catégorie</th>
				<th>titre</th>
				<th>région</th>
				<th>description</th>
				<th>pays</th>
				<th>photo</th>
				<th>prix</th>
				<th>vendeur</th>
			</tr>
		</thead>
	
	
		
			<tbody>
				<%String category2 = request.getParameter("category"); %>
				<% for ( Announce a : new AnnounceService().getByCategory(category2)) {%>
				<% User u =new UserService().getById(a.getUserId()); %>
					<tr>
						<td> <%= a.getId() %> </td>
						<td> <%= a.getCategory() %> </td>
						<td> <%= a.getAnnounceTitle() %> </td>
						<td> <%= a.getRegion() %> </td>
						<td> <%= a.getDescription() %> </td>
						<td> <%= a.getState() %> </td>
						<td> <img src="<%= a.getPhotos() %>" alt="photo annonce"/> </td>
						<td> <%= a.getPrice() %> </td>
						<td> <%= u.getUsername() %> </td>
					</tr>
				<%} %>
			</tbody>
		</table>
		<a href='/LeBonCoin/accueil'>Retour à l'accueil</a>
</body>
</html> 