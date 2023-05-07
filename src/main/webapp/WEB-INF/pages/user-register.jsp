<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
  <div class="cmn-inner">
    <form:form action="save" method="post" modelAttribute="user">
      <div class="user-register-form">
        <label for="userName">Name:</label>
        <form:input path="userName" required="required" />
        <br />
        <br /> <label for="email">Email:</label>
        <form:input path="email" required="required" />
        <br />
        <br /> <label for="password">Password:</label>
        <form:input path="password" required="required" />
        <br />
        <br /> <label for="phoneNo">Phone No:</label>
        <form:input path="phoneNo" required="required" />
        <br />
        <br /> <input type="submit" value="Register"><br />
        <br />
      </div>
    </form:form>
  </div>
</div>