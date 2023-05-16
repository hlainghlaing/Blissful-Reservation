<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form:form action="updateUserPassword" method="post"
  modelAttribute="user">
  <label for="password">Enter New Password : </label>
  <br>
  <br>
  <form:input path="password" pattern=".{6,}"
    title="Password must be at least 6 characters long." />
  <form:hidden path="userId" />
  <form:hidden path="email" />
  <form:hidden path="userName" />
  <form:hidden path="phoneNo" />
  <form:hidden path="createdAt" />
  <form:hidden path="deletedAt" />
  <form:hidden path="roleType" />
  <div>
    <input type="submit" value="Update">
  </div>
</form:form>
