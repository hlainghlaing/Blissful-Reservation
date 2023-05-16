<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Blissful Reservation | Hotel List</title>
</head>
<body>
  <div class="container">
    <h1>Hotel List</h1>
    <table>
      <thead>
        <tr>
          <th>Hotel ID</th>
          <th>Hotel Name</th>
          <th>Address</th>
          <th>City</th>
          <th>Phone Number</th>
          <th>Rating</th>
          <th>Action<th>
        </tr>
      </thead>
      <tbody>
        <%-- Iterate over the hotelList and generate rows --%>
        <c:forEach items="${hotelList}" var="hotel">
          <tr>
            <td>${hotel.hotelId}</td>
            <td>${hotel.hotelName}</td>
            <td>${hotel.address}</td>
            <td>${hotel.city}</td>
            <td>${hotel.phone}</td>
            <td>${hotel.rating}</td>
            <td><a href="edit?id=${hotel.hotelId}" class="edit-btn">Edit</a> </td>
             <td><a href="delete?id=${hotel.hotelId}" class="delete-btn">Delete</a></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>

