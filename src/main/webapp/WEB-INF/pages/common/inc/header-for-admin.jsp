<header class="cmn-header">
  <div class="cmn-inner clearfix">
    <h1>
      <a href="admindashboard">Blissful Reservation</a>
    </h1>
    <nav class="g-nav clearfix">
      <ul class="nav-admin-list clearfix">
        <li><a href="admindashboard">Home</a></li>
        <li><a href="form">Add Hotel</a></li>
        <li><a href="hotel-view">Hotels</a></li>
        <li><a href="UserList">User List</a></li>
        <li><a href="booking-lists">Booking Detail</a></li>
      </ul>
      <form action="<%=request.getContextPath()%>/logout" method="POST">
        <input type="submit" value="Logout" class="cmn-btn header-btn" />
        <input type="hidden" name="${_csrf.parameterName}"
          value="${_csrf.token}" />
      </form>
    </nav>
  </div>
</header>
<!--/.cmn-header-->