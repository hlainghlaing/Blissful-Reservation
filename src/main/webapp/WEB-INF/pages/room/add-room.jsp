<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="first-div">
  <div class="cmn-inner">
    <h2>Add New Room</h2>
    <h3>Hotel Information:</h3>
    <p>Hotel Name: ${hotel.hotelName}</p>
    <p>Hotel Address: ${hotel.address}</p>
    <p>Hotel City: ${hotel.city}</p>
    <p>Hotel Phone: ${hotel.phone}</p>
    <p>Hotel Rating: ${hotel.rating}</p>
    <form:form action="saveroom" method="post" modelAttribute="room"
      enctype="multipart/form-data">
      <div class="input-form">
        <form:hidden path="hotelId" />
        <span>Room Type:</span>
        <form:input path="roomType" />
        <br> <br> <span>Room Price:</span>
        <form:input type="number" path="price" />
        <br> <br> <span>Total Room:</span>
        <form:input type="number" path="totalRoom" />
        <br> <br> <span>Room Image:</span>
        <form:input type="file" id="image" path="file" accept="image/*" />
        <label for="image" class="file-label">Choose File<span
          class="file-name"></span></label> <br> <br>
        <div>
          <input type="submit" value="Save">
        </div>
      </div>
    </form:form>
  </div>
</div>