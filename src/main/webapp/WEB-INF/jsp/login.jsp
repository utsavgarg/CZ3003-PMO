<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>PMO| Login</title>
<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">
<!-- Custom styles for this template-->
<link href="css/style.css" rel="stylesheet">
</head>

<body class="bg-dark">
	<div class="container">
		<div class="login text-center">
			<img class="pmo_login_logo" src="./images/pmo_logo.png">
			<h3>Login</h3>
			<br />

			<form action="/login" method="post">
				<input type="text" name="username" placeholder="Username"
					required="required" /> <input type="password" name="password"
					placeholder="Password" required="required" />
				<button type="submit" class="btn btn-primary btn-block btn-large">Login</button>

				<br />

				<c:if test="${param.error ne null}">
					<div class="alert alert-danger alert-dismissible fade show"
						role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						Invalid username and password.
					</div>
				</c:if>

				<c:if test="${param.logout ne null}">
					<div class="alert alert-success alert-dismissible fade show"
						role="alert">
						You have been logged out.

						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>

					</div>
				</c:if>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />


			</form>
		</div>
	</div>
	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/popper/popper.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>