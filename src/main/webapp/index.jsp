<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
    </head>
    <body>
        <p>
            pour Mr : <br>
            email : dupont@example.com <br>
            mpd : dupont123
        </p>
        <h3>Login</h3>
        <form action="AuthServlet" method="post">
            <p><input type="text" name="email" id="" placeholder="Entrer votre email"></p>
            <p><input type="password" name="password" id="" placeholder="Entrer votre mot de passe"></p> 
            <input type="submit" value="log in">
        </form>
    </body>
</html>