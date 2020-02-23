# DEMATIC TEST APPLICATION

Test Java application for quick book storage, update, access and total price calculation.


Created using **SpringBoot** framework.

Clone application as **Maven** project.

Run **BookstoreApplication.java** to start server.


Test using **Junit** and **Rest-assured** library.

Run **BookstoreApplicationTests.java** for test.


# API List

------------------------------------------------------------------
## 1. ADD BOOK  

### REQUEST

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
### RESPONSE

**if Success**

  Status: 201,

  Body: 
```
{
	"barcode":"1111",
	"name":"My name",
	"author":"My author",
	"quantity":"10",
	"pricePerUnit":"2.17"
}
```
**if Error**

  Status: 406,

  Body:

  Error message "Book with given barcode already exist"

or

  Error object if request body not match with example

------------------------------------------------------------------
## 2. ADD ANTIQUE BOOK  

### REQUEST

Type - POST

URL - http://localhost:8080/books/antique

Headers - Content-type : application/json

Body
```
{
	"barcode":"1111",
	"name":"My name",
	"author":"My author",
	"quantity":"10",
	"pricePerUnit":"2.17",
	"releaseYear": "1820"   //must be less then 1900
}
```
### RESPONSE

**if Success**

  Status: 201,

  Body: 
```
{
	"barcode":"1111",
	"name":"My name",
	"author":"My author",
	"quantity":"10",
	"pricePerUnit":"2.17",
	"releaseYear": "1820"
}
```
**if Error**

  Status: 406,

  Body:

  Error message "Book with given barcode already exist"

or

  Error object if request body not match with example

------------------------------------------------------------------
## 3. ADD SCIENCE BOOK  

### REQUEST

Type - POST

URL - http://localhost:8080/books/science

Headers - Content-type : application/json

Body
```
{
	"barcode":"1111",
	"name":"My name",
	"author":"My author",
	"quantity":"10",
	"pricePerUnit":"2.17",
	"scienceIndex": "2"    //must be between 1 - 10
}
```
### RESPONSE

**if Success**

  Status: 201,

  Body: 
```
{
	"barcode":"1111",
	"name":"My name",
	"author":"My author",
	"quantity":"10",
	"pricePerUnit":"2.17",
	"scienceIndex": "2"
}
```
**if Error**

  Status: 406,

  Body:

  Error message "Book with given barcode already exist"

or

  Error object if request body not match with example

------------------------------------------------------------------
## 4. GET BOOK  

### REQUEST

Type - GET

URL - http://localhost:8080/books/{barkode}

Headers - Content-type : application/json

### RESPONSE

**if Success**

  Status: 200,

  Body: 
```
{
	"barcode":"1111",
	"name":"My name",
	"author":"My author",
	"quantity":"10",
	"pricePerUnit":"2.17"
}
or
{
	"barcode":"1111",
	"name":"My name",
	"author":"My author",
	"quantity":"10",
	"pricePerUnit":"2.17",
	"scienceIndex": "2"
}
or
{
	"barcode":"1111",
	"name":"My name",
	"author":"My author",
	"quantity":"10",
	"pricePerUnit":"2.17",
	"releaseYear": "1820"
}
depend of type of book
```
**if Error**

  Status: 404,

  Body:

  Error message "Book with given barcode not exist"

------------------------------------------------------------------
## 5. UPDATE BOOK  

### REQUEST

Type - PUT

URL - http://localhost:8080/books/{barkode}

Headers - Content-type : application/json

### RESPONSE

**if Success**

  Status: 200,

  Body: 
```
{
	"barcode":"1111",
	"name":"My name",
	"author":"My author",
	"quantity":"10",
	"pricePerUnit":"2.17",
	"scienceIndex": "2",         //must be between 1 - 10
	"releaseYear": "1820"        //must be less then 1900
}
every paramenter is optional
```
**if Error**

  Status: 404,

  Body:

  Error message "Book with given barcode not exist"

------------------------------------------------------------------
## 6. GET TOTAL PRICE  

### REQUEST

Type - GET

URL - http://localhost:8080/totalprice/{barcode}

Headers - Content-type : application/json

### RESPONSE

**if Success**

  Status: 200,

  Body: 
```
	21.6

```
**if Error**

  Status: 404,

  Body:

  Error message "Book with given barcode not exist"

------------------------------------------------------------------


