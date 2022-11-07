<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="row mt-5">
	<div class="col-lg-4">
		<div class="card mb-4">
			<div class="card-body text-center">
				<img
					src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
					alt="avatar" class="rounded-circle img-fluid" style="width: 150px;">
				<h5 class="my-3">${employee.lastName } ${employee.firstName }</h5>
				<p class="text-muted mb-1">Full Stack Developer</p>
				<p class="text-muted mb-4">${employee.address}</p>
				<div class="d-flex justify-content-center mb-2">
					<a class="btn btn-primary" href="edit?empId=${employee.employeeId}">Edit</a>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-8">
		<div class="card mb-4">
			<div class="card-body">
				<div class="row">
					<div class="col-sm-3">
						<p class="mb-0">Full Name</p>
					</div>
					<div class="col-sm-9">
						<p class="text-muted mb-0">${employee.lastName } ${employee.firstName }</p>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-sm-3">
						<p class="mb-0">Date Of Birth</p>
					</div>
					<div class="col-sm-9">
						<p class="text-muted mb-0">${employee.dateOfBirth}</p>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-sm-3">
						<p class="mb-0">Gender</p>
					</div>
					<div class="col-sm-9">
						<p class="text-muted mb-0">${employee.gender == 1 ? 'Nam' : 'Nữ'}</p>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-sm-3">
						<p class="mb-0">Email</p>
					</div>
					<div class="col-sm-9">
						<p class="text-muted mb-0">${employee.account.email }</p>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-sm-3">
						<p class="mb-0">Phone</p>
					</div>
					<div class="col-sm-9">
						<p class="text-muted mb-0">${employee.phone }</p>
					</div>
				</div>
				<hr>			
				<div class="row">
					<div class="col-sm-3">
						<p class="mb-0">Address</p>
					</div>
					<div class="col-sm-9">
						<p class="text-muted mb-0">${employee.address }</p>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>