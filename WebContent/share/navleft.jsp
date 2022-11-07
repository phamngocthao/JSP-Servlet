<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="left bg-light" style="width: 25vw">
          <div class="item border-bottom border-right">
            <a href="home"
              ><i class="fa fa-tachometer" aria-hidden="true"></i>Dashboard</a
            >
          </div>
          <div class="item border-bottom border-right" id="accordion">
            <a
              href="#"
              data-toggle="collapse"
              data-target="#collapseOne"
              aria-expanded="true"
              aria-controls="collapseOne"
            >
              <i class="fa fa-bar-chart" aria-hidden="true"></i>Employee manager
            </a>
            <i
              class="fa fa-caret-down"
              aria-hidden="true"
              style="color: #377cb8; margin-left: 1vw"
            ></i>
          </div>
          <div
            class="collapse"
            id="collapseOne"
            aria-labelledby="headingOne"
            data-parent="#accordion"
          >
            <div class="item-sub border-bottom border-right">
              <a href="list"
                ><i class="fa fa-list" aria-hidden="true"></i>Employee list</a
              >
            </div>
            <div class="item-sub border-bottom border-right">
              <a href="add"
                ><i class="fa fa-plus" aria-hidden="true"></i>Add Employee</a
              >
            </div>
          </div>
</div>