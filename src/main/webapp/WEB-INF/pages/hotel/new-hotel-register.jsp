<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<section>
  <div class="cmn-inner">
    <h2>Registration New Hotel</h2>
    <c:if test="${not empty errormsg}">
      <p class="cmn-error-msg">${errormsg}</p>
    </c:if>
    <div class="form-container">
      <form:form action="register-hotel" modelAttribute="hotel"
        method="post" enctype="multipart/form-data">
        <label for="name">Name:</label>
        <form:input type="text" path="hotelName" />
        <br>
        <br>

        <label for="rating">Rating:</label>
        <form:input type="number" path="rating" min="1" max="5" />
        <br>
        <br>

        <label for="address">Address:</label>
        <form:input type="text" path="address" />
        <br>
        <br>

        <label for="city">City:</label>
        <form:input type="text" id="city" path="city" />
        <br>
        <br>

        <label for="phoneNumber">Phone Number:</label>
        <form:input type="text" path="phone" />
        <br>
        <br>

        <form:input type="file" id="image" path="file" accept="image/*" />
        <label for="image" class="file-label">Choose File<span
          class="file-name"></span></label>
        <br>
        <br>

        <input class="cmn-btn" type="submit" value="Register">
      </form:form>
    </div>
  </div>
</section>

