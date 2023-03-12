<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="css/login.css" rel="stylesheet" type="text/css">
    <title>TODO App</title>
</head>
<body>
<h1>TODO App</h1>
<br>
<form action="login" method="post">

    <label for="user">User ID</label>
    <br>
    <input type="text" id="user" name="user" placeholder="User ID" />
    <br>
    <label for="password">Password</label>
    <br>
    <input type="password" id="password" name="password" placeholder="Password" />
    <br>
    <p>${LOGIN_NOTIFICATION}</p>
    <button type="submit">Login</button>
</form>

<a href="register.jsp">Register new user</a>
</body>
</html>
