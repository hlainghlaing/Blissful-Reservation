<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="first-div">
  <div class="cmn-inner">
    <h2>Update User Information</h2>
    <form:form action="update-user" method="post" modelAttribute="user">
      <div class="user-update-form">
        <form:hidden path="userId" />
        <label for="userName">Name:</label>
        <form:input path="userName" required="required" />
        <br /> <br /> <label for="email">Email:</label>
        <form:input path="email" required="required" />
        <br /> <br /> <label for="password">Password:</label>
        <form:input path="password" required="required" pattern=".{6,}"
          title="Password must be at least 6 characters long." />
        <br /> <br /> <label for="phoneNo">Phone No:</label>
        <form:input path="phoneNo" required="required" />
        <br /> <br />
        <form:hidden path="roleType" />
        <form:hidden path="createdAt" />
        <form:hidden path="updatedAt" />
        <form:hidden path="deletedAt" />
        <input type="submit" value="Update User"><br /> <br />
      </div>
    </form:form>
  </div>
</div>