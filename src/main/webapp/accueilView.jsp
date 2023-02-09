<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Accueil</title>
	</head>
	<body>
	
	<h1>LeBonCoin</h1>
	
	<form action="accueilController" method="post">
		<label for="categoryChoice">Recherchez des annonces par catégorie</label>
            <select name="categoryChoice">
                <option value=""></option>
                <option value="1">Vacances</option>
                <option value="2">Emploi</option>
                <option value="3">Véhicule</option>
                <option value="4">Immobilier</option>
                <option value="5">Mode</option>
                <option value="6">Maison</option>
                <option value="7">Multimédia</option>
                <option value="8">Loisir</option>
                <option value="9">Animaux</option>
                <option value="10">Matériel Professionnel</option>
                <option value="11">Services</option>
                <option value="12">Divers</option>
			</select>
			
			<input type="submit" value="Rechercher">
	</form>
	
	<h3>Votre profil</h3>
	<br>
	<p>Prénom : ${user.firstName}</p>
	<p>Nom : ${user.lastName}</p>
	<p>Pseudo : ${user.username}</p>
	<p>Téléphone : ${user.phone}</p>
	<p>Email : ${user.email}</p>
	<br>
	<a href="http://localhost:8080/LeBonCoin/updateaccount" >Changer mes informations personnelles</a>
	<br><br><br>
	<a href="http://localhost:8080/LeBonCoin/myAnnounces" >Voir mes annonces</a>
	<br><br><br>
	<a href="http://localhost:8080/LeBonCoin/createAnnounce" >Créer une nouvelle annonce</a>
	<br><br><br><br><br><br>
	<a href="http://localhost:8080/LeBonCoin/connect" >Se déconnecter</a>
		
	</body>
</html>