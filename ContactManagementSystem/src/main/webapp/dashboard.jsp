<%@page import="java.util.List"%>
<%@page import="dao.ContactDaoImpl"%>
<%@page import="dao.ContactDao"%>
<%@page import="beans.User"%>
<%@page import="beans.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Dashboard</title>
<link rel="stylesheet" href="webassets/css/style.css">
<%
HttpSession s = request.getSession();
User user = (User) s.getAttribute("user");
if (user == null) {
	request.setAttribute("message", "You have to login first");
	request.getRequestDispatcher("login.jsp").forward(request, response);
	return;
}

Object message1 = request.getAttribute("message");
String message;
if(message1!=null){
	message=message1.toString();
	request.removeAttribute(message);
}

%>
</head>

<body onload="showAlert('${message}')" class="dashboard-container">
	<%
		ContactDaoImpl dao = new ContactDaoImpl();
	%>
	<div class="nav">
		<div class="title">
			<ion-icon name="call-outline" class="icon"></ion-icon>
			<a href="dashboard.jsp"><h3>Phonebook</h3></a>
		</div>
		<div class="operations">
			<div class="user-img" onclick="openForm('user')">
				<img src="webassets/images/user.png" alt=""
					class="img-icon">
			</div>
			<div class="logout">
				<ion-icon name="log-out-outline" class="icon"></ion-icon>
				<a href="logout">Log Out</a>
			</div>
		</div>
	</div>
	<section class="main-container" onclick="closeForm('user')">
		<div class="content">
			<div class="header">
				<div class="button">
					<button onclick='openForm("popup")'>
						Add Contact
						<ion-icon name="add-circle-outline" class="icon"></ion-icon>
					</button>
				</div>
				<div class="search">
					<input type="text" id="search" onkeyup="searchContact()"
						placeholder="Search by name,number or email">
				</div>
			</div>
			<div class="table-container">

				<h4 class="heading">Total Contacts:<%=dao.getContactCount(user.getEmail()) %></h4>

				<table id="table" class="table">
					<thead>
						<tr>
							<th>Name</th>
							<th>Email</th>
							<th>Contact</th>
							<th colspan="3">Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<Contact> contacts = dao.getAllContact(user.getEmail());
						for(Contact contact: contacts){
						%>
							<tr>
								<td><%=contact.getName() %></td>
								<td><%=contact.getEmail() %></td>
								<td><%=contact.getContact() %></td>
								<td><a href="delete_contact?contact=<%=contact.getContact()%>"><button id="delete">Delete</button></a></td>
								<td><button onclick='fill(event,"popup-update","email","contact","name")' id="edit">Edit</button></td>
								<td><a href="share.jsp?contact=<%=contact.getContact()%>&user=<%=contact.getOwner()%>" target="_blank"><button id="share" class="btn">Share</button></a></td>
							</tr>
						<%} %>
					</tbody>
				</table>
			</div>
			<div class="popup" id="popup">
				<div class="close">
					<h2>Add Contact</h2>
					<button onclick='closeForm("popup")'>
						<ion-icon name="close-circle-outline" class="icon"></ion-icon>
					</button>
				</div>
				<form action="add_contact" method="post">
					<input type="email" placeholder="Email Address" name="email"
						required> <input type="tel" placeholder="Mobile Number"
						name="contact" required> <input type="text"
						placeholder="Enter Your Name" name="name" required>
					<button>Add</button>
				</form>
			</div>
			<div class="popup" id="popup-update">
				<div class="close">
					<h2>Update Contact</h2>
					<button onclick='closeForm("popup-update")'>
						<ion-icon name="close-circle-outline" class="icon"></ion-icon>
					</button>
				</div>
				<form action="update_contact" method="post">
					<input type="email" placeholder="Email Address" name="email" id="email" required> 
					<input type="tel" placeholder="Mobile Number" name="contact" id="contact" readonly required> 
					<input type="text" placeholder="Enter Your Name" name="name" id="name" required>
					<button>Update</button>
				</form>
			</div>
			<div class="user-details" id="user">
				<div>
					<img src="webassets/images/user.png" alt="">
				</div>
				<div>
					<h4>${sessionScope.user.name}</h4>
				</div>
				<div>
					<p>${sessionScope.user.email}</p>
					<p>${sessionScope.user.contact}</p>

				</div>
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