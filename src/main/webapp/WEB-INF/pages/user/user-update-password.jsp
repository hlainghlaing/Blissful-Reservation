<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="mi-section">
  <div class="cmn-inner">
    <form:form action="updateUserPassword" method="post"
      modelAttribute="user">
      <table><tr><td>
      <label for="password">Enter New Password : </label></td><td>
      <form:input path="password" pattern=".{6,}"
        title="Password must be at least 6 characters long." /></td></tr>
      </table>
      <form:hidden path="userId" />
      <form:hidden path="email" />
      <form:hidden path="userName" />
      <form:hidden path="phoneNo" />
      <form:hidden path="createdAt" />
      <form:hidden path="deletedAt" />
      <form:hidden path="roleType" />
      <div class="reg-btn">
        <input class="cmn-btn" type="submit" value="Update">
      </div>
    </form:form>
  </div>
</section>