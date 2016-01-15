<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>all contacts</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Contacts</h2>	
	<table>
		<tr>
			<td>NAME</td><td>SURNAME</td><td>PHONE</td><td>EMAIL</td><td>HOBBY</td>
		</tr>
		<c:forEach items="${contacts}" var="contact">
			<tr>
			<td>${contact.firstName}</td>
			<td>${contact.lastName}</td>
			<td>${contact.phone}</td>
                        <td>${contact.email}</td>
                        <td>${contact.hobby}</td>
			<td><a href="<c:url value='/edit-${contact.phone}-contact' />">${contact.phone}</a></td>
			<td><a href="<c:url value='/delete-${contact.id}-contact' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />">Add New Contact</a>
</body>
</html>