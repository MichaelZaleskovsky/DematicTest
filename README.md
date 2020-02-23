DematicTest

Test Java application for quick book storage, update, access and total price calculation.
Created using SpringBoot framework.
Clone application as Maven project.

Run BookstoreApplication.java to start server.

Test using Junit and Rest-assured library.

Run BookstoreApplicationTests.java for test.

API List

------------------------------------------------------------------
1. ADD BOOK  

Type - POST
URL - http://localhost:8080/books
Headers - Content-type : application/json
Body
```
{
	"barcode":"1111",
	"name":"My name",
	"author":"My author",
	"quantity":"10",
	"pricePerUnit":"2.17"
}
```
Response:
if Success
  Status 201,
  Body 
```
{
	"barcode":"1111",
	"name":"My name",
	"author":"My author",
	"quantity":"10",
	"pricePerUnit":"2.17"
}
```
if Error
  Status 406
  Body
  Error message "Book with given barcode already exist"
or
  Error object if request body not match with example

------------------------------------------------------------------
1. ADD BOOK  

Type - POST
URL - http://localhost:8080/books
Headers - Content-type : application/json
Body
```
{
	"barcode":"1111",
	"name":"My name",
	"author":"My author",
	"quantity":"10",
	"pricePerUnit":"2.17"
}
```
Response:
if Success
  Status 201,
  Body 
```
{
	"barcode":"1111",
	"name":"My name",
	"author":"My author",
	"quantity":"10",
	"pricePerUnit":"2.17"
}
```
if Error
  Status 406
  Body
  Error message "Book with given barcode already exist"
or
  Error object if request body not match with example

