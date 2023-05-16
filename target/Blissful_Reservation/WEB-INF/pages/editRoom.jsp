<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Room</h1>
	<form:form method="POST" action="editsaveRoom" modelAttribute="room">
	<img path="roomImg"
							src="<%= request.getContextPath()%>/resources/img/${room.roomImg}"
							alt="selected image" />
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="roomId" /></td>
			</tr>
			<tr>
				<td><form:hidden path="hotelId" /></td>
			</tr>
			<tr>
				<td><form:hidden path="createdAt" /></td>
			</tr>
			<tr>
				<td><form:hidden path="deleteAt" /></td>
			</tr>
			<tr>
				<td><form:hidden path="updatedAt" /></td>
			</tr>
			<tr>
				<td>Room Type :</td>
				<td><form:input path="roomType" /></td>
			</tr>
			<tr>
				<td>Total room :</td>
				<td><form:input path="totalRoom" /></td>
			</tr>
			<tr>
				<td>Availabel room :</td>
				<td><form:input path="avaRoom" /></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td>Image :</td>



				<td><form:input type='file' path="roomImg"/> 
						<div><img id="previewImage" src"#" alt="Preview"  style="display:none;"/></div>
					</form></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>