'use strict';

var connectingElement = document.querySelector('.connecting');
var reportText = document.querySelector('#reportText');
var actionReportText = document.querySelector('#actionReportText');

var stompClient = null;
var username = null;

function connect(event) {
	
    username = $('#valueHolderId').html();

    if(username) {

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


$("#reportButton").click(function() {
    var reportContent = actionReportText.value.trim();
    console.log(reportContent);

    if(reportContent && stompClient) {
        var report = {
            sender: username,
            content: reportContent
        };

        stompClient.send("/app/report.generateReport", {}, JSON.stringify(report));
        reportContent = '';
    }
    event.preventDefault();
})

$("#sendButton").click(function() {
    if(stompClient) {
        stompClient.send("/app/report.sendReport", {}, {});
    }
    event.preventDefault();
})

window.addEventListener("load", connect, true);