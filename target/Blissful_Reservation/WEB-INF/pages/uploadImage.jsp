<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Save Image</title>
</head>
<body>
	<h1>Save Image</h1>
	<form action="saveImage" method="post" enctype="multipart/form-data">
		<label for="file">Choose an image to upload:</label>
		<input type="file" name="file" accept="image/*" required><br>
		<input type="submit" value="Upload">
	</form>
</body>
</html>