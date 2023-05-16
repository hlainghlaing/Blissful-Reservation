<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="editpassword" method="post" modelAttribute="email">
  <label for="email">Enter Your Email:</label>
  <input type="email" id="email" name="email" required="required" />
  <c:if test="${not empty errormsg}">
    <div style="color: red">${errormsg}</div>
  </c:if>
  <br>
  <br>
  <input type="submit" value="Submit">
</form:form>
