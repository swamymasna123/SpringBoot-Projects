<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container"><hr/>
	<h3 style="color: darkgreen;text-align: center;">WELCOME TO PRODUCTS DATA PAGE</h3>
		<table class="table table-bordered table-hover text-center">
			<tr style="background-color: indigo;color: white;font-size: 22px;">
				<th>PROD-ID</th>
				<th>PROD-NAME</th>
				<th>PROD-COST</th>
				<th>PROD-DESC</th>
				<th colspan="3">LINK</th>
			</tr>
			
			<c:forEach items="${list }" var="ob">
				<tr style="font-size: 22px;">
					<td>${ob.pid }</td>
					<td>${ob.pname }</td>
					<td>${ob.pcost }</td>
					<td>${ob.pdesc }</td>
					<td><a href="delete?id=${ob.pid }" class="btn btn-danger">DELETE</a></td>
					<td><a href="edit?id=${ob.pid }" class="btn btn-primary">EDIT</a></td>
					<td><a href="view?id=${ob.pid }" class="btn btn-dark">VIEW</a></td>
				</tr>
			</c:forEach>
		</table>
		<h4  style="color: blue;text-align: center;">${message }</h4>
	</div>
</body>
</html>
