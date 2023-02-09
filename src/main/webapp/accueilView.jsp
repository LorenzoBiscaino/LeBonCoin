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
	
	<form action="accueil" method="post">
		<label for="categoryChoice">Recherchez des annonces par catégorie</label>
            <select name="categoryChoice">
                <option value=""></option>
                <option value="Vacances">Vacances</option>
                <option value="Emploi">Emploi</option>
                <option value="Vehicule">Véhicule</option>
                <option value="Immobilier">Immobilier</option>
                <option value="Mode">Mode</option>
                <option value="Maison">Maison</option>
                <option value="Multimedia">Multimédia</option>
                <option value="Loisir">Loisir</option>
                <option value="Animaux">Animaux</option>
                <option value="Materiel Professionnel">Matériel Professionnel</option>
                <option value="Services">Services</option>
                <option value="Divers">Divers</option>
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