<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Account View</title>
</head>
<body>

<h1>Mettre à jour votre compte</h1>
	
	<form method="post" action="updateaccount">
		<label for='txtid'>id</label>
		<input type='number' name='txtid' disabled="disabled" value="${user.id}" > <br/> 
	
		<label for='txtFirstName'>Prénom</label>
		<input type='text' name='txtFirstName' value="${user.firstName}"> 
		<span> ${firstNameError} </span><br/>
		
		<label for='txtLastName'>Nom</label>
		<input type='text' name='txtLastName' value="${user.lastName}"> 
		<span> ${lastNameError} </span><br/>
		
		<label for='txtUsername'>Pseudo</label>
		<input type='text' name='txtUsername' value="${user.username}"> 
		<span> ${lastNameError} </span><br/>
		
		<label for='txtEmail'>Email</label>
		<input type='text' name='txtEmail' value="${user.email}"> <br/>
		
		<label for='txtPassword'>Mot de passe</label>
		<input type='password' name='txtPassword' value="${user.password}"> <br/>
		
		<label for='txtConfirmationPassword'>Confirmation mot de passe</label>
		<input type='password' name='txtConfirmationPassword' value="${user.password}"> <br/>
		
		<label for='txtPhone'>Phone</label>
		<input type='text' name='txtPhone' value="${user.phone}"> <br/>
		
		<input type='submit' value='Valider'>
	</form>

</body>
</html>