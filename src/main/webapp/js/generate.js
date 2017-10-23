'use strict';

var connectingElement = document.querySelector('.connecting');
var reportText = document.querySelector('#reportText');
var actionReportText = document.querySelector('#actionReportText');

var stompClient = null;
var username = null;

function connect(event) {

	username = $('#valueHolderId').html();

	if (username) {

		var socket = new SockJS('http://localhost:8080/ws');
		stompClient = Stomp.over(socket);

		stompClient.connect({}, {}, onError);
	}
	event.preventDefault();
}

function onError(error) {
	connectingElement.textContent = 'Could not connect to WebSocket server (Generate Report). Please refresh this page to try again!';
	connectingElement.style.color = 'red';
}

function replaceInformationDiv() {
	var crisisID = $('#crisisValue').html();
	var path = 'reports/' + crisisID + '.pdf';
	console.log(path);
	var tag = "<embed src='" + path + "' height='500' type='application/pdf'>";
	console.log(tag);
	$("#informationDiv").replaceWith(tag);
	$("#informationDivTitle").text("Report");
}

$("#reportButton")
		.click(
				function() {
					var reportContent = actionReportText.value.trim();
					console.log(reportContent);

					if (reportContent && stompClient) {
						var report = {
							sender : username,
							content : reportContent
						};

						stompClient.send("/app/report.generateReport", {}, JSON
								.stringify(report));
						reportContent = '';
					}
					event.preventDefault();

					if ($("#myAlert").find("div#myAlert2").length == 0) {
						$("#myAlert")
								.append(
										"<div class='alert alert-success alert-dismissable' id='myAlert2'> <button type='button' class='close' data-dismiss='alert'  aria-hidden='true'>&times;</button> Success! Report Generated.</div>");
					}
					$("#myAlert").css("display", "");
					replaceInformationDiv();
				})

$("#sendButton")
		.click(
				function() {
					if (stompClient) {
						stompClient.send("/app/report.sendReport", {}, {});
					}
					event.preventDefault();
					if ($("#myAlert3").find("div#myAlert4").length == 0) {
						$("#myAlert3")
								.append(
										"<div class='alert alert-success alert-dismissable' id='myAlert4'> <button type='button' class='close' data-dismiss='alert'  aria-hidden='true'>&times;</button> Success! Report Sent.</div>");
					}
					$("#myAlert3").css("display", "");
				})

window.addEventListener("load", connect, true);