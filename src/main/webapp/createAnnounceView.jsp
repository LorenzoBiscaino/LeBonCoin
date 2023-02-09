<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Création d'une annonce</title>
	</head>
	<body>
		<h1>LeBonCoin</h1>
		<br>
		<h3>Veuillez renseigner les informations suivantes concernant votre nouvelle annonce : </h3>
		<form action="createAnnounce" method="post">
		
		<label for="category">Catégorie</label>
		<select name="category" value="${category}">
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
			<span style="color:#FF0000"> ${categoryErreur} </span><br><br>
			
			<label for="region">Région</label>
			<select name="region" value="${region}">
                <option value=""></option>
                <option value="Auvergne-Rhone-Alpes">Auvergne-Rhône-Alpes</option>
                <option value="Bourgogne-Franche-Comte">Bourgogne-Franche-Comté</option>
                <option value="Bretagne">Bretagne</option>
                <option value="Centre-Val de Loire">Centre-Val de Loire</option>
                <option value="Corse">Corse</option>
                <option value="Grand Est">Grand Est</option>
                <option value="Hauts-de-France">Hauts-de-France</option>
                <option value="Ile-de-France">Île-de-France</option>
                <option value="Normandie">Normandie</option>
                <option value="Nouvelle-Aquitaine">Nouvelle-Aquitaine</option>
                <option value="Occitanie">Occitanie</option>
                <option value="Pays de la Loire">Pays de la Loire</option>
                <option value="Provence-Alpes-Cote d'Azur">Provence-Alpes-Côte d'Azur</option>
			</select>
			<span style="color:#FF0000"> ${regionErreur} </span><br><br>
			
			<label for="announceTitle">Titre de l'annonce</label><br>
			<textarea rows=3 name="announceTitle" >${announceTitle}</textarea>
			<span style="color:#FF0000"> ${announceTitleErreur} </span><br><br>
			
			
			
			<label for="description">Description de l'annonce</label><br>
			<textarea rows=10 name="description" >${description}</textarea>
			<span style="color:#FF0000"> ${descriptionErreur} </span><br><br>
			
			<label for="photos">Photo</label><br>
			<input type="file" name="photos" accept="image/png, image/jpeg" value="${photos}">
			<span style="color:#FF0000"> ${photosErreur} </span><br><br>
			
			<label for="state">Etat</label><br>
			
			Neuf : <INPUT type=radio name="state" value="Neuf">
			<br>Très bon état : <INPUT type=radio name="state" value="Tres bon etat">
			<br>Bon état : <INPUT type=radio name="state" value="Bon etat">
			<br>Usager : <INPUT type=radio name="state" value="Usager">
			<span style="color:#FF0000"> ${stateErreur} </span><br><br>
			
			<label for="price">Prix</label>
			<input type="number" name="price" min="0.50" max="1000000" step="0.50" value="${price}">
			<span style="color:#FF0000"> ${priceErreur} </span><br><br>
			
			<input type="submit" value="Créer">

		</form>
		

	
	</body>
</html>