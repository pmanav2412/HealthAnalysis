<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container text-center" id="tasksDiv">
			<form:form action="/Calory123" method="Post" modelAttribute="user">
			
		
		<label>NAME:	<select name="username">
     <c:forEach var="user" items="${users}">
          <option><c:out value="${user.username}"/></option>
     </c:forEach>
</select> </label>
<input type="submit" value="submit">
</div>
</form:form>
		 </div>
</body>
</html>