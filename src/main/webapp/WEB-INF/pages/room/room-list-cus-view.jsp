<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section class="view-room">
  <div class="cmn-inner">
    <c:forEach items="${roomList}" var="r" varStatus="status">
      <div class="room-list">
        <p>
          <img alt="Room Image" src="${pageContext.request.contextPath}/resources/img/hotel-images/${r.roomImg}" />
        </p>
        <p>
          <c:out value="${r.roomType}" />
        </p>
        <p>
          <c:out value="${r.avaRoom}" />
        </p>
        <p>
          <c:out value="${r.price}" />
        </p>
        <a href="booking-register?id=${r.roomId}&hotelid=${r.hotelId}">Book Now</a>
      </div>
    </c:forEach>
  </div>
</section>
