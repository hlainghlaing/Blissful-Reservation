<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="mi-section">
	<div class="cmn-inner clearfix">
		<h2>Booking Form</h2>
		<div class="left">
			<p>Hotel Name : ${hotel.hotelName}</p>
			<p>Hotel Address : ${hotel.address}</p>
			<p>Hotel City : ${hotel.city}</p>
			<p>Hotel Phone : ${hotel.phone}</p>
			<p>
				<img
					src="${pageContext.request.contextPath}/resources/img/hotel-images/${hotel.hotelImg}"
					alt="Hotel Image">
			</p>
			<p>
			<p>Room Type : ${room.roomType}</p>
			<p>Room Price : ${room.price}</p>
			<p>
				<img
					src="${pageContext.request.contextPath}/resources/img/hotel-images/${room.roomImg}"
					alt="Hotel Image">
			</p>
			<p>
		</div>
		<div class="right">
			<form:form action="booking-success" method="post"
				modelAttribute="booking">
        
				<form:hidden path="roomId" />
				<form:hidden path="userId" />
				<form:hidden path="totalPrice" />
				<table><tr><td>
				<label for="roomNum">Number of Room : </label></td><td>
				<form:input type="number" path="roomNum" min="1"
					max="${room.avaRoom}" required="required" /></td></tr>
				<tr><td>
				<label for="checkIn">CheckIn:</label></td><td>
				<form:input type="date" path="checkIn" required="required" /></td></tr>
				<tr><td>
				<label for="checkOut">CheckOut:</label></td><td>
				<form:input type="date" path="checkOut" required="required" /></td></tr>
				<tr><td>
				<label for="nrc">Nrc:</label></td><td>
				<form:input path="nrc" required="required"
					pattern="\d{1,2}/[a-zA-Z]+\([a-zA-Z]\)\d{6}"
					title="Please enter a valid Myanmar NRC number! like 12/ThaKaNa(N)345678'" /></td></tr>
				<tr><td>
				<input class="cmn-btn" type="submit" value="Register"></td></tr>
				</table>
			</form:form>
		</div>
	</div>
</section>