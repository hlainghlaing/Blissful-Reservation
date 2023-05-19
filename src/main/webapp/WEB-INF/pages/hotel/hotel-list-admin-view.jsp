<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section>
  <div class="cmn-inner">
    <c:if test="${not empty successMessage}">
      <p class="cmn-success-msg">${successMessage}</p>
    </c:if>
    <h1>Hotel List</h1>
    <table border=1>
      <thead>
        <tr>
          <th>Hotel ID</th>
          <th>Hotel Name</th>
          <th>Address</th>
          <th>City</th>
          <th>Phone Number</th>
          <th>Rating</th>
          <th>Hotel Image</th>
          <th>Created At</th>
          <th>Updated At</th>
          <th>Deleted At</th>
          <th>Action</th>

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
            <td>${hotel.hotelImg}</td>
            <td>${hotel.createdAt}</td>
            <td>${hotel.updatedAt}</td>
            <td>${hotel.deletedAt}</td>
            <td><a class="cmn-btn"
              href="edit-hotel?id=${hotel.hotelId}">Edit</a> <a
              href="delete-hotel?id=${hotel.hotelId}" class="cmn-btn">Delete</a>
              <a href="add-room?id=${hotel.hotelId}" class="cmn-btn">Add
                New Room</a></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <br> <br>
    <h2>Room List</h2>
    <table border=1>
      <tr>
        <th>RoomId</th>
        <th>Room Type</th>
        <th>Total Rooms
        <th>Available Rooms</th>
        <th>Price</th>
        <th>Image</th>
        <th>Created At</th>
        <th>Updated At</th>
        <th>Deleted At</th>
        <th>Hotel Name</th>
        <th>Hotel Address</th>
        <th>City</th>
        <th>Phone Number</th>
        <th>Actions</th>
      </tr>
      <c:forEach var="r" items="${list}">
        <tr>
          <td>${r.roomId}</td>
          <td>${r.roomType}</td>
          <td>${r.totalRoom}</td>
          <td>${r.avaRoom}</td>
          <td>${r.price}</td>
          <td>${r.roomImg}</td>
          <td>${r.createdAt}</td>
          <td>${r.updatedAt}</td>
          <td>${r.deleteAt}</td>
          <td>${r.hotel.hotelName}</td>
          <td>${r.hotel.address }</td>
          <td>${r.hotel.city }</td>
          <td>${r.hotel.phone }</td>
          <td><a class="cmn-btn" href="edit-room?id=${r.roomId}">Edit</a>
            <a class="cmn-btn" href="deleteroom?id=${r.roomId}">Delete</a></td>
        </tr>
      </c:forEach>
    </table>

  </div>
</section>

