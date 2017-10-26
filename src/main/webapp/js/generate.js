'use strict';

var connectingElement = document.querySelector('.connecting');
var reportText = document.querySelector('#reportText');
var actionReportText = document.querySelector('#actionReportText');

var stompClient = null;
var username = null;

function connect(event) {

	document.getElementById("sendButton").disabled = true;
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
	var tag = "<embed src='" + path + "' height='500' width ='580' type='application/pdf'>";
	console.log(tag);
	$(".info").html(tag);
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

				     $("#generate-alert").fadeTo(2000, 500).slideUp(500, function(){
				     	$("#generate-alert").slideUp(500);
				     	setTimeout(function() { replaceInformationDiv(); }, 1000);
				    	document.getElementById("sendButton").disabled = false;
				 });
				})


$("#sendButton")
		.click(
				function() {
					if (stompClient) {
						stompClient.send("/app/report.sendReport", {}, {});
					}
					event.preventDefault();
					$("#submit-alert").fadeTo(2000, 500).slideUp(500, function(){
		                $("#submit-alert").slideUp(500);
		});
				})

window.addEventListener("load", connect, true);