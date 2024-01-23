<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
<h1>Student Name is ${ student.name }</h1>
<h1>Student Id is ${ student.id }</h1>
<h1>Student DOB is ${ student.date }</h1>
<h1>Student Courses are ${ student.courses }</h1>
<h1>Student Gender is ${ student.gender }</h1>
<h1>Student type is ${ student.type }</h1>
<hr>
<h1>Student Address Street is ${ student.address.street }</h1>
<h1>Student Address City is ${ student.address.city }</h1>
</body>
</html>