<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<section>
  <div class=cmn-inner>
    <h3>User List Table</h3>
    <table border="1">
      <tr>
        <th>No</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Phone No</th>
        <th>createdAt</th>
        <th>updatedAt</th>
        <th>deletedAt</th>
        <th>Role</th>
        <th>Actions</th>
      </tr>
      <c:forEach items="${userList}" var="user" varStatus="status">
        <tr>
          <td><fmt:formatNumber value="${user.userId}" pattern="0000"/></td>
          <td>${user.userName}</td>
          <td>${user.email}</td>
          <td>${user.password}</td>
          <td>${user.phoneNo}</td>
          <td>${user.createdAt}</td>
          <td>${user.updatedAt}</td>
          <td>${user.deletedAt}</td>
          <td>${user.roleType}</td>
          <td><a href="edit-user?id=${user.userId}">Edit</a> &nbsp;&nbsp; <a
            href="delete?id=${user.userId}"> Delete</a></td>
        </tr>
      </c:forEach>
    </table>
    <p>
      <a href="Register">Register User</a>
    </p>
  </div>
</section>