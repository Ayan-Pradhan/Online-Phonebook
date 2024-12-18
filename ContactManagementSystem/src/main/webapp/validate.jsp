<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Validate OTP</title>
<link rel="stylesheet" href="webassets/css/style.css">
</head>
<body>
	<div class="container">
		<div class="login">
			<h2 class="heading">Step 2</h2>
			<h5>A 6-digit OTP has been sent to your email</h5>
			<div>
				<ion-icon name="mail-unread-outline" class="icon"></ion-icon>
			</div>
			<span class="message">${requestScope.message}</span>
			<div>
				<form action="validate" method="post">
					<input type="text" placeholder="Enter OTP" name="otp" required> 
					<button>Validate</button>
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