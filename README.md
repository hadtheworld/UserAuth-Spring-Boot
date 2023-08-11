# UserAuth-Spring-Boot
Simple Apring Boot Rest API Created using H2 Database, JPA, Spring Security, All End points are saved in spring security and can be accessed after logging in only

# installation Guide
**Requirements**
- JDK 17
- Eclipse IDE (Enterprise Edition)/STS
- Internet Connection
- 
**Use JDK 17 (Rcomended)**
- download the zip folder from git hub (or git clone it)
- extract the files
- onpen Eclipse IDE and import the extracted folder as 'Existing Maven Project'
- open main file in 'com.example.UserAuth' package and run it as 'Java Application' or 'Spring Boot Project' in STS
- once the server starts API could now be usable
- As I have applied Spring Security Layer API can only be accessed after authorization
- Initally populated 2 records which you could use to authorize to spring security.
-     userid:- God@email.com
-     password:- godly
-     userId2:- devil@email.com
-     password2:- devily
- now you can check for api _:- GET  http://localhost:8080/user
**Implementations**
  - Global Excetion Handlng at controller layer using:- @ControllerAdvice annotaion
  -  Layerd Archietecture with:- Controller, Service, Dao, Entities layers
  -  User Defined Exceptions
  -  Spring Security Implementation in 'configure' package
