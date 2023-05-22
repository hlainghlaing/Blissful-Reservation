<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="mi-section">
  <div class="cmn-inner">
    <c:if test="${not empty errormsg}">
      <div class="cmn-error-msg">${errormsg}</div>
    </c:if>
    <form:form action="save" method="post" modelAttribute="user">
      <table>
        <tr>
          <td><label for="userName">Name:</label></td>
          <td><form:input path="userName" required="required" /></td>
        </tr>
        <tr>
          <td><label for="email">Email:</label></td>
          <td><form:input path="email" required="required" /></td>
        </tr>
        <tr>
          <td><label for="password">Password:</label></td>
          <td><form:input path="password" required="required"
              pattern=".{6,}"
              title="Password must be at least 6 characters long." /></td>
        </tr>
        <tr>
          <td><label for="phoneNo">Phone No:</label></td>
          <td><form:input path="phoneNo" required="required" /></td>
        </tr>
        <tr>
          <td><input class="cmn-btn" type="submit" value="Register"></td>
        </tr>
      </table>
    </form:form>
  </div>
</section>