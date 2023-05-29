<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="mi-section">
  <div class="cmn-inner clearfix">
    <h2>Edit Room</h2>
    <div class="left">
      <img
        src="${pageContext.request.contextPath}/resources/img/hotel-images/${room.roomImg}"
        alt="Hotel Image" id="previewImage">
    </div>
    <div class="right">
      <form:form method="POST" action="editsaveRoom"
        modelAttribute="room" enctype="multipart/form-data">
        <form:hidden path="roomId" />
        <form:hidden path="hotelId" />
        <form:hidden path="createdAt" />
        <form:hidden path="deleteAt" />
        <form:hidden path="updatedAt" />
        <form:hidden path="roomImg" value="${room.roomImg}"
          readonly="readonly" />
        <table>
          <tr>
            <td>Room Type :</td>
            <td><form:input path="roomType" /></td>
          </tr>
          <tr>
            <td>Total room :</td>
            <td><form:input path="totalRoom" /></td>
          </tr>
          <tr>
            <td><form:hidden path="avaRoom" /></td>
          </tr>
          <tr>
            <td>Price :</td>
            <td><form:input path="price" /></td>
          </tr>
          <tr>
            <td><label for="image">Image:</label></td>
            <td><input type="file" name="image" id="image"
              onchange="showPreviewImage(this)" accept="image/*" /></td>
          </tr>
          <tr>
            <td><input class="cmn-btn" type="submit" value="Save"/></td>
          </tr>
        </table>
      </form:form>
    </div>
  </div>
</section>