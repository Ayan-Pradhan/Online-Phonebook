<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>500 Internal Server Error</title>
    <link rel="stylesheet" href="webassets/css/style.css">
</head>
<body>
	<%
		request.getSession().invalidate();
	%>
    <div class="err-container">
        <img src="webassets/images/500.jpg" alt="Error" class="err-img">
        <span>${requestScope.errorMessage}</span>
        <a href="index.jsp" class="err-btn">Go Back</a>
    </div>
</body>
</html>