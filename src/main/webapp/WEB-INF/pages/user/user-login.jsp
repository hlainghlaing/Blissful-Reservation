<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section>
  <div class="cmn-inner">
    <h2>Login Page</h2>
    <c:if test="${not empty successMessage}">
      <p class="cmn-success-msg">${successMessage}</p>
    </c:if>
    <font color="red"> ${SPRING_SECURITY_LAST_EXCEPTION.message}
    </font>
    <form action="<%=request.getContextPath()%>/Login" method="POST">
      <label for="email">Enter Email:</label> <input type="email"
        id="email" name="email" /><br /> <br /> <label for="password">Enter
        Password:</label> <input type="password" id="password" name="password" />
      <br /> <br /> <input class="cmn-btn" type="submit"
        value="SignIn" /> <input type="hidden"
        name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
    <br /> <br /> <a class="cmn-btn" href="Register">SignUp</a> <br />
    <br /> <a href="forgot-password">forgot your password?</a> <br />
    <br />
  </div>
</section>