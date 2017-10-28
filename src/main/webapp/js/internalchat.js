'use strict';

var messageForm = document.querySelector('#internalmessageForm');
var messageInput = document.querySelector('#internalmessage');
var messageArea = document.querySelector('#internalmessageArea');
var connectingElement = document.querySelector('.connecting');

var stompClient = null;
var username = null;

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function connect(event) {
	   username = $('#valueHolderId').html();
	   username = username.replace(/[\n\t\r]/g,"");

    if(username) {

        var socket = new SockJS('http://localhost:8080/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}

function onConnected() {
    // Subscribe to the Private Channel
    stompClient.subscribe('/channel/private', onMessageReceived);

    // Tell your username to the server
    stompClient.send("/app/chat.addInternalUser",
        {},
        JSON.stringify({sender: username, type: 'JOIN'})
    )

    connectingElement.classList.add('hidden');
    
    document.getElementById('internal-online-status').style.background = "#32CD32";
    document.getElementById("internal-online-status-text").classList.remove('text-danger');
    document.getElementById("internal-online-status-text").classList.add('text-success');
    document.getElementById("internal-online-status-text").innerHTML = "Online";
    
    document.getElementById('internal-reconnect').style.display = "none";
    document.getElementById('chat-page').style.display = "block";
    connectingElement.style.display = "none";
}


function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server (Internal Chat). Please refresh this page to try again!';
    connectingElement.style.color = 'red';
    connectingElement.style.marginTop  = '20px';

    
    document.getElementById('internal-online-status').style.background = "#f00";
    document.getElementById("internal-online-status-text").classList.remove('text-success');
    document.getElementById("internal-online-status-text").classList.add('text-danger');
    document.getElementById("internal-online-status-text").innerHTML = "Offline";
    
    document.getElementById('internal-reconnect').style.display = "block";
    document.getElementById('chat-page').style.display = "none";
    connectingElement.style.display = "block";

}


function sendMessage(event) {
	
    var messageContent = messageInput.value.trim();

    if(messageContent && stompClient) {
        var chatMessage = {
            sender: username,
            content: messageInput.value,
            type: 'CHAT'
        };

        stompClient.send("/app/chat.sendInternalMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}



function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);

    var messageElement = document.createElement('li');

/*    CHECK MESSAGE TAG RECEIVED (JOIN,LEAVE,CHAT)*/
    if(message.type === 'JOIN') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' joined!';
    } else if (message.type === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' left!';
    } else {
    	
    	messageElement.classList.add('chat-message');

    	//chat picture
        var avatarElement = document.createElement('i');
        var avatarText = document.createTextNode(message.sender[0]);
        avatarElement.appendChild(avatarText);
        avatarElement.style['background-color'] = getAvatarColor(message.sender);

        messageElement.appendChild(avatarElement);

       
        //chat sender name
        var usernameElement = document.createElement('span');
        var usernameText = document.createTextNode(message.sender);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
        
        //chat time
        var time = document.createElement('span');
        time.classList.add("time-right");
        var text = document.createTextNode(new Date(new Date().getTime()).toLocaleTimeString(navigator.language, {hour: '2-digit', minute:'2-digit'}));
        time.appendChild(text);
        messageElement.appendChild(time);
    }

    //chat message
    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;
}



function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }

    var index = Math.abs(hash % colors.length);
    return colors[index];
}

function internalreconnect() {
	
	connect("load");
}

window.addEventListener("load", connect, true)
messageForm.addEventListener('submit', sendMessage, true)
