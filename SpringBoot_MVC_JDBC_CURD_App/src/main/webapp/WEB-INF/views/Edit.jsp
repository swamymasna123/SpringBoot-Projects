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
	<h2>WELCOME TO EMPLOYEE EDIT PAGE</h2>
	<form action="update" method="post">
		<pre>
EMPLOYEE ID   :<input type="text" name="eid" value="${ob.eid }"
				readonly="readonly" />
EMPLOYEE NAME :<input type="text" name="ename" value="${ob.ename }" />
EMPLOYEE SAL  :<input type="text" name="esal" value="${ob.esal }" />
<input type="submit" value="Update" />
</pre>
	</form>
	${message}
</body>
</html>