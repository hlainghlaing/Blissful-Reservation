<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="hh-b-admin-view">
  <div class="cmn-inner">
    <c:if test="${not empty successMessage}">
      <p class="cmn-success-msg">${successMessage}</p>
    </c:if>
    <c:forEach items="${bookingList}" var="b" varStatus="loop">
      <c:if test="${loop.index % 2 != 0}">
        <div class="b-admin-list">
          <h2>${b.room.hotel.hotelName}</h2>
          <p>
            <span>Address : ${b.room.hotel.address}</span> <span>&nbsp;&nbsp;&nbsp;
              City : ${b.room.hotel.city}</span> <span>&nbsp;&nbsp;&nbsp;
              Phone : ${b.room.hotel.phone}</span>
          </p>
          <p>
            <span>Customer Name : ${b.user.userName}</span> <span>
              &nbsp;&nbsp;&nbsp; Nrc : ${b.nrc}</span> <span>&nbsp;&nbsp;&nbsp;
              Customer Phone : ${b.user.phoneNo}</span>
          </p>
          <p class="b-date">
            <span class="check-in">From : ${b.checkIn}</span> <span
              class="check-out">To : ${b.checkOut}</span>
          </p>
          <p>Room Type: ${b.room.roomType}</p>
          <p>Price For One Room: ${b.room.price}</p>
          <p>Room Number : ${b.roomNum}</p>
          <p>Total Price : ${b.totalPrice}</p>
          <div class="b-status clearfix">
            <p class="status-lblk">Status : ${b.getStatusName()}</p>
            <p class="status-rblk">
              <a class="cmn-btn"
                href="accept?id=${b.bookingId}&email=${b.user.email}">Accept</a>
              <%-- <a
                class="cmn-btn" href="reject?id=${b.bookingId}" onclick="return confirmReject()" >Reject</a>--%>
              <a class="cmn-btn" href="#"
                onclick="showBookingConfirmation(${b.bookingId})">Reject</a>
            </p>
          </div>
        </div>
      </c:if>
    </c:forEach>
  </div>
  <div id="confirmationBookingModal" class="modal">
    <div class="modal-content">
      <h2>Are you sure you want to delete this booking?</h2>
      <a id="reject" class="cmn-btn" href="#">Yes</a>
      <button class="cmn-btn" onclick="hideBookingConfirmation()">No</button>
    </div>
  </div>
</section>


