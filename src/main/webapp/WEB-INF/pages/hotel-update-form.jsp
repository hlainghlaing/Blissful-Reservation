<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<html>
<head>
<title>Update Hotel</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
  <h1>Update Hotel</h1>
  
  <form:form action="update" modelAttribute="hotel" method="post"
    enctype="multipart/form-data">

    <input type="hidden" name="hotelId" value="${hotel.hotelId}" />

    <div>
      <h3>Original Image</h3>
      <img
        src="${pageContext.request.contextPath}/resources/images/hotel-images/${hotel.hotelImg}"
        alt="Hotel Image" width="200" height="150">
    </div><br><br>
    
    <div>
      <label for="hotelName">Hotel Name:</label>
      <form:input path="hotelName" />
    </div><br><br>

    <div>
      <label for="rating">Rating:</label>
      <form:input path="rating" />
    </div><br><br>

    <div>
      <label for="address">Address:</label>
      <form:input path="address" />
    </div><br><br>

    <div>
      <label for="city">City:</label>
      <form:input path="city" />
    </div><br><br>

    <div>
      <label for="phone">Phone:</label>
      <form:input path="phone" />
    </div><br><br>


    <div>
      <label for="hotelImg">Hotel Image:</label>
      <form:input path="hotelImg" />
    </div><br><br>

    
    <div>
      <input type="submit" value="Update" onclick="showPreviewImage()" />
    </div>
  </form:form>
</body>
</html>
