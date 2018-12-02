Sales Order Mini Project:

+ Pre-requisites:

 - Java 8 
 - Maven with path set
 - MongoDB with path set
 - Node with path set
 - Angular CLI 

+ Git:
  1. Clone the repository from https://github.com/skumar9611/salesorder

+ MongoDB:

  1. Install MongoDB
  2. Set the path
 
+ SpringBoot:

  1. Open cmd or terminal in salesorder/salesproject folder
  2. Execute the following:
   	 -	mvn install (or the equivalent command in linux/mac)
	   - mvn spring-boot:run(or the equivalent command in linux/mac)
  3. Can check the api calls at Go to localhost:8080/api/salesproject

 																or

  1. Open Eclipse or Spring Tool Suite and import existing maven repository at the salesproject folder.
  2. Run as springboot app or java app.


+ Angular:

  1. Open cmd or terminal in salesorder/client-side/angular folder
  2. Execute the following:
	   -	npm install (or the equivalent command in linux/mac)
     -  ng serve (or the equivalent command in linux/mac)
  3. Open a browser at http://localhost:4200

+ Roles:

  - Aman - SpringBoot and MongoDB (Server Side)
  - Sharath - Angular (Client Side)






+ Testing Spring:

	1. Create a Maven Project with a name of SalesProject in a Package:com.orderapi.salesproject;
	2. Download dependency of Web,MongoDB and then Update the Maven Project.
	3. Create a Java class of SalesProjectApplication(main class),MyRestController,DbSeeder,SalesRepository,SalesProduct and Product.
	4. MyRestController will be a Rest API call to the database and it will serve as REST call to the LocalHost to run it on the server.
	5. Dbseeder implements a CommandLineRunner which enables the interface to be run by the SpringBoot application.
	6. SalesRepository is the the class which is actually interacting with the MongoDb server by extending the Mongo Repository and thus enabling us to use the Repository functions
	7. In Application.properties file write the mongodb host and port i.e. localhost and 27017 respectively.
	8. SalesProduct is the class having  the data initialized in it with a list of product which in itself is a class of products with it's declarations.
	9. Start the MongoDb server(Create a folder by name of data\db in c:) and by going to the bin folder of Mongo and then run CMD and,
	   Execute the following:
	           mongod or mongod.exe 
	10. Run the Java Application which will start the connection.
	11. Go to localhost:8080/ and execute your requestmapping fields.
