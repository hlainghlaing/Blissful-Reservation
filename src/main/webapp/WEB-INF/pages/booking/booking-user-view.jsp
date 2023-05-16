<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="booking-admin-view">
  <div class="cmn-inner">
    <c:forEach items="${bookingList}" var="b" varStatus="status">
      <div class="booking-list">
        <h2>${b.hotelName}</h2>
        <span>Hotel Address : ${b.address}</span>
        <span>${b.city}</span>
        <span>From : ${b.checkIn}</span>
        <span>To : ${b.checkOut}</span>
        <span>${b.roomType}</span>
        <span>${b.roomNum}</span>
        <span>${b.totalPrice}</span>
      </div>
    </c:forEach>
  </div>
</section>
Hello From Booking user view 