<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>welcome to login page
</body>
<form action=""></form>

<form:form action="loginprocess" method="get" modelAttribute="uiobject">

Enter user ID   : <form:input path="userId" /><br>
Enter user name : <form:input path="userName"/>	<br>
                  <form:errors path="userName" ></form:errors>
Enter password  : <form:password path="password" />
                  <form:errors path="password" ></form:errors>
	     <input type="submit" value="login">
	     
	     <input type="button" onclick="doSomeWork()" value="Click Me" />

</form:form>
</html>