# AmdocsProj

## build project with command:

	mvn clean install
	
## run spring boot project with

	mvn spring-boot:run  
	
## Run all the unit test classes
	mvn test

	
## for authorization use : (user/password)
	1. admin/password (ADMIN roles)
	2. user/password  (User roles)
	
## default url port
	http://localhost:9000
	
## Apis list :

	1. Create user
		- POST /user
		- request sample : {"username":"amdocs_admin","password":"amdocs123","status":"Activated"}
		- request headers :
				a. Authorization Basic YWRtaW46cGFzc3dvcmQ=
				b. Content-Type application/json 
		- response : user id created
		
	2. Get user
		- GET  /user?id={userId}
		- request : id as request param of user to get
		- request headers :
				a. Authorization Basic YWRtaW46cGFzc3dvcmQ=
				b. Accept application/json
		- response : user object
		
	3. Update a user
		- PUT /user
		- request sample : {"id":1,"username":"amdocs_admin","password":"amdocs123","status":"Deactivated"}
		- request headers :
				a. Authorization Basic YWRtaW46cGFzc3dvcmQ=
				b. Content-Type application/json 
		- response : user id updated
		
	4. Delete a user
		- DELETE /user?id={userId}
		- request : id as request param of user to delete
		- request headers :
				a. Authorization Basic YWRtaW46cGFzc3dvcmQ=
		- response : void
