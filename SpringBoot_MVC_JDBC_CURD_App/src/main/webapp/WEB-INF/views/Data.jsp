<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>
		<a href='register'>REGISTER</a>
	</h3>
	<H2>WELCOME TO EMPLOYEE DATA PAGE...!</H2>
	<table border="1">
		<tr>
			<th>EMPLOYEE ID</th>
			<th>EMPLOYEE NAME</th>
			<th>EMPLOYEE SALARY</th>
			<th colspan="2">OPERATION</th>
		</tr>
		<c:forEach items="${list }" var="ob">
			<tr>
				<td>${ob.eid}</td>
				<td>${ob.ename}</td>
				<td>${ob.esal}</td>
				<td><a href="delete?id=${ob.eid}">DELETE</a></td>

<%-- 				<td><a href="delete/${ob.eid }">DELETE</a></td> --%>

<%-- 				 <td><a href="edit/${ob.eid }">EDIT</a></td> --%>

 				<td><a href="edit?id=${ob.eid}">EDIT</a></td> 
			</tr>
		</c:forEach>
	</table>
	${message }
</body>
</html>