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
	<hr/>
	<div class="card col-md-4 offset-md-4 offset-md-4" style="background-color: black;color: white;">
		<div class="card-body">
		<h4 class="text-center">PRODUCTS REGISTER PAGE</h4><br/>
			<form action="save" method="POST">
				<!-- PRODUCT NAME -->
				<div class="row">
					<div class="col-4">
						<label>PROD-NAME</label>
					</div>
					<div class="col-8">
						<input type="text" name="pname" class="form-control" placeholder="Enter Product Name"  style="background-color: black;color: white;"/>
					</div>
				</div><br/>

				<!-- PRODUCT COST -->
				<div class="row">
					<div class="col-4">
						<label>PROD-COST</label>
					</div>
					<div class="col-8">
						<input type="text" name="pcost" class="form-control" placeholder="Enter Product Cost"  style="background-color: black;color: white;"/>
					</div>
				</div><br/>

				<!-- PRODUCT DESC -->
				<div class="row">
					<div class="col-4">
						<label>PROD-DESC</label>
					</div>
					<div class="col-8">
						<input type="text" name="pdesc" class="form-control"
							placeholder="Enter Product Description"  style="background-color: black;color: white;"/>
					</div>
				</div><br/>

				<div style="text-align: center;">
					<input type="submit" value="REGISTER" class="btn btn-primary" />
					 <a href="all" class="btn btn-danger" style="margin-left: 20px;">CANCEL</a>
				</div>
			</form>
		</div>
	</div>

	<h4  style="color: blue;text-align: center;">${message }</h4>
	</div>
</body>
</html>