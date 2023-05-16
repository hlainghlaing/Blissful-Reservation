<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>All Rooms</h1>
<table border="2" width="70%" cellpadding="2">  
<tr><th>Room Type</th><th>Total Rooms<th>Available Rooms</th><th>Price</th><th>Image</th><th>Deleted At</th><th>Edit</th><th>Delete</th><th>Hotel Name</th><th>Hotel Address</th><th>City</th><th>Phone Number</th><th>Rating</th><th>Hotel Image</th></tr>  
   <c:forEach var="r" items="${list}">   
   <tr>
   <td>${r.roomId}</td>
   <td>${r.roomType}</td> 
   <td>${r.totalRoom}</td>
   <td>${r.avaRoom}</td>  
   <td>${r.price}</td>  
   <td><img alt="Room Image" src="<%= request.getContextPath()%>/resources/img/${r.roomImg}" width="50px" height="50px"></td>
   <td>${r.createdAt}</td>
   <td>${r.updatedAt}</td>
   <td>${r.deleteAt}</td>
   <td>${r.hotel.hotelName}</td>
   <td>${r.hotel.address }</td>
   <td>${r.hotel.city }</td>
   <td>${r.hotel.phone }</td>
   <td>${r.hotel.rating }</td>
   <td><img alt="Room Image" src="<%= request.getContextPath()%>/resources/img/${r.hotel.hotelImg}" width="50px" height="50px"></td>
   <td><a href="editroom?id=${r.roomId}">Edit</a></td>  
   <td><a href="deleteroom?id=${r.roomId}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   
   <form method="POST" action="uploadImage" enctype="multipart/form-data">
    <input type="file" name="image">
    <input type="submit" value="Upload">
</form>
   
</body>
</html>