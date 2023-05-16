<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="resources/css/rating-star.css">
<section class="hotels">
  <div class=cmn-inner>
    <div>
      <h2>Blissful Reservation</h2>
      <form action="hotelByCityName" method="post">
        <label for="city">Select City :</label>
         <select name="selectedCity">
          <c:forEach items="${cityList}" var="city">
            <option value="${city}" >${city}</option>
          </c:forEach>
        </select> <input type="submit" value="Search">
      </form>
    </div>

    <c:forEach items="${hotelList}" var="h" varStatus="status">
      <div class="hotel-blk">
        <h3>${h.hotelName}</h3>
        <p>
          <img alt="Room Image" src="<%= request.getContextPath()%>/resources/img/${h.hotelImg}">
        </p>
        <p>
          Address :
          <c:out value="${h.address}" />
        </p>
        <p>
          City :
          <c:out value="${h.city}" />
        </p>
        <p>
          Address :
          <c:out value="${h.address}" />
        </p>
        <p class="color">
          Rating:
          <c:forEach var="i" begin="1" end="${h.rating}">
            <img  alt="Room Image" src="<%= request.getContextPath()%>/resources/img/img_rating_star.jpg">
          </c:forEach>
        </p>
        <p>
          Phone No :
          <c:out value="${h.phone}" />
        </p>
        <a href="viewRoomByHotelId?id=${h.hotelId}">View Rooms For Booking</a>
      </div>
    </c:forEach>
  </div>
</section>