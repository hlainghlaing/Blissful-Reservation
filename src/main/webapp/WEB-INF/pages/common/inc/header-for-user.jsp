<header class="cmn-header">
  <div class="cmn-inner clearfix">
    <h1>
      <a href="userdashboard">Blissful Reservation</a>
    </h1>
    <nav class="g-nav clearfix">
      <ul class="user-nav-list clearfix">
        <li><a href="userdashboard">Home</a></li>
        <li><a href="searchform">Hotels</a></li>
        <li><a href="booking-list">Booking Detail</a></li>
        <li><a href="AboutUsPage">AboutUs</a></li>
        <li><a href="ContactUsPage">ContactUs</a></li>
      </ul>
      <form action="<%=request.getContextPath()%>/logout" method="POST">
        <input type="submit" value="Logout" class="cmn-btn header-btn" /> <input type="hidden"
          name="${_csrf.parameterName}" value="${_csrf.token}" />
      </form>
    </nav>
       <div class="menu-toggle">
      <span></span> <span></span> <span></span>
    </div>
  </div>
</header>
<!--/.cmn-header-->