<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="mi-section">
  <div class="cmn-inner clearfix">
    <h2>New Room Registration Form</h2>
    <div class="left">
    <h3>Hotel Information:</h3>
    <p> Name: ${hotel.hotelName}</p>
    <p> Address: ${hotel.address}</p>
    <p> City: ${hotel.city}</p>
    <p>Phone: ${hotel.phone}</p>
    <p>Rating: ${hotel.rating}</p>
    </div>
    <div class="right">
    <form:form action="saveroom" method="post" modelAttribute="room"
      enctype="multipart/form-data">
      <div class="input-form">
      <form:hidden path="hotelId" />
      <table><tr><td>
        <span>Room Type:</span></td><td>
        <form:input path="roomType" /></td></tr>
        <tr><td><span>Room Price:</span></td><td>
        <form:input type="number" path="price" /></td></tr>
        <tr><td> <span>Total Room:</span></td><td>
        <form:input type="number" path="totalRoom" /></td></tr>
         <tr><td><span>Room Image:</span></td><td>
        <form:input type="file" id="image" path="file" accept="image/*" />
        </td></tr>
        </table>
        <div>
          <input class="cmn-btn" type="submit" value="Save">
        </div>
      </div>
    </form:form>
    </div>
  </div>
</section>