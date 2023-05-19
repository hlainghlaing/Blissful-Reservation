<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<section>
  <div class="cmn-inner">
    <c:if test="${not empty errormsg}">
      <div class="cmn-error-msg">${errormsg}</div>
    </c:if>
    <form:form action="editpassword" method="post"
      modelAttribute="email">
      <label for="email">Enter Your Email:</label>
      <input type="email" id="email" name="email" required="required" />
      <br>
      <br>
      <input class="cmn-btn" type="submit" value="Submit">
    </form:form>
  </div>
</section>