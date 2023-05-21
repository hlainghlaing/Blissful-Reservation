<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="mi-section">
	<div class="cmn-inner">
		<h2>Login Page</h2>
		<c:if test="${not empty successMessage}">
			<p class="cmn-success-msg">${successMessage}</p>
		</c:if>
		<font color="red"> ${SPRING_SECURITY_LAST_EXCEPTION.message} </font>
		<form action="<%=request.getContextPath()%>/Login" method="POST">
			<table><tr><td>
					<label  for="email">Enter Email:</label></td><td> <input
						 type="email" id="email" name="email" /></td></tr>
			        <tr><td>
					<label  for="password">Enter Password:</label></td><td> <input
						type="password" id="password" name="password" /></td></tr>
			<tr><td>
			<a href="forgot-password">forgot your password?</a> <td></tr>
			<tr><td>	<input class="cmn-btn" type="submit" value="SignIn" /> <input
					type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /></td></tr>
			</table>
		</form>
		<div class="reg-btn">
		 <a class="cmn-btn reg-btn" href="Register">SignUp</a>
		 </div> 
	</div>
</section>
