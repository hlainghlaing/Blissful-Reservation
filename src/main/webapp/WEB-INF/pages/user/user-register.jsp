<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section class="mi-section">
  <div class="cmn-inner">
    <c:if test="${not empty errormsg}">
      <div class="cmn-error-msg">${errormsg}</div>
    </c:if>
    <h2>User Registration Form</h2>
    <form:form action="save" method="post" modelAttribute="user">
      <form:errors path="*" cssClass="errorblock" element="div">
        <div class="errorblock">
          <spring:message code="defaultError" />
        </div>
      </form:errors>
      <table>
        <tr>
          <td><label for="userName">Name:</label></td>
          <td><form:input path="userName" /></td>
          <td><form:errors path="userName" cssClass="error" /></td>
        </tr>
        <tr>
          <td><label for="email">Email:</label></td>
          <td><form:input path="email" type="email" /></td>
          <td><form:errors path="email" cssClass="error" /></td>
        </tr>
        <tr>
          <td><label for="password">Password:</label></td>
          <td><form:input path="password" /></td>
          <td><form:errors path="password" cssClass="error" /></td>
        </tr>
        <tr>
          <td><label for="phoneNo">Phone No:</label></td>
          <td><form:input path="phoneNo" /></td>
          <td><form:errors path="phoneNo" cssClass="error" /></td>
        </tr>
        <tr>
          <td><input class="cmn-btn" type="submit" value="Register"></td>
        </tr>
      </table>
    </form:form>
  </div>
</section>