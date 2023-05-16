<header class="cmn-header">
  <div class="cmn-inner">
    <div class="clearfix">
      <h1>
        <a href="userdashboard">Blissful Reservation</a>
      </h1>
      <ul class="nav-list clearfix">
        <li><a href="userdashboard" class="active">Home</a></li>
        <li><a href="#">Hotels</a></li>
        <li><a href="#">Booking Detail</a></li>
        <li><a href="#">AboutUs</a></li>
        <li><a href="#">ContactUs</a></li>
        <li><form action="<%=request.getContextPath()%>/logout"
            method="POST">
            <input type="submit" value="Logout" /> <input type="hidden"
              name="${_csrf.parameterName}" value="${_csrf.token}" />
          </form></li>
      </ul>
    </div>
  </div>
</header>
<!--/.cmn-header-->