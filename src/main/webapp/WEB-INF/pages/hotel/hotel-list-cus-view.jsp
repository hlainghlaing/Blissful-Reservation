<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section class="hotels">
  <div class=cmn-inner>
    <div>
      <h2>Blissful Reservation</h2>
      <form action="/choose-city">
        <label for="city">Select City :</label> <select name="city"
          id="city">
          <c:forEach items="${cityList}" var="city">
            <option value="city">${city}</option>
          </c:forEach>
        </select> <input type="submit" value="Search">
      </form>
    </div>

    <c:forEach items="${hotelList}" var="h" varStatus="status">
      <div class="hotel-blk">
        <h3>${h.hotelName}</h3>
        <p>
          <img alt="Hotel Image" src="${h.hotelImg}" />
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
        <p>
          Rating:
          <c:forEach var="i" begin="1" end="${h.rating}">
            <img src="img_star.png" alt="Rating Star Image" />
          </c:forEach>
        </p>
        <p>
          Phone No :
          <c:out value="${h.phoneNo}" />
        </p>
        <a href="view-room?id=${h.hotelId}">View Rooms For Booking</a>
      </div>
    </c:forEach>
    <a href="view-room">View Rooms For Booking</a>
  </div>
</section>