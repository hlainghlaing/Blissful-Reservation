<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="hh-home">
  <ul class="home-slider">
    <li class="home-img-list"><img
      src="<%=request.getContextPath()%>/resources/img/common-img/img_slide_img7.jpg"
      alt="Home Slider Images"></li>
    <li class="home-img-list"><img
      src="<%=request.getContextPath()%>/resources/img/common-img/img_slide_img2.jpg"
      alt="Home Slider Images"></li>
    <li class="home-img-list"><img
      src="<%=request.getContextPath()%>/resources/img/common-img/img_slide_img3.jpg"
      alt="Home Slider Images"></li>
    <li class="home-img-list"><img
      src="<%=request.getContextPath()%>/resources/img/common-img/img_slide_img6.jpg"
      alt="Home Slider Images"></li>
    <li class="home-img-list"><img
      src="<%=request.getContextPath()%>/resources/img/common-img/img_slide_img5.jpg"
      alt="Home Slider Images"></li>
    <li class="home-img-list"><img
      src="<%=request.getContextPath()%>/resources/img/common-img/img_slide_img4.jpg"
      alt="Home Slider Images"></li>
    <li class="home-img-list"><img
      src="<%=request.getContextPath()%>/resources/img/common-img/img_slide_img1.jpg"
      alt="Home Slider Images"></li>
  </ul>
  <div class="main-txt-blk">
    <h2>Enjoy Your Dream Vacation</h2>
  </div>
</section>
<section class="hh-home-hotel">
  <div class="cmn-inner">
    <div class="home-txt clearfix">
      <h2>Most Popular</h2>
      <a href="searchform">Go to Hotels</a>
    </div>
    <ul class="clearfix">
      <c:forEach items="${hotelList}" var="h" begin="0" end="11">
        <li><img
          src="${pageContext.request.contextPath}/resources/img/hotel-images/${h.hotelImg}"
          alt="Hotel Image">
          <div class="hh-b-txt">
            <h3>${h.hotelName}</h3>
            <P class="hh-h-address">${h.address}</P>
            <P class="hh-h-city">${h.city}</P>
            <a class="cmn-btn" href="viewRoomByHotelId?id=${h.hotelId}">View
              Rooms</a>
          </div></li>
      </c:forEach>
    </ul>
  </div>
</section>
