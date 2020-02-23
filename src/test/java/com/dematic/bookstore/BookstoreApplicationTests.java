package com.dematic.bookstore;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookstoreApplicationTests {

	@LocalServerPort
	private int port;
	
	private static String host;
	
	private static String bookJson = "{\n" + 
			"	\"barcode\":\"1111\",\n" + 
			"	\"name\":\"Book name\",\n" + 
			"	\"author\":\"Book author\",\n" + 
			"	\"quantity\":\"10\",\n" + 
			"	\"pricePerUnit\":\"2.17\"\n" + 
			"}";
	
	private static String wrongBookJson = "{\n" + 
			"	\"barcode\":\"1111\",\n" + 
			"	\"author\":\"Book author\",\n" + 
			"	\"quantity\":\"10\",\n" + 
			"	\"pricePerUnit\":\"2.17\"\n" + 
			"}";
	
	private static String antiqueBookJson = "{\n" + 
			"	\"barcode\":\"2222\",\n" + 
			"	\"name\":\"Antique name\",\n" + 
			"	\"author\":\"Antique author\",\n" + 
			"	\"quantity\":\"20\",\n" + 
			"	\"releaseYear\":\"1850\",\n" + 
			"	\"pricePerUnit\":\"5.22\"\n" + 
			"}";

	private static String wrongAntiqueBookJson = "{\n" + 
			"	\"barcode\":\"2222\",\n" + 
			"	\"name\":\"Antique name\",\n" + 
			"	\"author\":\"Antique author\",\n" + 
			"	\"quantity\":\"20\",\n" + 
			"	\"releaseYear\":\"1950\",\n" + 
			"	\"pricePerUnit\":\"5.22\"\n" + 
			"}";

	private static String scienceBookJson = "{\n" + 
			"	\"barcode\":\"3333\",\n" + 
			"	\"name\":\"Science name\",\n" + 
			"	\"author\":\"Science author\",\n" + 
			"	\"quantity\":\"10\",\n" + 
			"	\"scienceIndex\":\"5\",\n" + 
			"	\"pricePerUnit\":\"3.25\"\n" + 
			"}";
	
	private static String wrongScienceBookJson = "{\n" + 
			"	\"barcode\":\"3333\",\n" + 
			"	\"name\":\"Science name\",\n" + 
			"	\"author\":\"Science author\",\n" + 
			"	\"quantity\":\"10\",\n" + 
			"	\"scienceIndex\":\"5\",\n" + 
			"	\"pricePerUnit\":\"3.25\"\n" + 
			"}";
	
	private static String updateBookJson1 = "{\n" + 
			"	\"name\":\"Updated name\",\n" + 
			"	\"quantity\":\"20\"\n" + 
			"}";
	
	private static String updateBookJson2 = "{\n" + 
			"	\"scienceIndex\":\"4\"\n" + 
			"}";
	
	private static String wrongUpdateBookJson = "{\n" + 
			"	\"scienceIndex\":\"100\"\n" + 
			"}";
	
	@BeforeEach
	public void setUp() { 
		host = "http://localhost:"+port; 
		
	}
  
	@Test
	void addBookAndGetTotalPriceTest() {
		
		given().contentType("application/json").body(bookJson)
		.when().post(host + "/books")
		.then()
		.assertThat().body(containsString("Book name"));
		
		given().contentType("application/json") 
		.when().get(host + "/totalprice/1111") 
		.then() 
		.statusCode(HttpStatus.OK.value()) 
		.and()
		.assertThat().body(equalTo("21.7"));
	}

	@Test
	void addAntiqueBookAndGetTotalPriceTest() {
		
		given().contentType("application/json").body(antiqueBookJson)
		.when().post(host + "/books/antique")
		.then()
		.statusCode(HttpStatus.CREATED.value());
		
		given().contentType("application/json") 
		.when().get(host + "/totalprice/2222") 
		.then() 
		.statusCode(HttpStatus.OK.value()) 
		.and()
		.assertThat().body(equalTo("1774.8"));
	}

	@Test
	void addScienceBookAndGetTotalPriceTest() {
		
		given().contentType("application/json").body(scienceBookJson)
		.when().post(host + "/books/science");
		
		given().contentType("application/json").body(scienceBookJson)
		.when().get(host + "/books/3333")
		.then()
		.assertThat().body(containsString("scienceIndex"));
		
		given().contentType("application/json") 
		.when().get(host + "/totalprice/3333") 
		.then() 
		.statusCode(HttpStatus.OK.value()) 
		.and()
		.assertThat().body(equalTo("130.0"));
	}

	@Test
	void updateBookAndGetTotalPriceTest() {
		
		given().contentType("application/json").body(bookJson)
		.when().post(host + "/books");
		
		given().contentType("application/json").body(bookJson)
		.when().get(host + "/books/1111")
		.then()
		.assertThat().body(containsString("Book name"));
		
		given().contentType("application/json").body(updateBookJson1)
		.when().put(host + "/books/1111")
		.then()
		.statusCode(HttpStatus.OK.value());
		
		given().contentType("application/json")
		.when().get(host + "/books/1111")
		.then()
		.statusCode(HttpStatus.OK.value())
		.and()
		.assertThat().body(containsString("Updated name"));
		
		given().contentType("application/json") 
		.when().get(host + "/totalprice/1111") 
		.then() 
		.statusCode(HttpStatus.OK.value()) 
		.and()
		.assertThat().body(equalTo("43.4"));
	}

	@Test
	void updateScienceBookAndGetTotalPriceTest() {
		
		given().contentType("application/json").body(scienceBookJson)
		.when().post(host + "/books/science");
		
		given().contentType("application/json")
		.when().get(host + "/books/3333")
		.then()
		.statusCode(HttpStatus.OK.value())
		.and()
		.assertThat().body(containsString("Science name"));
		
		given().contentType("application/json").body(updateBookJson2)
		.when().put(host + "/books/3333")
		.then()
		.statusCode(HttpStatus.OK.value());
		
		given().contentType("application/json") 
		.when().get(host + "/totalprice/3333") 
		.then() 
		.statusCode(HttpStatus.OK.value()) 
		.and()
		.assertThat().body(equalTo("130.0"));
	}

	@Test
	void wrongDataTest() {
		
		given().contentType("application/json").body(wrongBookJson)
		.when().post(host + "/books")
		.then()
		.statusCode(HttpStatus.NOT_ACCEPTABLE.value());
		
		given().contentType("application/json").body(wrongAntiqueBookJson)
		.when().post(host + "/books/antique")
		.then()
		.statusCode(HttpStatus.NOT_ACCEPTABLE.value());
		
		given().contentType("application/json").body(wrongScienceBookJson)
		.when().post(host + "/books/science")
		.then()
		.statusCode(HttpStatus.NOT_ACCEPTABLE.value());
	}

	@Test
	void wrongUpdateTest() {
		
		given().contentType("application/json").body(scienceBookJson)
		.when().post(host + "/books/science");
		
		given().contentType("application/json")
		.when().get(host + "/books/3333")
		.then()
		.statusCode(HttpStatus.OK.value())
		.and()
		.assertThat().body(containsString("Science name"));
		
		given().contentType("application/json").body(wrongUpdateBookJson)
		.when().put(host + "/books/3333")
		.then()
		.statusCode(HttpStatus.BAD_REQUEST.value());
		
		given().contentType("application/json") 
		.when().get(host + "/totalprice/3333") 
		.then() 
		.statusCode(HttpStatus.OK.value()) 
		.and()
		.assertThat().body(equalTo("130.0"));

	}
}
