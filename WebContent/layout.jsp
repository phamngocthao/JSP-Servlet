<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${page.title }</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
    />
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <link rel="stylesheet" href="sweetalert2.min.css">
<style><%@include file="/style/home.css"%></style>
  </head>
  <style>
    .nav{
        background-color: whitesmoke;
    }
    .main-header{
        background-color: whitesmoke;
    }
    .main-header .text-header h1{
        margin-top: 15px;
        font-size: 20px;
        margin-left: 15px;
    }
    .nav-header{
        padding: 10px 10px;
    }
    .nav-header .nav{
        float: right;
    }
    .nav-left{
        height: 500px;
        background-color: whitesmoke;
    }
     .main-layout{
         
     }
    .main-layout .text-list{
        padding: 20px 20px;
        border-bottom: 1px solid whitesmoke;
    }
 
  </style>
<body>
	<div class="container-fluid">
		<jsp:include page="/share/header.jsp"></jsp:include>
		
		<div class="main d-flex flex-row" style="min-height: 93vh">
			<jsp:include page="/share/navleft.jsp"></jsp:include>
			<div class="container" style="width: 75vw; padding-top: 2vh">
				<jsp:include page="${page.contentUrl }"></jsp:include>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <!-- Sweet Alert -->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="/public/share/assets/plugins/sweet-alert/sweetalert.min.js"></script>
    <script src="/public/share/assets/js/pages/sweet-alert/sweet-alert-data.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
  	
  	<c:if test="${sessionScope['success'] != null }">
  		<script type="text/javascript">
		Swal.fire({
			  position: 'top-end',
			  icon: 'success',
			  title: 'Lưu thành công !!!',
			  showConfirmButton: false,
			  timer: 1500
			})
		</script>
		<% session.removeAttribute("success"); %>	
  	</c:if>
  	<c:if test="${sessionScope['login-success'] != null }">
  		<script type="text/javascript">
		Swal.fire({
			  position: 'top-end',
			  icon: 'success',
			  title: 'Đăng nhập thành công !!!',
			  showConfirmButton: false,
			  timer: 1500
			})
		</script>
		
		<% session.removeAttribute("login-success"); %>
  	</c:if>
  	<c:if test="${sessionScope['error'] != null }">
		<script type="text/javascript">
		Swal.fire({
			  position: 'top-end',
			  icon: 'error',
			  title: 'Có lỗi xảy ra !!!',
			  showConfirmButton: false,
			  timer: 1500
			})
		</script>
	</c:if>
  	
  	
</body>
</html>