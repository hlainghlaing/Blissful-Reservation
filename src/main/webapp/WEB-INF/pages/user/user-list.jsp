<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<section class="list-tb">
  <div class="cmn-inner">
    <c:if test="${not empty sessionScope.successMessage}">
      <p class="cmn-success-msg">${sessionScope.successMessage}</p>
      <%
      session.removeAttribute("successMessage");
      %>
    </c:if>
    <a class="cmn-btn" href="downloaduserexcel">Download</a>
    <h2>User List Table</h2>
    <div class="ht-table">
      <table border="1">
        <tr>
          <th>No</th>
          <th>Name</th>
          <th>Email</th>
          <th>Phone No</th>
          <th>createdAt</th>
          <th>updatedAt</th>
          <th>deletedAt</th>
          <th>Role</th>
          <th>Actions</th>
        </tr>
        <c:forEach items="${userList}" var="user" varStatus="status">
          <tr>
            <td><fmt:formatNumber value="${user.userId}"
                pattern="0000" /></td>
            <td>${user.userName}</td>
            <td>${user.email}</td>
            <td>${user.phoneNo}</td>
            <td>${user.getFormattedCT()}</td>
            <td>${user.getFormattedUT()}</td>
            <td>${user.getFormattedDT()}</td>
            <td>${user.getRoleType2()}</td>
            <td><a class="cmn-btn"
              href="edit-user?id=${user.userId}">Edit</a> &nbsp;&nbsp; 
              <a class="cmn-btn" href="#"
              onclick="showUserConfirmation(${user.userId})">Delete</a></td>
          </tr>
        </c:forEach>
      </table>
      <div id="confirmationUserModal" class="modal">
        <div class="modal-content">
          <h2>Are you sure you want to delete this user?</h2>
          <a id="deleteUser" class="cmn-btn" href="#">Yes</a>
          <button class="cmn-btn" onclick="hideUserConfirmation()">No</button>
        </div>
      </div>
    </div>
    <p>
      <a class="cmn-btn" href="Register">Register User</a>
    </p>
  </div>
</section>
