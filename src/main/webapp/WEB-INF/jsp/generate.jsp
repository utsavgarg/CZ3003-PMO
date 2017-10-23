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
<title>PMO| Generate Report</title>
<!-- Bootstrap core CSS-->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="../vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="../vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="/css/sb-admin.css" rel="stylesheet">
<!-- Custom styles for this template-->
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet" href="/css/main.css" />

</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand" href="/dashboard"><img class="pmo_logo"
			src="../images/pmo_logo.png" alt="">PMO</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-sidenav" id="exampleAccordion" style="">
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Dashboard" id="dash"><a class="nav-link" href="/dashboard"> <i
						class="fa fa-fw fa-dashboard"></i> <span class="nav-link-text">Dashboard</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="PMO Chat" id="chat"><a class="nav-link" href="/chat"> <i
						class="fa fa-fw fa-edit"></i> <span class="nav-link-text">PMO
							Chat</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Contacts" id="contact"><a class="nav-link" href="/contacts"> <i
						class="fa fa-fw fa-address-book"></i> <span class="nav-link-text">Contacts</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Generate Report" id="report"><a class="nav-link" href="/generate">
						<i class="fa fa-fw fa-file-pdf-o"></i> <span class="nav-link-text">Generate
							Report</span>
				</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" data-toggle="modal"
					data-target="#logoutModal"> <i class="fa fa-fw fa-sign-out"></i>Logout
						<b id="valueHolderId">
							<c:out value="${pageContext.request.remoteUser}"></c:out>
						</b>
						<b id="getRole" style="display: none;">
							<c:out value="${pageContext.request.userPrincipal}"></c:out>
						</b>

				</a></li>
			</ul>
		</div>
	</nav>
	<div class="content-wrapper">
		<div class="container-fluid">
			<br />
			<div class="row">
				<div class="col-lg-8">
					<div class="card mb-3">
						<div class="card-header font-weight-bold">Crisis Information</div>
						<div class="card-body">
							<div class="row">
								<div class="col-sm-13">
									<div class="card bg-light mb-3">
										<div class="card-body">
											<div class="row row-in">
												<div class="col-lg-4 col-sm-6 row-in-br">
													<div class="text-center small">
														<i class="fa fa-address-card-o">&nbsp;</i>Crisis ID
													</div>
													<hr>
													<div
														class="h4 mb-0 small font-weight-bold text-info text-center">${crisisID}</div>
												</div>
												<div class="col-lg-4 col-sm-6 row-in-br  b-r-none">
													<div class="text-center small">
														<i class="fa fa-filter">&nbsp;</i>Crisis Type
													</div>
													<hr>
													<div
														class="h4 mb-0 small font-weight-bold text-info text-center">${crisisType}</div>
												</div>
												<div class="col-lg-4 col-sm-6  b-0">
													<div class="text-center small">
														<i class="fa fa-signal">&nbsp;</i>Threat Level
													</div>
													<hr>
													<div
														class="h4 mb-0 small font-weight-bold text-danger text-center">${threatLevel}</div>
												</div>
											</div>
										</div>
									</div>


									<div class="card bg-light mb-3">
										<div class="card-body">
											<div class="row row-in">
												<div class="col-lg-4 col-sm-6 row-in-br">
													<div class="text-center small">
														<i class="fa fa-clock-o">&nbsp;</i>Crisis Duration
													</div>
													<hr>
													<div
														class="h4 mb-0 small font-weight-bold text-info text-center">${crisisDuration}</div>
												</div>
												<div class="col-lg-4 col-sm-6 row-in-br  b-r-none">
													<div class="text-center small">
														<i class="fa fa-users">&nbsp;</i>Estimated Casualties
													</div>
													<hr>
													<div
														class="h4 mb-0 small font-weight-bold text-warning text-center">${estimatedCasualties}</div>
												</div>
												<div class="col-lg-4 col-sm-6  b-0">
													<div class="text-center small">
														<i class="fa fa-map-o">&nbsp;</i>Affected Area(s)
													</div>
													<hr>
													<div
														class="h4 mb-0 small font-weight-bold text-info text-center">${affectedArea}</div>
												</div>
											</div>
										</div>
									</div>

									<div class="card bg-light mb-3">
										<ul class="nav nav-pills" id="myTab" role="tablist">
											<li class="nav-item"><a class="nav-link active small"
												id="home-tab" data-toggle="pill" href="#home" role="tab"
												aria-controls="home" aria-expanded="true">Crisis Details</a></li>
											<li class="nav-item"><a class="nav-link small"
												id="courseOfAction-tab" data-toggle="pill"
												href="#courseOfAction" role="tab"
												aria-controls="courseOfAction">Course of Action</a></li>
											<li class="nav-item"><a class="nav-link small"
												id="consequencesOfAction-tab" data-toggle="pill"
												href="#consequencesOfAction" role="tab"
												aria-controls="consequencesOfAction">Consequences of
													Action</a></li>
											<li class="nav-item"><a class="nav-link small"
												id="cleanUpAction-tab" data-toggle="pill"
												href="#cleanUpAction" role="tab"
												aria-controls="cleanUpAction">Clean up Action</a></li>
										</ul>
										<div class="card-body">
											<div class="row row-in">
												<div class="tab-content" id="myTabContent">
													<div class="tab-pane fade show active" id="home"
														role="tabpanel" aria-labelledby="home-tab">${crisisDetails}</div>
													<div class="tab-pane fade" id="courseOfAction"
														role="tabpanel" aria-labelledby="courseOfAction-tab">${courseOfAction}</div>
													<div class="tab-pane fade" id="consequencesOfAction"
														role="tabpanel" aria-labelledby="consequencesOfAction-tab">${consequencesOfAction}</div>
													<div class="tab-pane fade" id="cleanUpAction"
														role="tabpanel" aria-labelledby="cleanUpAction-tab">${cleanUpAction}</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="card-footer small text-muted">Sent by: ${name},
							${positionInCMO}</div>
					</div>
				</div>

				<div class="col-lg-4 text-center">
					<div class="card mb-3 ">
						<div class="card-header">
							<i class="fa fa-bell-o"></i> Action Response
						</div>

						<div id="generate-page">
							<form id="reportText" name="reportText" action="">
								<div class="form-group" style="margin: 0px;">
									<textarea class="form-control" id="actionReportText"
										placeholder="Start typing here..." style="border-radius: 0px;"
										rows="10"></textarea>
								</div>
							</form>
						</div>
					</div>
					<button class="btn btn-success text-center" type="submit"
						id="reportButton">
						<i class="fa fa-fw fa-file-pdf-o"></i> <span class="nav-link-text">Generate</span>
					</button>
					<button class="btn btn-success text-center" type="submit"
						id="sendButton">
						<i class="fa fa-fw fa-send"></i> <span class="nav-link-text">Send</span>
					</button>

					<br />
					<br />
					<div class="container" style="display: none;" id="myAlert">
						<div class="alert alert-success alert-dismissable" id="myAlert2">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">&times;</button>
							Success! Report Generated.
						</div>
						
						<div class="container" style="display: none;" id="myAlert3">
						<div class="alert alert-success alert-dismissable" id="myAlert4">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">&times;</button>
							Success! Report Sent.
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.container-fluid-->
	<!-- /.content-wrapper-->
	<footer class="sticky-footer">
		<div class="container">
			<div class="text-center">
				<small>Copyright © SSP2 PMO 2017</small>
			</div>
		</div>
	</footer>
	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="/login">Logout</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript-->
	<script src="../vendor/jquery/jquery.min.js" type="text/javascript"></script>
	<script src="../vendor/popper/popper.min.js" type="text/javascript"></script>
	<script src="../vendor/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- Core plugin JavaScript-->
	<script src="../vendor/jquery-easing/jquery.easing.min.js"
		type="text/javascript"></script>
	<script src="../vendor/jquery/jquery.min.js" type="text/javascript"></script>
	<!-- Page level plugin JavaScript-->
	<script src="../vendor/chart.js/Chart.min.js" type="text/javascript"></script>
	<script src="../vendor/datatables/jquery.dataTables.js"
		type="text/javascript"></script>
	<script src="../vendor/datatables/dataTables.bootstrap4.js"
		type="text/javascript"></script>
	<!-- Chat JavaScript-->
	<script src="/js/sockjs.min.js" type="text/javascript"></script>
	<script src="/js/stomp.min.js" type="text/javascript"></script>
	<script src="/js/generate.js" type="text/javascript"></script>
	<script src="/js/access.js" type="text/javascript"></script>
	</div>
</body>

</html>
