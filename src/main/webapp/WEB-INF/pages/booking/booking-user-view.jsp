<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="hh-user-bd">
  <div class="cmn-inner">
    <c:if test="${not empty successMessage}">
      <p class="cmn-success-msg">${successMessage}</p>
    </c:if>
    <c:forEach items="${bookingList}" var="b" varStatus="status">
      <div class="hh-b-list clearfix">
        <div class="booking-list-lblk">
          <h2>${b.room.hotel.hotelName}</h2>
          <p>Address : ${b.room.hotel.address}</p>
          <p class="pc-blk">
            <span>City : ${b.room.hotel.city}</span> <span>
              Phone : ${b.room.hotel.phone}</span>
          </p>
          <p class="b-date">
            <span class="check-in">From : ${b.checkIn}</span> <span class="check-out">To :
              ${b.checkOut}</span>
          </p>
          <p>Room Type : ${b.room.roomType}</p>
          <p>Price For One Room : ${b.room.price}</p>
          <p>Num of Room : ${b.roomNum}</p>
          <p class="b-price">Total Amount : ${b.totalPrice}</p>
        </div>
        <div class="booking-list-rblk">
          <img
            src="${pageContext.request.contextPath}/resources/img/hotel-images/${b.room.hotel.hotelImg}"
            alt="Hotel Image">
        </div>
      </div>
    </c:forEach>
  </div>
</section>