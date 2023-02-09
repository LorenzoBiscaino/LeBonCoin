<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
	<h1>Authentification</h1>

        <form method ="post" action="connect">

            <label for="email">Email</label><br>
            <input type="email" name="email" placeholder="exemple@exemple.com"><br>
            <span> ${emailErreur} </span>
            <span> ${email2Erreur} </span>

            <label for="pw">Password</label><br>
            <input type="password" name="pw"><br>
            <span> ${passwordErreur} </span>
            <span> ${password2Erreur} </span>
            
            <p> ${messageErreur} </p>
                      
            <input type="submit" value="Valider">
        </form>

</body>
</html>