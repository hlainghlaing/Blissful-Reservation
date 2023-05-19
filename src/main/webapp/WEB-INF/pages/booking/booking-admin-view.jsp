<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="booking-admin-view">
  <div class="cmn-inner clearfix">
    <c:if test="${not empty successMessage}">
      <p class="cmn-success-msg">${successMessage}</p>
    </c:if>
    <c:forEach items="${bookingList}" var="b" varStatus="loop">
      <c:if test="${loop.index % 2 != 0}">
        <div class="booking-list">
          <h2>${b.room.hotel.hotelName}</h2>
          <div>
            <span>Address : ${b.room.hotel.address}</span> <span>City
              : ${b.room.hotel.city}</span> <span>Hotel Phone :
              ${b.room.hotel.phone}</span>
          </div>
          <div>
            <span>Customer Name : ${b.user.userName}</span> <span>Nrc
              : ${b.nrc}</span> <span>Customer Phone : ${b.user.phoneNo}</span>
          </div>
          <div>
            <span>From : ${b.checkIn}</span> <span>To :
              ${b.checkOut}</span>
          </div>
          <p>Room Type: ${b.room.roomType}</p>
          <p>Price For One Room: ${b.room.price}</p>
          <p>Room Number : ${b.roomNum}</p>
          <p>Total Price : ${b.totalPrice}</p>
          <p>Status : ${b.getStatusName()}</p>
          <p>
            <a class="cmn-btn" href="accept?id=${b.bookingId}">Accept</a><a
              class="cmn-btn" href="reject?id=${b.bookingId}">Reject</a>
          </p>
        </div>
      </c:if>
    </c:forEach>
  </div>
</section>
