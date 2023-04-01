# cloudnine spring boot backend
 cloud nine spring boot backend application

How to run to validate the application?

1. First deploy dynamic web application i.e. CloudnineBalllonDecor in 8081 post using tomcat. 
2. All the requests in the front end is kept with localhost port 8080.
   http://localhost:8080/ . So, we can deploy front end application in any port since it requests backend only through 8080 port.
3. Since i have all the requests targeted to http://localhost:8080/ , All the spring boot applications are expected to run in 8080. However, these ports can be changed as per our convenience.
4. Once the front end is deployed in 8081 port and backend spring boot app is deployed in 8080, we are ready to test the application.

We can test the backend alone using these links from post man
GET requests:

http://localhost:8080/cloudnine/personalform/personallist
http://localhost:8080/cloudnine/corporateform/corporatelist

http://localhost:8080/cloudnine/personalform/john.smith@acme.com

