<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<section class="mi-section">
  <div class="cmn-inner">
    <c:if test="${not empty errormsg}">
      <div class="cmn-error-msg">${errormsg}</div>
    </c:if>
    <form:form action="editpassword" method="post"
      modelAttribute="email">
      <table><tr><td>
      <label for="email">Enter Your Email:</label></td><td>
      <input type="email" id="email" name="email" required="required" /></td></tr>
      <tr><td>
      <input class="cmn-btn" type="submit" value="Submit"></td></tr>
      </table>
    </form:form>
  </div>
</section>