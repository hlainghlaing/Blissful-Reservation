<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<section class="mi-section">
	<div class="cmn-inner">
		<h2>Registration New Hotel</h2>
		<c:if test="${not empty errormsg}">
			<p class="cmn-error-msg">${errormsg}</p>
		</c:if>
		<div class="form-container">

			<form:form action="register-hotel" modelAttribute="hotel"
				method="post" enctype="multipart/form-data">
				<table><tr><td>
					<label for="name">Name:</label></td><td>
					<form:input type="text" path="hotelName" /></td></tr>
					<tr><td>
					<label for="rating">Rating:</label></td><td>
					<form:input type="number" path="rating" min="1" max="5" /></td></tr>
					<tr><td>
					<label for="address">Address:</label></td><td>
					<form:input type="text" path="address" /></td></tr>
					<tr><td>
					<label for="city">City:</label></td><td>
					<form:input type="text" id="city" path="city" /></td></tr>
					<tr><td>
					<label for="phoneNumber">Phone Number:</label></td><td>
					<form:input type="text" path="phone" /></td></tr>
					<tr><td>
					<label for="image" class="file-label">Choose File<span
						class="file-name"></span></label></td><td>
					<form:input type="file" id="image" path="file" accept="image/*" /></td></tr>
					
				<tr><td>					
				<input class="cmn-btn" type="submit" value="Register"></td></tr>
				</table>
			</form:form>
		</div>
	</div>
</section>

