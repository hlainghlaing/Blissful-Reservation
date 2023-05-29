<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section class="mi-section">
  <div class="cmn-inner clearfix b-register">
    <h2>New Room Registration Form</h2>
    <div class="left">
      <h3>Hotel Information:</h3>
      <p>Name: ${hotel.hotelName}</p>
      <p>Address: ${hotel.address}</p>
      <p>City: ${hotel.city}</p>
      <p>Phone: ${hotel.phone}</p>
      <p>Rating: ${hotel.rating}</p>

    </div>
    <div class="right">
      <form:form action="saveroom" method="post" modelAttribute="room"
        enctype="multipart/form-data">
        <form:errors path="*" cssClass="errorblock" element="div">
          <div class="errorblock">
            <spring:message code="defaultError" />
          </div>
        </form:errors>
        <div class="input-form">
          <form:hidden path="hotelId" />
          <table>
            <tr>
              <td><span>Room Type:</span></td>
              <td><form:input path="roomType" /></td>
              <td><form:errors path="roomType" cssClass="error" /></td>
            </tr>
            <tr>
              <td><span>Room Price:</span></td>
              <td><form:input type="number" path="price" /></td>
              <td><form:errors path="price" cssClass="error" /></td>
            </tr>
            <tr>
              <td><span>Total Room:</span></td>
              <td><form:input type="number" path="totalRoom" /></td>
              <td><form:errors path="totalRoom" cssClass="error" /></td>
            </tr>
            <tr>
              <td colspan="2"><form:input type="file" id="image"
                  path="file" accept="image/*" /></td>
              <td><form:errors path="file" cssClass="error" /></td>
            </tr>
          </table>
          <div>
            <input class="cmn-btn" type="submit" value="Save">
          </div>
        </div>
      </form:form>
    </div>
  </div>
</section>