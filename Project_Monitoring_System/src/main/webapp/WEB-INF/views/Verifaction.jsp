<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Monitoring System - Login Form</title>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta2/css/bootstrap.min.css'>
<link rel="stylesheet" href='<spring:url value="/css/index.css"/>'>

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h2 class="text-center text-dark mt-5">Login Form</h2>
				<div class="text-center mb-5 text-danger">${requestScope.otpError}</div>
				<div class="card my-5">

					<form action='<spring:url value="/verify"/>' method="post" class="card-body cardbody-color p-lg-5">

						<div class="text-center">
							<img
								src="https://cdn.pixabay.com/photo/2016/03/31/19/56/avatar-1295397__340.png"
								class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
								width="200px" alt="profile">
						</div>

						<div class="mb-3">
							<input type="text" class="form-control" name="email"
								aria-describedby="emailHelp" value="${sessionScope.stdData.sEmail}">
						</div>
						<div class="mb-3">
							<input type="text" class="form-control" name="otp"
								placeholder="Enter OTP">
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-color px-5 mb-5 w-100">Verify</button>
						</div>
						
					</form>
				</div>

			</div>
		</div>
	</div>
	<!-- partial -->
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta2/js/bootstrap.min.js'></script>
</body>
</html>