<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Register new user</title>
</head>
<body>
<h2>User Register Form</h2>
<p>${REGISTRATION_NOTIFICATION}</p>
<form action="register" method="post">
    <label for="fname">First name:</label>
    <input type="text" id="fname" name="firstName" placeholder="First name"/>

    <label for="lname">Last name:</label>
    <input type="text" id="lname" name="lastName" placeholder="Last name"/>

    <label for="user">User ID:</label>
    <input type="text" id="user" name="user" placeholder="User ID"/>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" placeholder="Password"/>

    <button type="submit">Submit</button>
</form>
</body>
</html>
