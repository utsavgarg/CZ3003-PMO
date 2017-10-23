'use strict';


var numberOfEntries;
var updatedNumberOfEntries;
//Get the modal
var modal = document.getElementById('myModal');

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];


// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

function checkForNotifications(){

	
    $.ajax({
        url: "http://localhost:8080/CMOtoPMO/proposal/", 
        type: "GET",
        success: function(notification) {
            //Check if any notifications are returned - if so then display alert
        	updatedNumberOfEntries = notification.length;
        	
        	 if(updatedNumberOfEntries != numberOfEntries){
        		 
        	        // something was updated
        		 	var dt = new Date();
        		 	document.getElementById("datetime").innerHTML = dt.toLocaleString();
        		 	modal.style.display = "block";
        	        numberOfEntries = updatedNumberOfEntries;
        		 	//location.reload();
        	      }
        },
    });
}

function connect(event) {
	$.ajax({
        url: "http://localhost:8080/CMOtoPMO/proposal/", 
        type: "GET",
        success: function(notification) {
            //Check if any notifications are returned - if so then display alert
        	numberOfEntries = notification.length;
        },
    });
	setInterval(checkForNotifications, 5000);
}

window.addEventListener("load", connect, true)


