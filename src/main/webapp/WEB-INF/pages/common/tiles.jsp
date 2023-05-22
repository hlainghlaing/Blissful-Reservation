<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath()%>/resources/css/reset.css" />
<link rel="stylesheet"
  href="<%=request.getContextPath()%>/resources/css/common.css" />
<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath()%>/resources/css/hotel-list-admin-view.css" />
<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath()%>/resources/css/aboutus.css" />
  <link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath()%>/resources/css/contactus.css" />
</head>
<body>
  <div class="wrapper">
    <tiles:insertAttribute name="header" />
    <div class="main-container">
      <tiles:insertAttribute name="body" />
    </div>
    <footer id="footer">
      <tiles:insertAttribute name="footer" />
    </footer>
  </div>
  <script
    src="<%=request.getContextPath()%>/resources/js/library/jquery-3.6.3.min.js"></script>
  <script
    src="<%=request.getContextPath()%>/resources/js/accoridan.js"></script>
     <script
    src="<%=request.getContextPath()%>/resources/js/list.js"></script>
</body>
</html>