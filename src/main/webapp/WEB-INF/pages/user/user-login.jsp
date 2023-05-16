<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Login Page</h1>
<p>${successMessage}</p>
<font color="red"> ${SPRING_SECURITY_LAST_EXCEPTION.message} </font>
<form action="<%=request.getContextPath()%>/Login" method="POST">
  <label for="email">Enter Email:</label> <input type="email" id="email" name="email" /><br /> <br />
  <label for="password">Enter Password:</label> <input type="password" id="password" name="password" /> <br /> <br />
  <input type="submit" value="SignIn" /> <input type="hidden"
      name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<br />
<br />
<a href="Register">SignUp</a>
<br />
<br />
<a href="forgot-password">forgot your password?</a>
<br />
<br />