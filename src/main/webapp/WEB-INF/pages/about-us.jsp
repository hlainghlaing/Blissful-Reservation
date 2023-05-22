<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<body>
  <section class="header">
    <h2>Header</h2>
  </section>
  <section class="ht-main-sec">
    <h1>Blissful Reservation</h1>
    <p>We would like to express our sincere gratitude to each and
      every customer who has chosen BLissful Reservation for their hotel
      reservations. We understand that you have a multitude of options
      available, and we are honored that you have placed your trust in
      us. Your support has been instrumental in our growth and success,
      and we are committed to continuously exceeding your expectations.</p>
  </section>
  <section class="ht-cmn-sec clearfix">
    <div class="cmn-inner">
      <div class="fl-left">
        <img src="${pageContext.request.contextPath}/resources/img/img_aboutus_left.jpg" alt="For you">
      </div>
      <div class="fl-right">
        <div class="txt-blk">
          <h2>For You</h2>
          <p class="ht-cmn-p">At Blissful Reservation, we strive to
            provide an exceptional hotel booking experience that is
            convenient, reliable, and user-friendly. We are passionate
            about helping you find the perfect accommodations for your
            travels, whether it's for business, leisure, or any other
            purpose. Your satisfaction is our utmost priority, and we
            are dedicated to delivering the highest level of service to
            ensure your comfort and peace of mind.</p>
          <button class="cmn-btn">
            <a href="searchform">View Hotels</a>
          </button>
        </div>
      </div>
  </div>
  </section>
  <section class="ht-cmn-sec clearfix">
    <div class="cmn-inner">
      <div class="fl-left">
        <div class="txt-blk">
          <h2>We Value Your Feedback</h2>
          <p class="ht-cmn-p">We value your feedback and take it to
            heart as we continuously improve our platform. Your
            comments, suggestions, and reviews have helped shape our
            website and have driven us to implement new features and
            enhancements to better serve you. We are committed to
            listening to your needs and providing you with an intuitive
            and seamless booking process.We are proud to have served
            thousands of customers like you.</p>
          <button class="cmn-btn">
            <a href="ContactUsPage">Contact Us</a>
          </button>
        </div>
      </div>
      <div class="fl-right">
        <img src="${pageContext.request.contextPath}/resources/img/img_aboutus_right.jpg"  alt="We vlaue your feedback"/>
      </div>
    </div>
  </section>
  <section class="ht-developer-sec">
    <div class="cmn-inner clearfix">
      <h2>Meet Our Developers</h2>
      <p class="ht-cmn-p">At our hotel, we have a team of skilled
        and dedicated developers who work tirelessly to ensure a
        seamless and user-friendly experience for our online booking
        platform. Let us introduce you to the talented individuals
        behind the scenes who bring our website to life.</p>
      <div class="develop-card">
        <img src="${pageContext.request.contextPath}/resources/img/img_hlaing.jpg" alt="Khin Yadanar Hlaing">
        <p>Khin Yadanar Hlaing</p>
      </div>
      <div class="develop-card">
        <img src="${pageContext.request.contextPath}/resources/img/img_mi.jpg" alt="Mi Mi Soe">
        <p>Mi Mi Soe</p>
      </div>
      <div class="develop-card">
        <img src="${pageContext.request.contextPath}/resources/img/img_hnaung.jpg" alt="Hnaung Thet Htar Wai">
        <p>Hnaung Thet Htar Wai</p>
      </div>
    </div>
  </section>