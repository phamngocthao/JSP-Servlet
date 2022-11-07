<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/995da94a58.js"
	crossorigin="anonymous"></script>
</head>
<style>
* {
	margin: 0;
	padding: 0;
}

.main-section {
	width: 350px;
	padding-top: 40px;
	text-align: center;
	margin: 5% 35%;
	border-radius: 10px 10px;
	box-shadow: 0 0px 15px rgba(0, 0, 0, 0.15);
}

.main-header h1 {
	font-weight: 400;
	font-size: 30px;
}

.login {
	max-width: auto;
	width: 300px;
	height: 40px;
	background-color: #52C948;
	border: none;
}

.login:hover {
	background-color: #5AE95A;
}

.main-center .user-input, .main-center .password-input {
	position: relative;
}

.main-center input {
	padding-left: 25px;
}

.user-input i, .password-input i {
	position: absolute;
	left: 10px;
	top: 35px;
}

.forgot-password {
	padding-top: 15px;
	top: 10px;
	height: 60px;
	text-align: center;
	color: #878887;
	font-size: 14px;
	background-color: whitesmoke;
}
</style>
<body class="container">
	<c:if test="${requestScope['error-message'] != null}">
		<div class="alert alert-warning alert-dismissible fade show mt-5" role="alert">
			<strong>Có lỗi!</strong> ${requestScope["error-message"]}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>
	<div class="row main-section">
		<div class="col-12 main-header">
			<h1>Member login</h1>
		</div>
		<div class="col-12 main-center">
			<form action="login" method="post">
				<div class="form-group user-input">
					<label for=""></label> <input type="text" class="form-control"
						name="username" id="username" aria-describedby="helpId"
						placeholder="Username"> <i class="fa-solid fa-user"></i>
				</div>
				<div class="form-group password-input">
					<label for=""></label> <input type="text" class="form-control"
						name="password" id="password" aria-describedby="helpId"
						placeholder="Password"> <i class="fa-solid fa-lock"></i>
				</div>
				<button type="submit" name="" id="" class="btn btn-primary login"
					role="button">Login</button>
			</form>
		</div>
		<div class="col-12 forgot-password">
			<p>Forgot Password ??</p>
		</div>
	</div>
	

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>