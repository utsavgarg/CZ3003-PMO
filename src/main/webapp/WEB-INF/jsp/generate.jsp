<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>PMO| Generate</title>
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
			<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Dashboard"><a class="nav-link" href="/dashboard"
					method="post"> <i class="fa fa-fw fa-dashboard"></i> <span
						class="nav-link-text">Dashboard</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Chat"><a class="nav-link" href="/chat"> <i
						class="fa fa-fw fa-edit"></i> <span class="nav-link-text">PMO
							Chat</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Internal Chat"><a class="nav-link" href="#"> <i
						class="fa fa-fw fa-address-book"></i> <span class="nav-link-text">Contacts</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Contacts"><a class="nav-link" href="#"> <i
						class="fa fa-fw fa-file-pdf-o"></i> <span class="nav-link-text">Generate
							Report</span>
				</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" data-toggle="modal"
					data-target="#logoutModal"> <i class="fa fa-fw fa-sign-out"></i>Logout
				</a></li>
			</ul>
		</div>
	</nav>
	<div class="content-wrapper">
		<div class="container-fluid">
			<br />
			<div class="row">
				<div class="col-lg-6">
					<div class="card mb-3">
						<div class="card-header">Crisis ID: ${crisisID}</div>
						<div class="card-body">
							<div class="row">
								<div class="col-sm-8 my-auto">${crisisDetails}</div>
								<div class="col-sm-4 text-center my-auto">
								<div class="h4 mb-0 text-danger">${positionInCMO}</div>
									<div class="small text-muted">Sender</div>
									<hr>
									<div class="h4 mb-0 text-danger">${threatLevel}</div>
									<div class="small text-muted">Threat Level</div>
									<hr>
									<div class="h4 mb-0 text-danger">${estimatedCasualties}</div>
									<div class="small text-muted">Estimated Casualties</div>
									<hr>
									<div class="h4 mb-0 text-warning">${affectedAreas}</div>
									<div class="small text-muted">Affected Areas</div>
									<hr>
									<div class="h4 mb-0 text-warning">${crisisDuration}</div>
									<div class="small text-muted">Crisis Duration</div>
									<hr>
									<div class="h4 mb-0 text-warning">${courseOfActions}</div>
									<div class="small text-muted">Course of Actions</div>
									<hr>
									<div class="h4 mb-0 text-success">${consequencesOfAction}</div>
									<div class="small text-muted">Consequences of Action</div>
								</div>
							</div>
						</div>
						<div class="card-footer small text-muted">Updated yesterday
							at 11:59 PM</div>
					</div>
				</div>

				<div class="col-lg-6 text-center">
					<div class="card mb-3 ">
						<div class="card-header">
							<i class="fa fa-bell-o"></i> Action Response
						</div>

						<div id="generate-page">
							<form id="reportText" name="reportText" action="">
								<div class="form-group" style="margin: 0px;">
    								<textarea class="form-control" id="actionReportText" placeholder="Start typing here..." style="border-radius: 0px;"rows="10"></textarea>
								</div>
							</form>
						</div>
					</div>
					<button class="btn btn-success text-center" type="submit" id="reportButton" style="width: 200px;">
											<i
						class="fa fa-fw fa-file-pdf-o"></i> <span class="nav-link-text">Generate
							Report</span>
					</button>
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
	<!-- Page level plugin JavaScript-->
	<script src="../vendor/chart.js/Chart.min.js" type="text/javascript"></script>
	<script src="../vendor/datatables/jquery.dataTables.js"
		type="text/javascript"></script>
	<script src="../vendor/datatables/dataTables.bootstrap4.js"
		type="text/javascript"></script>
	<!-- Chat JavaScript-->
	<script src="/js/sockjs.min.js" type="text/javascript"></script>
	<script src="/js/stomp.min.js" type="text/javascript"></script>
	<script src="/js/main.js" type="text/javascript"></script>
	</div>
</body>

</html>
