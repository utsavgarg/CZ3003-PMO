//Access Control to display side panel links based on the logged in user's role
'use strict';

var role = null;

function getRole(){
	var delimeter = ';';
	var string = $('#getRole').html();
	var splitted = string.split(delimeter);
	var role = splitted[6].split(': ')[1];
	return role;	
}

function onLoad(event) {

	role = getRole();
	console.log(role);

	if (role == "ROLE_24-7") {
		$("#dash").css("display", "none");
		$("#chat").css("display", "none");
		$("#contact").css("display", "block");
		$("#logo").css("display", "block");
		$("#report").css("display", "none");
	}
	else if (role == "ROLE_MINISTERS" || role == "ROLE_PM") {
		$("#dash").css("display", "block");
		$("#chat").css("display", "block");
		$("#contact").css("display", "block");
		$("#logo").css("display", "block");
		$("#report").css("display", "none");
	}
	else if (role == "ROLE_SECRETARY") {
		$("#dash").css("display", "block");
		$("#chat").css("display", "block");
		$("#contact").css("display", "block");
		$("#report").css("display", "block");
		$("#logo").css("display", "block");
	}
	event.preventDefault();
}

window.addEventListener("load", onLoad, true);