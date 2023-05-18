<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="booking-user-view">
  <div class="cmn-inner">
    <c:forEach items="${bookingList}" var="b" varStatus="status">
      <div class="booking-list-lblk">
        <h2>${b.room.hotel.hotelName}</h2>
        <div>
          <span>Address : ${b.room.hotel.address}</span> <span>City : ${b.room.hotel.city}</span>
          <span>Hotel Phone : ${b.room.hotel.phone}</span>
        </div>
        <div>
          <span>From : ${b.checkIn}</span> <span>To :
            ${b.checkOut}</span>
        </div>
        <p>Room Type: ${b.room.roomType}</p>
        <p>Price For One Room: ${b.room.price}</p>
        <p>Room Number : ${b.roomNum}</p>
        <p>Total Price : ${b.totalPrice}</p>
      </div>
      <div class="booking-list-rblk">
        <img
          src="${pageContext.request.contextPath}/resources/img/hotel-images/${b.room.hotel.hotelImg}"
          alt="Hotel Image">
      </div>
    </c:forEach>
  </div>
</section>