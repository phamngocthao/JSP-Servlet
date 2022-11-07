<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav
        class="navbar justify-content-between bg-light border-bottom"
        style="height: 7vh"
      >
        <a class="navbar-brand" href="#" style="color: #777777"
          ><i class="fa fa-users" aria-hidden="true"></i>Employee</a
        >
        <div
          class="d-flex flex-row justify-content-end"
          style="column-gap: 3vw"
        >
          <div style="color: #377cb8">Welcome <strong>${sessionScope['username'].employee.firstName} ${sessionScope['username'].employee.lastName}</strong></div>
          <div>
            <a href="logout"
              ><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a
            >
          </div>
        </div>
</nav>