<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="hh-cus-room">
  <div class="cmn-inner">
    <h2>"Exquisite Retreat: Unparalleled Elegance and Comfort in
      Every Detail"</h2>
    <div class="clearfix">
      <c:forEach items="${roomList}" var="r" varStatus="status">
        <div class="hh-room-list">
          <img alt="Room Image"
            src="${pageContext.request.contextPath}/resources/img/hotel-images/${r.roomImg}" />
          <div class="hh-r-txt-blk">
            <h3>
              <c:out value="${r.roomType}" />
            </h3>
            <p>
              <label>Available Room : </label>
              <c:out value="${r.avaRoom}" />
            </p>
            <p>
              <label>Price : </label>
              <c:out value="${r.price}" />
            </p>
            <p class="icon-blk">
              <span class="f-icon">Beds</span> <span class="s-icon">AC</span>
              <span class="t-icon">Wifi</span> <span class="fo-icon">TV</span>
            </p>
            <a class="cmn-btn"
              href="booking-register?id=${r.roomId}&hotelid=${r.hotelId}">Book
              Now</a>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</section>
