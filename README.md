# CZ3003-PMO

## NATIONAL EMERGENCY SITUATION MANAGEMENT SYSTEM (NESIMS) PROJECT


#### Instructions to setup PMO subsystem

#### Software Required
1. Eclipse JEE Oxygen  
2. MySQL Workbench 6.3CE with MySQL server installed  
3. Chrome Web Browser


#### Setup of MYSQL Database 
Database Name: account  
  
```
CREATE  TABLE account.users (username VARCHAR(255) NOT NULL ,   password VARCHAR(255) NOT NULL ,   enabled TINYINT NOT NULL DEFAULT 1 ,   PRIMARY KEY (username))  

CREATE TABLE account.user_roles (user_role_id int(30) NOT NULL AUTO_INCREMENT,   username varchar(255) NOT NULL,   role varchar(255) NOT NULL,   PRIMARY KEY (user_role_id),   UNIQUE KEY uni_username_role (role,username),   KEY fk_username_idx (username),   CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES account.users (username))  

INSERT INTO account.users(username,password,enabled) VALUES ('PM','$2a$10$nYXvnZ4rVlM8nbjqrK7aA.yQ/MOq7lHhDXSdr04zDh2gGcuLdImeS', true)  

INSERT INTO account.users(username,password,enabled) VALUES ('24/7','$2a$10$nYXvnZ4rVlM8nbjqrK7aA.yQ/MOq7lHhDXSdr04zDh2gGcuLdImeS', true)  

INSERT INTO account.users(username,password,enabled) VALUES ('defenseMin','$2a$10$nYXvnZ4rVlM8nbjqrK7aA.yQ/MOq7lHhDXSdr04zDh2gGcuLdImeS', true)  

INSERT INTO account.users(username,password,enabled) VALUES ('Secretary','$2a$10$nYXvnZ4rVlM8nbjqrK7aA.yQ/MOq7lHhDXSdr04zDh2gGcuLdImeS', true) 
 
INSERT INTO account.user_roles (username, role) VALUES ('PM', 'ROLE_PM')  

INSERT INTO account.user_roles (username, role) VALUES ('24/7', 'ROLE_24-7')  

INSERT INTO account.user_roles (username, role) VALUES ('defenseMin', 'ROLE_MINISTERS')  

INSERT INTO account.user_roles (username, role) VALUES ('Secretary', 'ROLE_SECRETARY')  
```
  
#### Changes to the code of the project file:  

UNDER RESOURCES FOLDER  
application.properties:
1. change spring.datasource.username values to your database username.  
2. change spring.datasource.password values to your database password.  



UNDER CONTROLLER FOLDER  
`MainController.java`:  
1. Line 21, change ip address to localhost ip address with port 8080   
  
`ReportController`:  
1. Line 34, change ip address to localhost ip address with port 8080   
2. Line 36, change ip address to CMO's ip address with port 8080   
  
  
UNDER WEBAPP/WEB-INF/JSP  
`dashboard.jsp`:  
1. Line 210, change ip address to CMO's ip address with port 8080   
  
  
  
UNDER WEBAPP/JS  
`contacts.js`:  
1. Line 26, change ip address to localhost ip address with port 8080   
2. Line 47, change ip address to localhost ip address with port 8080   
  
`generate.js`:  
1. Line 20, change ip address to localhost ip address with port 8080   
  
`internal.js`:  
1. Line 24, change ip address to localhost ip address with port 8080   
  
`main.js`:  
1. Line 30, change ip address to localhost ip address with port 8080   
  
  
  
  
#### Running the application on eclipse (with mysql running):  
1. Right click the project folder  
2. Choose the 'run as' option  
3. Choose 'java application'  
4. Go to google chrome web browser  
5. Enter <ip address of localhost with port number 8080>/login (e.g.http://10.10.10.10:8080/login)  
6. Login to any account you desire  


#### Accounts
1. 24-7:  
Username: 24-7  
Password:  1234  
  
2. Ministers:  
Username: defenseMin  
Password:  1234      
  
1. Prime Minister:  
Username: pm  
Password:  1234      
  
1. secretary:  
Username: secretary   
Password:  1234  
