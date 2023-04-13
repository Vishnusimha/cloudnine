# cloudnine spring boot backend
 cloud nine spring boot backend application

How to run to validate the application?

1. First deploy dynamic web application i.e. CloudnineBalllonDecor in 8081 post using tomcat. 
2. All the requests in the front end is kept with localhost port 8080.
   http://localhost:8080/ . So, we can deploy front end application in any port since it requests backend only through 8080 port.
3. Since I have all the requests targeted to http://localhost:8080/ , All the spring boot applications are expected to run in 8080. However, these ports can be changed as per our convenience.
4. Once the front end is deployed in 8081 port and backend spring boot app is deployed in 8080, we are ready to test the application.

We can test the backend alone using these links from post man

**POST requests:**

**_For corporate:_**
http://localhost:8080/cloudnine/corporateform/postcorporateform

**_For personal:_**
http://localhost:8080/cloudnine/personalform/postpersonalform

**GET requests:**

**_For corporate:_**
http://localhost:8080/cloudnine/corporateform/getcorporateform
http://localhost:8080/cloudnine/corporateform/getcorporateform/{sponsorEmail}

**_For personal:_**
http://localhost:8080/cloudnine/personalform/getpersonalform
http://localhost:8080/cloudnine/personalform/getpersonalform/{sponsorEmail}

**DELETE requests:**

**_For corporate:_**
http://localhost:8080/cloudnine/corporateform/deletecorporateform/{sponsorEmail}
**_For personal:_**
http://localhost:8080/cloudnine/personalform//deletepersonalform/{sponsorEmail}


Endpoint format:
http://localhost:8080/cloudnine/personalform//{sponsoremail}

**_example:_**
http://localhost:8080/cloudnine/personalform/john.smith@acme.com
when we request this endpoint, we get john.smith@acme.com related data

**Example Json:**

_**Corporate for json**_
```json
{
   "planno": 1,
   "sponsor": "Alice Smith",
   "companyname": "John Smith",
   "sponsoremail": "john.smith@acme.com",
   "companyemail": null,
   "occasion": "Christmas Party",
   "occasiondate": "2023-12-24",
   "occasiontime": "19:00:00",
   "location": "Dublin",
   "country": "Ireland",
   "officeparty": false,
   "milestoneevents": false,
   "achievements": false
}

```

_**Format of Personal form json**_
```json
{
   "planno" : "1",
   "sponsor" : "John Smith",
   "name" : "Alice Smith",
   "sponsoremail" : "john.smith@acme.com",
   "occasion" : "Personal Party",
   "occasiondate" : "2023-12-24",
   "occasiontime" : "19:00:00",
   "location" : "Donegal",
   "fathersday" : false,
   "mothersday" : false,
   "anniversary" : false,
   "country" : "Ireland"
}
```

_**Format of Personal form json when we get from the endpoint?**_
http://localhost:8080/cloudnine/personalform/getpersonalform
```json
 {
   "sponsorEmail": "james.brown@browncorp.com",
   "planNo": 5,
   "name": "Frank Smith",
   "sponsor": "James Brown",
   "corporateEventFormEntity": {
      "planNo": 5,
      "sponsor": "James Brown",
      "companyName": "Brown & Co.",
      "sponsorEmail": "james.brown@browncorp.com",
      "companyEmail": "info@browncorp.com",
      "occasion": "Employee Appreciation Day",
      "occasionDate": "2023-03-01",
      "occasionTime": "12:00:00",
      "location": "Dublin",
      "country": "Ireland",
      "officeParty": true,
      "milestoneEvents": false,
      "achievements": false
   },
   "occasion": "Employee Appreciation Day",
   "occasionDate": "2023-03-01",
   "occasionTime": "12:00:00",
   "location": "Dublin",
   "country": "Ireland",
   "anniversary": false,
   "mothersDay": false,
   "fathersDay": false
}
```
Note: it looks in this format, because of the relation between 2 tables in the sql database.
Foreign key and primary key relationship.
