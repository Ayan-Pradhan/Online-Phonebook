<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Reset Credentials</title>
<link rel="stylesheet" href="webassets/css/style.css">
</head>
<body>
	<div class="container">
		<div class="login">
			<h1 class="heading">Step 3</h1>
			<h3>Enter new password</h3>
			<div>
				<ion-icon name="checkmark-circle-outline" class="icon"></ion-icon>
			</div>
			<span class="message">${requestScope.message}</span>
			<div>
				<form action="reset" method="post">
					<input type="password" placeholder="Enter new password" name="password" required> 
					<input type="text" placeholder="Repeat password" name="confirm" required> 
					<button>Reset</button>
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