<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<h1>Bienvenue</h1>
		<h2>Création de compte</h2>
		<form action="createaccount" method="post">
		
			<label for="firstName">Nom : </label>
			<input name="firstName" type="text" ><br><br>
			<span> ${lastNameError} </span>
			
			<label for="lastName">Prénom : </label>
			<input name="lastName" type="text" ><br><br>
			<span> ${firstNameError} </span>

			<label for="userName">Pseudo : </label>
			<input name="userName" type="text" ><br><br>
			<span> ${usernameError} </span>
			
			<label for="email">Email : </label>
			<input name="email" type="email" placeholder="exemple@gmail.com"><br><br>
			<span> ${emailError} </span>
			
			<label for="password">Mot de passe : </label>
			<input name="password" type="password" ><br><br>
			<span> ${passwordError} </span>
			
			<label for="passwordConfirmation">Confirmation mot de passe : </label>
			<input name="passwordConfirmation" type="password"><br><br>
			<span> ${confirmationError} </span>
			
			<input type="submit" value="S'inscrire">
			
		</form>


	</body>
	
	
</html>