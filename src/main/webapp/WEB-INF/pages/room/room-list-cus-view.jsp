<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section class="view-room">
  <div class="cmn-inner">
    <c:forEach items="${roomList}" var="r" varStatus="status">
      <div class="room-list">
        <p>
          <img alt="Single Room Image" src="${r.roomImg}" />
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
        <a href="booking-register?id=${r.roomId}">Book Now</a>
      </div>
    </c:forEach>
    <a href="booking-register">Book Now</a>
  </div>
</section>
