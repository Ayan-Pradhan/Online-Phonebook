<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="webassets/css/style.css">
</head>

<body>
    <div class="container">
        <div class="registration">
            <h1 class="heading">Sign Up</h1>
            <div>
                <ion-icon name="person-add-outline" class="icon"></ion-icon>
            </div>
            <span class="message">${requestScope.errorMessage }</span><br>
            <div>
                <form action="registration" method="post">
                    <input type="email" placeholder="Email Address" name="email" required>
                    <input type="tel" placeholder="Mobile Number" name="contact" required>
                    <input type="text" placeholder="Enter Your Name" name="name" required>
                    <input type="password" placeholder="Enter Password" name="password" required>
                    <input type="text" placeholder="Confirm Password" name="cpass" required>
                    <button>Register</button>
                </form>
            </div>
            <div class="actions">
                <p>Already have an account?<a href="login.jsp">Login</a></p>
            </div>
        </div>
    </div>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>

</html>