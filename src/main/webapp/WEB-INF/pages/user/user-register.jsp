<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section>
  <div class="cmn-inner">
    <c:if test="${not empty errormsg}">
      <div style="color: red">${errormsg}</div>
    </c:if>
    <form:form action="save" method="post" modelAttribute="user">
      <div class="user-register-form">
        <label for="userName">Name:</label>
        <form:input path="userName" required="required" />
        <br /> <br /> <label for="email">Email:</label>
        <form:input path="email" required="required" />
        <br /> <br /> <label for="password">Password:</label>
        <form:input path="password" required="required" pattern=".{6,}"
          title="Password must be at least 6 characters long." />
        <br /> <br /> <label for="phoneNo">Phone No:</label>
        <form:input path="phoneNo" required="required" />
        <br /> <br /> <input type="submit" value="Register"><br />
        <br />
      </div>
    </form:form>
  </div>
</section>