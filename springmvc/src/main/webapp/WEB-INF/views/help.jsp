<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Help page</title>
</head>
<body>

<!-- Instead of using getAttribute all the time, we can do the same thing with spring expression language
		use dollar symbol with curly braces and mention the attribute name ${name} -->
<%
/*	String name = (String)request.getAttribute("name");
	Integer rollnumber =  (Integer)request.getAttribute("rollnumber");
	LocalDateTime time = (LocalDateTime)request.getAttribute("time"); */
%>
	<h1>This is help page</h1>
	
	<h1>
		Hello My Name is
		<%-- <%=name %>  --%>
		${name }
	</h1>
	
	<h1>
		My rollnumber is
		<%-- <%=rollnumber %>  --%>
		${rollnumber }
		
	</h1>
	
	<h1>
		Date and Time is <%-- <%=time.toString().substring(0,10) --%>  ${time }
	</h1>
	
	<hr>
	
	<!-- In order to traverse the list of marks we need to use jstl -->
	<c:forEach var="item" items="${marks }">
		<h1>${item }</h1>
	</c:forEach>
	


</body>
</html>