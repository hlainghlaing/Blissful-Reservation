<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<section class="mi-section">


  <div class="cmn-inner clearfix">
    <h2>Update Hotel</h2>
    <div class="left">
      <img
        src="${pageContext.request.contextPath}/resources/img/hotel-images/${hotel.hotelImg}"
        alt="Hotel Image">
    </div>
    <div class="right">
      <form:form action="update-hotel" modelAttribute="hotel"
        method="post" enctype="multipart/form-data">
        <input type="hidden" name="hotelId" value="${hotel.hotelId}" />
        <form:hidden path="hotelImg" readonly="readonly" />
        <table>
          <tr>
            <td><label for="hotelName">Hotel Name:</label></td>
            <td><form:input path="hotelName" /></td>
          </tr>
          <tr>
            <td><label for="rating">Rating:</label></td>
            <td><form:input path="rating" /></td>
          </tr>
          <tr>
            <td><label for="address">Address:</label></td>
            <td><form:input path="address" /></td>
          </tr>
          <tr>
            <td><label for="city">City:</label></td>
            <td><form:input path="city" />
            <td>
          </tr>
          <tr>
            <td><label for="phone">Phone:</label></td>
            <td><form:input path="phone" />
            <td>
          </tr>
          <tr>
            <td><input class="cmn-btn" type="submit" value="Update"
              onclick="showPreviewImage()" /></td>
          </tr>
        </table>
      </form:form>
    </div>
  </div>
</section>