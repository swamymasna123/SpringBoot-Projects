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
	<div class="container">
		<hr />

		<div class="card col-md-4 offset-md-4 offset-md-4" style="border-color: indigo;">
			<div class="card-body">
		<h3 style="color: indigo; text-align: center;">PRODUCTS VIEW PAGE</h3>
				<table class="table table-bordered table-hover text-center" style="font-size: 22px;">
					<tr>
						<th>PROD-ID</th>
						<td>${ob.pid }</td>
					</tr>

					<tr>
						<th>PROD-NAME</th>
						<td>${ob.pname }</td>
					</tr>

					<tr>
						<th>PROD-COST</th>
						<td>${ob.pcost }</td>
					</tr>

					<tr>
						<th>PROD-DESC</th>
						<td>${ob.pdesc }</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
