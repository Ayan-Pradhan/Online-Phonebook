<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Forget Password?</title>
<link rel="stylesheet" href="webassets/css/style.css">
</head>
<body>
	<div class="container">
		<div class="login">
			<h2 class="heading">Step 1</h2>
			<h5>Enter your registered email address</h5>
			<div>
				<ion-icon name="key-outline" class="icon"></ion-icon>
			</div>
			<span class="message">${requestScope.message}</span>
			<div>
				<form action="recovery" method="post">
					<input type="email" placeholder="Email Address" name="email" required> 
					<button>Next</button>
				</form>
			</div>
			<div class="actions">
				<p>
					<a href="login.jsp">Cancel?</a>
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