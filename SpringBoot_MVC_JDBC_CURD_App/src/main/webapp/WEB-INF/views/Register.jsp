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
		<a href='all'>VIEW ALL</a>
	</h3>
	<h2>WELCOME TO EMPLOYEE REGISTER PAGE</h2>
	<form action="save" method="post">
		<pre>
EMPLOYEE ID   :<input type="text" name="eid" />
EMPLOYEE NAME :<input type="text" name="ename" />
EMPLOYEE SAL  :<input type="text" name="esal" />
<input type="submit" value="Register" />
</pre>
	</form>
	${message}
</body>
</html>