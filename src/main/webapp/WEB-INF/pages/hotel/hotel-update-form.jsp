<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<section>
  <div class="cmn-inner">
    <h2>Update Hotel</h2>

    <form:form action="update-hotel" modelAttribute="hotel"
      method="post" enctype="multipart/form-data">

      <input type="hidden" name="hotelId" value="${hotel.hotelId}" />

      <div>
        <h3>Original Image</h3>
        <img
          src="${pageContext.request.contextPath}/resources/img/hotel-images/${hotel.hotelImg}"
          alt="Hotel Image" >
      </div>
      <br>
      <br>

      <div>
        <label for="hotelName">Hotel Name:</label>
        <form:input path="hotelName" />
      </div>
      <br>
      <br>

      <div>
        <label for="rating">Rating:</label>
        <form:input path="rating" />
      </div>
      <br>
      <br>

      <div>
        <label for="address">Address:</label>
        <form:input path="address" />
      </div>
      <br>
      <br>

      <div>
        <label for="city">City:</label>
        <form:input path="city" />
      </div>
      <br>
      <br>

      <div>
        <label for="phone">Phone:</label>
        <form:input path="phone" />
      </div>
      <br>
      <br>


      <div>
        <label for="hotelImg">Hotel Image:</label>
        <form:input path="hotelImg" readonly="readonly" />
      </div>
      <br>
      <br>


      <div>
        <input class="cmn-btn" type="submit" value="Update" onclick="showPreviewImage()" />
      </div>
    </form:form>
  </div>
</section>