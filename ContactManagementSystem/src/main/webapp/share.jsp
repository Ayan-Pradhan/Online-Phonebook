<%@page import="service.EncryptAddress"%>
<%@page import="beans.Contact"%>
<%@page import="dao.ContactDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Contact Info</title>
<link rel="stylesheet" href="webassets/css/style.css">
</head>

<body onclick="closePopup()" class="dashboard-container">
	<section class="main-container">
		<div class="content">
			<h1 class="heading">Contact Details</h1>
			<div class="table-container">
				<table id="table" class="table">
					<thead>
						<tr>
							<th>Name</th>
							<th>Email</th>
							<th>Contact</th>
						</tr>
					</thead>
					<tbody>
						<%
							EncryptAddress enc = new EncryptAddress();
							String id = request.getParameter("contact");
							String owner = request.getParameter("user");
							if(enc.isHexadecimal(id)&&enc.isHexadecimal(owner)){
								id=enc.decrypt(id);
								owner=enc.decrypt(owner);
							}
							ContactDaoImpl dao = new ContactDaoImpl();
							Contact con = dao.getContact(id,owner);
						%>
					
							<tr>
								<td><%=con.getName() %></td>
								<td><%=con.getEmail() %></td>
								<td><%=con.getContact() %></td>
							</tr>
					</tbody>
				</table>
			</div>
			<div class="share">
				<input type="url" id="url" value="<%=request.getRequestURL()+"?contact="+enc.encrypt(id)+"&user="+enc.encrypt(owner)%>" readonly>
				<button class="share-btn" onclick="copyToClipboard()">Copy Link</button>
			</div>
			<div class="share-popup" id="share-popup">
				<p>Copied to clipboard</p>
			</div>
		</div>
	</section>
	<script src="webassets/js/script.js"></script>
	<script type="module"
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>

</html>