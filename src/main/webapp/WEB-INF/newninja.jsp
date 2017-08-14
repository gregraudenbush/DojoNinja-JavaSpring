<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" action="/newninjaform" modelAttribute="ninja">
	<table>
		   <form:label path="dojo">Dojos: 
        <form:select path="dojo"  >
            <form:options items="${dojos}" itemValue="id"  itemLabel="name" />
        </form:select>
        </form:label>
        <span style="color:red"><form:errors path="dojo"/></span>
        <br/>
  		<form:label path="firstName">First Name
    		
    		<form:input path="firstName"/></form:label>
    		<span style="color: red"><form:errors path="firstName"/></span>
    		</br>
    		<form:label path="lastName">Last Name
    		
    		<form:input path="lastName"/></form:label>
    		<span style="color: red"><form:errors path="lastName"/></span>
    		</br>
    		
    		<form:label path="age">age
    		
    		<form:input type="number" path="age"/></form:label>
    		<span style="color: red"><form:errors path="age"/></span>
    		</br>
		
		
		<input type="submit" value="Submit"/>
		</table>
	</form:form>

</body>
</html>