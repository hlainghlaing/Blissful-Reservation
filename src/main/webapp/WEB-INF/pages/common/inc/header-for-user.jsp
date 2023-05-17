<header class="cmn-header">
  <div class="cmn-inner clearfix">
    <h1>
      <a href="userdashboard">Blissful Reservation</a>
    </h1>
    <div class="menu-toggle">
      <span></span> <span></span> <span></span>
    </div>
    <nav class="g-nav clearfix">
      <ul class="user-nav-list clearfix">
        <li><a href="userdashboard" class="active">Home</a></li>
        <li><a href="searchform">Hotels</a></li>
        <li><a href="booking-list">Booking Detail</a></li>
        <li><a href="#">AboutUs</a></li>
        <li><a href="#">ContactUs</a></li>
      </ul>
      <form action="<%=request.getContextPath()%>/logout" method="POST">
        <input type="submit" value="Logout" /> <input type="hidden"
          name="${_csrf.parameterName}" value="${_csrf.token}" />
      </form>
    </nav>
  </div>
</header>
<!--/.cmn-header-->