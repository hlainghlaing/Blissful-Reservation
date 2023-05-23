<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="mi-section">
  <div class="cmn-inner">
    <h2>Are you ready to send Email</h2>
    <form:form action="mail" method="post">
      <table>
        <tr>
          <td><label for="email">Email:</label></td>
          <td><input type="email" id="email" name="email"
            value="<%=request.getParameter("email")%>" readonly></td>
        </tr>
        <tr>
          <td><input type="submit" value="Send Email"></td>
        </tr>
      </table>
    </form:form>
  </div>
</section>