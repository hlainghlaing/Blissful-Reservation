<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section>
  <div class="cmn-inner">
    <form:form action="save" method="post" modelAttribute="booking">
      <div class="booking-register-form">
        <form:hidden path="roomId"/>
        <label for="hotelName"> Hotel Name:</label>
        <form:input path="hotelName" readonly />
        <br /> <br /> <label for="email">Room Type:</label>
        <form:input path="roomType" readonly />
        <br /> <br /> <label for="avaRoom">Available Room:</label>
        <form:input path="avaRoom" readonly/>
        <br /> <br /> <label for="price">Price :</label>
        <form:input path="price" readonly />
        <br /> <br /> <label for="roomNum">Number of Room:</label>
        <form:input path="roomNum" required="required" />
        <br /> <br /> <label for="checkIn">CheckIn:</label>
        <form:input type="date" path="checkIn" required="required" />
        <br /> <br /> <label for="checkOut">Phone No:</label>
        <form:input type="date" path="checkOut" required="required" />
        <br /> <br /><label for="nrc">Phone No:</label>
        <form:input  path="nrc" required="required" pattern="\d{1,2}/[a-zA-Z]+\([a-zA-Z]\)\d{6}" title="Please enter a valid Myanmar NRC number! like 12/ThaKaNa(N)345678'" />
        <br /> <br /><input type="submit" value="Register"><br />
        <br />
      </div>
    </form:form>
  </div>
</section>