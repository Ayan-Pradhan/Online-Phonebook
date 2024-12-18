<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet" href="webassets/css/style.css">
</head>
<body>
	<div class="container">
		<div class="login">
			<h1 class="heading">Welcome Back!!</h1>
			<div>
				<ion-icon name="log-in-outline" class="icon"></ion-icon>
			</div>
			<span class="message">${requestScope.message}</span>
			<div>
				<form action="login" method="post">
					<input type="email" placeholder="Email Address" name="email" required> 
					<input type="password" placeholder="Password" name="password" required>
					<button>Login</button>
				</form>
			</div>
			<div class="actions">
				<p>
					<a href="forget.jsp">Forget Password?</a>
				</p>
				<p>
					New User? <a href="signup.jsp">Sign Up</a>
				</p>
			</div>
		</div>
	</div>
	<script  type="text/javascript" src="webassets/js/script.js"></script>
	<script type="module"
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>

</html>