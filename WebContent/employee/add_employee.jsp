<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
            <div class="col-12">
              <c:if test="${employee == null }">
              		<h3>Add Employee</h3>
              </c:if>
              <c:if test="${employee != null }">
              		<h3>Update Employee</h3>
              </c:if>
            </div>
          </div>
          <hr />
          <div class="row">
            <div class="col-12">
              <form action="" method="post">
              	<input value="${employee.employeeId }" name="employeeId" hidden="hidden">
                <div class="form-group">
                  <label for="firstName"><b>First name</b>(*)</label>
                  <input
                    type="text"
                    class="form-control"
                    name="firstName"
                    placeholder="First Name"
                    value="${employee.firstName }"
                  />
                </div>
                <div class="form-group">
                  <label for="lastName"><b>Last name</b>(*)</label>
                  <input
                    type="text"
                    class="form-control"
                    name="lastName"
                    placeholder="Last Name"
                    value="${employee.lastName }"
                  />
                </div>
                <div class="form-group">
                  <label for="phone"><b>Phone number</b>(*)</label>
                  <input
                    type="text"
                    class="form-control"
                    name="phone"
                    placeholder="Phone number"
                    value="${employee.phone }"
                  />
                </div>
                <div class="form-group">
                  <label for="dateOfBirth"><b>Day of birth</b>(*)</label>
                  <input type="date" class="form-control" value="${dateOfBirth }" name="dateOfBirth" />
                </div>
                <label for="gender"><b>Gender</b>(*)</label>
                <div class="form-group" style="padding-left: 5vw">
                  <div class="form-check form-check-inline">
                    <input
                      class="form-check-input"
                      type="radio"
                      name="gender"
                      id="female"
                      value="0"
                      ${employee.gender == 0 ? 'checked' : '' }
                    />
                    <label class="form-check-label" for="female">Female</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input
                      class="form-check-input"
                      type="radio"
                      name="gender"
                      id="male"
                      value="1"
                       ${employee.gender == 1 ? 'checked' : '' }
                    />
                    <label class="form-check-label" for="male">Male</label>
                  </div>
                </div>
                <div class="form-group">
                  <label for="account"><b>Account</b>(*)</label>
                  <input
                    type="text"
                    class="form-control"
                    name="account"
                    placeholder="Account"
                    value="${employee.account.account }"
                  />
                </div>
                <div class="form-group">
                  <label for="email"><b>Email</b>(*)</label>
                  <input
                    type="text"
                    class="form-control"
                    name="email"
                    placeholder="email"
                    value="${employee.account.email }"
                  />
                </div>
                <div class="form-group">
                  <label for="password"><b>Password</b>(*)</label>
                  <input
                    type="password"
                    class="form-control"
                    name="password"
                    placeholder="Password"
                    value="${employee.account.password }"
                  />
                </div>
                <div class="form-group">
                  <label for="address"><b>Address</b></label>
                  <textarea
                    class="form-control"
                    id="address"
                    name="address"
                    rows="3"
                  >${employee.address }</textarea>
                </div>
                <div class="form-group">
                  <label for="status"><b>Status</b></label>
                  <div class="form-check">
                    <input
                      class="form-check-input"
                      type="checkbox"
                      name="status"
                      value="1"
                      id="status"
                     ${employee.account.status == 1 ? 'checked' : '' }
                    />
                    <label class="form-check-label" for="status">
                      Active
                    </label>
                  </div>
                </div>
                <div class="form-group">
                  <label for="department"><b>Department</b>(*)</label>
                  <select
                    id="department"
                    class="form-control"
                    name="departmentName"
                  >
                    <option value="FPT Software" ${employee.departmentName == 'FPT Software' ? 'selected' : '' }>FPT Software</option>
                    <option value="FPT Shop" ${employee.departmentName == 'FPT Shop' ? 'selected' : '' }>FPT Shop</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="remark"><b>Remark</b></label>
                  <textarea
                    class="form-control"
                    id="remark"
                    name="remark"
                    rows="3"
                                     
                  >${employee.remark}</textarea>
                </div>
                <div class="form-group">
                  <a class="btn btn-primary" href="list">Back</a>
                  <a  class="btn btn-secondary" href="add">Reset</a>
                  
	   				<c:if test="${employee == null }">
	   					<button type="submit" class="btn btn-success" formaction="add_employee">Add</button>
	   				</c:if>
                 	<c:if test="${employee != null }">
                  		<button type="submit" class="btn btn-success" formaction="update_employee?empId=${employee.employeeId }">Update</button>
                  	</c:if>
                </div>
              </form>
            </div>
</div>