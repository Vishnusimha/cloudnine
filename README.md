# cloudnine spring boot backend
 cloud nine spring boot backend application

How to run to validate the application?

1. First deploy dynamic web application i.e. CloudnineBalllonDecor in 8081 post using tomcat. 
2. All the requests in the front end is kept with localhost port 8080.
   http://localhost:8080/ . So, we can deploy front end application in any port since it requests backend only through 8080 port.
3. Since I have all the requests targeted to http://localhost:8080/ , All the spring boot applications are expected to run in 8080. However, these ports can be changed as per our convenience.
4. Once the front end is deployed in 8081 port and backend spring boot app is deployed in 8080, we are ready to test the application.

We can test the backend alone using these links from post man
POST requests:

http://localhost:8080/cloudnine/personalform/post-personal-form
http://localhost:8080/cloudnine/corporateform/post-corporate-form

Question 2, I have created a rest controllers and created 2 post endpoints,
with this I can send HTML forms data to backend and save them in a JSON file in resources folder.


Question 3, I have added 2 get endpoints, with this I can get the HTML forms data from backend which is stored in a JSON file in resources folder.
GET requests:
http://localhost:8080/cloudnine/personalform/personallist
http://localhost:8080/cloudnine/corporateform/corporatelist

In this Question 4, I have added a new end point with which we can query the data
with sponsor email as an input and get all the data related to a particular email.

Endpoint format:
http://localhost:8080/cloudnine/personalform//{sponsoremail}
example:
http://localhost:8080/cloudnine/personalform/john.smith@acme.com

when we request this endpoint, we get john.smith@acme.com related data

