<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Phonebook</title>
    <link rel="stylesheet" href="webassets/css/home.css">
</head>
<body>
    <div class="home-container">
        <div class="nav">
            <div>
                <ion-icon name="call-outline" class="icon"></ion-icon>
                <h3>Phonebook</h3>
            </div>
            <div>
                <a href="login.jsp"><button class="btn">Login</button></a>
                <a href="signup.jsp"><button class="btn" id="register">Register</button></a>
            </div>
        </div>
        <div class="content">
            <h1>Welcome to Online Phonebook</h1>
            <h2 class="text-animation">Here you can <span></span></h2>
            <div>
                <a href=signup.jsp><button class="btn">Get Started</button></a>
            </div>
        </div>
    </div>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>