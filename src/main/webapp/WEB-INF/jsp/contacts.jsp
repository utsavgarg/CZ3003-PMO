<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>PMO| Contacts</title>
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
<link href="/css/style.css" rel="stylesheet">
<!-- contacts page css -->
<link rel="stylesheet" href="/css/contacts.css" />

</head>
<!-- The Modal -->
<div id="myModal" class="modal">

	<!-- Modal content -->
	<div class="modal-content">
		<div class="modal-body">
			<h1 style="text-align: center;">New Crisis Report By CMO</h1>
			<h6 style = "font-weight: bold;">Crisis ID :</h6><p>${crisisID}</p>
			<h6 style = "font-weight: bold;">Threat Level :</h6><p>${threatLevel}</p>
			<h6 style = "font-weight: bold;">Crisis Type :</h6><p>${crisisType}</p>
			<h6 style = "font-weight: bold;">Crisis Details :</h6><p>${crisisDetails}</p>
			<br>
			<p style="float: right;">
				Received on: <span id="datetime"></span>
			</p>
		</div>
	</div>

</div>
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
					title="Dashboard"><a class="nav-link" href="/dashboard"> <i
						class="fa fa-fw fa-dashboard"></i> <span class="nav-link-text">Dashboard</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="PMO Chat"><a class="nav-link" href="/chat"> <i
						class="fa fa-fw fa-edit"></i> <span class="nav-link-text">PMO
							Chat</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Contacts "><a class="nav-link" href="/contacts"> <i
						class="fa fa-fw fa-address-book"></i> <span class="nav-link-text">Contacts</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Generate Report"><a class="nav-link" href="/generate">
						<i class="fa fa-fw fa-file-pdf-o"></i> <span class="nav-link-text">Generate
							Report</span>
				</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" data-toggle="modal"
					data-target="#logoutModal"> <i class="fa fa-fw fa-sign-out"></i>Logout
						<b id="valueHolderId"><c:out
								value="${pageContext.request.remoteUser}"></c:out></b>

				</a></li>
			</ul>
		</div>
	</nav>



	<div class="content-wrapper">
		<div class="container-fluid ">
			<br />
			<div class="row mb-4 ">
				<!-- .col -->
				<div class="col-md-4 col-sm-4">
					<div class="card bg-light">
						<div class="row">
							<div class="col-md-4 col-sm-4   text-center">
								<a href="contact-detail.html"><img class="mt-2 ml-3"
									src="../images/profileavatar.png"
									style="width: 70px; height: 70px;" alt="user"
									class="img-circle img-responsive"></a>
							</div>
							<div class="col-md-8 col-sm-8">
								<h6 class="box-title mt-3">Mrs Connie CHAN</h6>
								<h6 class="box-title">&nbsp;</h6>
								<small>1 Private Secretary to Prime</small> <br /> <small>Minister</small>
								<br /> <small>&nbsp;</small>
								<p></p>
								<address>
									<small><i class="fa fa-envelope-o">&nbsp;</i>connie_chan@pmo.gov.sg</small>
									<br> <abbr title="Phone"><i class="fa fa-phone">&nbsp;</i>62358577</abbr>
								</address>
								<p></p>
							</div>
						</div>
					</div>
				</div>
				<!-- /.col -->
				<!-- .col -->
				<div class="col-md-4 col-sm-4">
					<div class="card bg-light">
						<div class="row">
							<div class="col-md-4 col-sm-4 text-center">
								<a href="contact-detail.html"><img class="mt-2 ml-3"
									src="../images/profileavatar.png"
									style="width: 70px; height: 70px;" alt="user"
									class="img-circle img-responsive"></a>
							</div>
							<div class="col-md-8 col-sm-8">
								<h6 class="box-title mt-3">Ms Patrina TAN</h6>
								<h6 class="box-title">&nbsp;</h6>
								<small>Personal Assistant to</small> <br /> <small>Coordinating
									Minister for</small> <br /> <small>National Security</small>
								<p></p>
								<address>
									<small><i class="fa fa-envelope-o">&nbsp;</i>patrina_tan@pmo.gov.sg</small>
									<br> <abbr title="Phone"><i class="fa fa-phone">&nbsp;</i>64787090</abbr>
								</address>
								<p></p>
							</div>
						</div>
					</div>
				</div>
				<!-- /.col -->
				<!-- .col -->
				<div class="col-md-4 col-sm-4">
					<div class="card bg-light">
						<div class="row">
							<div class="col-md-4 col-sm-4 text-center">
								<a href="contact-detail.html"><img class="mt-2 ml-3"
									src="../images/profileavatar.png"
									style="width: 70px; height: 70px;" alt="user"
									class="img-circle img-responsive"></a>
							</div>
							<div class="col-md-8 col-sm-8">
								<h6 class="box-title mt-3">LOH Pang Shing</h6>
								<h6 class="box-title">&nbsp;</h6>
								<small>Personal Assistant to</small> <br /> <small>Coordinating
									Minister for</small> <br /> <small>Economic and Social
									Policies</small>
								<p></p>
								<address>
									<small><i class="fa fa-envelope-o">&nbsp;</i>pang_shing@pmo.gov.sg</small>
									<br> <abbr title="Phone"><i class="fa fa-phone">&nbsp;</i>63322717</abbr>
								</address>
								<p></p>
							</div>
						</div>
					</div>
				</div>
				<!-- /.col -->
			</div>


			<div class="row mb-4 ">
				<!-- .col -->
				<div class="col-md-4 col-sm-4">
					<div class="card bg-light">
						<div class="row">
							<div class="col-md-4 col-sm-4 text-center">
								<a href="contact-detail.html"><img class="mt-2 ml-3"
									src="../images/profileavatar.png"
									style="width: 70px; height: 70px;" alt="user"
									class="img-circle img-responsive"></a>
							</div>
							<div class="col-md-8 col-sm-8">
								<h6 class="box-title mt-3">Ms SOH Wan Kuan</h6>
								<h6 class="box-title">&nbsp;</h6>
								<small>Personal Assistant to</small> <br /> <small>Coordinating
									Minister for</small> <br /> <small>Infrastructure</small>
								<p></p>
								<address>
									<small><i class="fa fa-envelope-o">&nbsp;</i>soh_wan_kuan@mot.gov.sg</small>
									<br> <abbr title="Phone"><i class="fa fa-phone">&nbsp;</i>63757700</abbr>
								</address>
								<p></p>
							</div>
						</div>
					</div>
				</div>
				<!-- /.col -->
				<!-- .col -->
				<div class="col-md-4 col-sm-4">
					<div class="card bg-light">
						<div class="row">
							<div class="col-md-4 col-sm-4 text-center">
								<a href="contact-detail.html"><img class="mt-2 ml-3"
									src="../images/profileavatar.png"
									style="width: 70px; height: 70px;" alt="user"
									class="img-circle img-responsive"></a>
							</div>
							<div class="col-md-8 col-sm-8">
								<h6 class="box-title mt-3">Ms Grace Chia</h6>
								<h6 class="box-title">&nbsp;</h6>
								<small>Personal Assistant to Minister</small> <br /> <small>&nbsp;</small>
								<br /> <small>&nbsp;</small>
								<p></p>
								<address>
									<small><i class="fa fa-envelope-o">&nbsp;</i>grace_chia@pmo.gov.sg</small>
									<br> <abbr title="Phone"><i class="fa fa-phone">&nbsp;</i>62138589</abbr>
								</address>
								<p></p>
							</div>
						</div>
					</div>
				</div>
				<!-- /.col -->
				<!-- .col -->
				<div class="col-md-4 col-sm-4">
					<div class="card bg-light">
						<div class="row">
							<div class="col-md-4 col-sm-4 text-center">
								<a href="contact-detail.html"><img class="mt-2 ml-3"
									src="../images/profileavatar.png"
									style="width: 70px; height: 70px;" alt="user"
									class="img-circle img-responsive"></a>
							</div>
							<div class="col-md-8 col-sm-8">
								<h6 class="box-title mt-3">Miss Shanthi</h6>
								<h6 class="box-title">RAMAKRISHNAN</h6>
								<small>Personal Assistant to Senior</small> <br /> <small>Minister
									of State</small> <br /> <small>&nbsp;</small>
								<p></p>
								<address>
									<small><i class="fa fa-envelope-o">&nbsp;</i>shanthi@ntuc.org.sg</small>
									<br> <abbr title="Phone"><i class="fa fa-phone">&nbsp;</i>62138080</abbr>
								</address>
								<p></p>
							</div>
						</div>
					</div>
				</div>
				<!-- /.col -->
			</div>


		</div>
	</div>

	<!-- /.container-fluid-->
	<!-- /.content-wrapper-->
	<footer class="sticky-footer ">
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
	<script src="/js/contacts.js" type="text/javascript"></script>

</body>

</html>
