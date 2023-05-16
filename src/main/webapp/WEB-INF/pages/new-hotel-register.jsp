<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ page import="javax.servlet.http.HttpServletRequest" %>
<!DOCTYPE html>
<html>
<head>
    <title>Blissful Reservation | New Hotel Register</title>
   
</head>
<body>
    <h1>Registration New Hotel</h1>
    <div class="form-container">
        <form:form action="register" modelAttribute="hotel" method="post" enctype="multipart/form-data">
            <label for="name">Name:</label>
            <form:input type="text" path="hotelName" /><br><br>

            <label for="rating">Rating:</label>
            <form:input type="number" path="rating" min="1" max="5" /><br><br>

            <label for="address">Address:</label>
            <form:input type="text" path="address" /><br><br>

            <label for="city">City:</label>
            <form:input type="text" id="city" path="city" /><br><br>

            <label for="phoneNumber">Phone Number:</label>
            <form:input type="text" path="phone" /><br><br>

             <form:input type="file" id="image" path="file" accept="image/*" />
              <label for="image" class="file-label">Choose File<span class="file-name"></span></label><br><br>

            <input type="submit" value="Register">
      </form:form>
    </div>
</body>
</html>

