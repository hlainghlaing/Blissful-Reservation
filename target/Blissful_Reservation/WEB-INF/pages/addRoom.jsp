<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="first-div">
  <div class="cmn-inner">
    <h2>Add New Room</h2>
    <form:form action="saveroom" method="post" modelAttribute="room">
      <div class="input-form">
        <div class="clearfix">
          <span>Room Type:</span>
          <form:input path="roomType" />
        </div> 
        <div class="clearfix">
          <span>Room Price:</span>
          <form:input path="price" />
        </div>
        <div class="clearfix">
          <span>Total Room:</span>
          <form:input path="totalRoom" />
        </div>
        <div class="clearfix">
          <span>Room Image:</span>
          <form:input type="file" path="roomImg" />
        </div>
        <div>
          <input type="submit" value="Save">
        </div>
      </div>
    </form:form>
  </div>
</div>