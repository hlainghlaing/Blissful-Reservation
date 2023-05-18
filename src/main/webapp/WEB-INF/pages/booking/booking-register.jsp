<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section>
  <div class="cmn-inner">
    <h2>Booking Form</h2>
    <div>
      <p>Hotel Name: ${hotel.hotelName}</p>
      <p>Hotel Address: ${hotel.address}</p>
      <p>Hotel City: ${hotel.city}</p>
      <p>Hotel Phone: ${hotel.phone}</p>
      <p>
        <img
          src="${pageContext.request.contextPath}/resources/img/hotel-images/${hotel.hotelImg}"
          alt="Hotel Image">
      </p>
      <p>
      <p>Room Type : ${room.roomType}</p>
      <p>Room Price: ${room.price}</p>
      <p><img
          src="${pageContext.request.contextPath}/resources/img/hotel-images/${room.roomImg}"
          alt="Hotel Image" ></p>
        <p>
    </div>
    <form:form action="booking-success" method="post" modelAttribute="booking">
      <div class="booking-register-form">
        <form:hidden path="roomId" />
        <form:hidden path="userId" />
        <br /> <br /> <label for="roomNum">Number of Room:</label>
        <form:input type="number" path="roomNum" min="1" max="${room.avaRoom}"
          required="required" />
        <br /> <br /> <label for="checkIn">CheckIn:</label>
        <form:input type="date" path="checkIn" required="required" />
        <br /> <br /> <label for="checkOut">CheckOut:</label>
        <form:input type="date" path="checkOut" required="required" />
        <br /> <br /> 
        <form:hidden path="totalPrice" />
        <label for="nrc">Nrc:</label>
        <form:input path="nrc" required="required"
          pattern="\d{1,2}/[a-zA-Z]+\([a-zA-Z]\)\d{6}"
          title="Please enter a valid Myanmar NRC number! like 12/ThaKaNa(N)345678'" />
        <br /> <br /> <input type="submit" value="Register"><br />
        <br />
      </div>
    </form:form>
  </div>
</section>