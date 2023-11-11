package com.cbfacademy.apiassessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cbfacademy.apiassessment.controller.Ftse100Controller;
import com.cbfacademy.apiassessment.datamodel.Ftse100;

import java.io.IOException;
import java.math.BigInteger;
// import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = Ftse100Controller.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTests {

	@LocalServerPort
	private int port;

	// private URL base;

	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeEach
	public void setUp() throws Exception {
		// this.base = new URL("http://localhost:" + port + "/companies");
	}

	//use before all annotation to run this before each method (once)
	// come back to my rest templates to ensure rest templates are functioning correctly after implementaiton of service

	//TESTS I WANT TO WRITE 
	// reading and writing from a file 
	@Test
	@DisplayName("Reading from json file and returning list of objects")
	public void readFromJsonArray() throws IOException {
		List<Ftse100> expectedCompaniesList = new ArrayList<>(){
			{
				add (new Ftse100("Endeavour Plc", "EDV", "Precious Metals and Mining", 1678.0, new BigInteger("4333000000"), -17.22, 1.52, 27.23, 23.09));
				add (new Ftse100("ConvaTec Group Plc", "CTEC", "Medical Equipment and Services", 201.08, new BigInteger("4554000000"), 67.67, 3.11, 90.12, 16.6));
				add (new Ftse100("BAE Systems Plc", "BA", "Aerospace and Defense", 1086.0, new BigInteger("32770000000"), 16.85, 3.04, 61.08, 31.6));
				add (new Ftse100("Unite Group Plc", "UTG", "Real Estate", 854.5, new BigInteger("39840000000"), 26.5, 0.99, 35.73, 15.5));
			}
			
		}; 

		final String jsonFile = "src/test/ftseTest.json";

		List<Ftse100> actualCompaniesList = Ftse100JsonFileHandler.readFtse100JsonFile(jsonFile);

		assertEquals(expectedCompaniesList, actualCompaniesList);
		}
}
		//created expected value 
		//create an instance of my file handler potentially?
		// call my filewrite method on my list of companies 
		// assert that this equals this
	
	// converting to gson to java 
	// converting from java to gson 
	// test my algorithm class 
	// probabaly my rest template also 
	// test that my exceptions work too


	//  @Test
    // public void testBubbleSortCompaniesByStockPrice() {
//  Create a dummy array list perhaps?
// Or i could set up a list before hand? to create a list of companies and use the values from it?
// hm give it a think, it would be a put long 
// instantiate a list of objects with a few metrics inside 
// void whenSortedWithBubbleSort_thenGetSortedArray() {
//     Integer[] array = { 2, 1, 4, 6, 3, 5 };
//     Integer[] sortedArray = { 1, 2, 3, 4, 5, 6 };
//     BubbleSort bubbleSort = new BubbleSort();
//     bubbleSort.bubbleSort(array);
    // assertArrayEquals(array, sortedArray);
	// example way to test if bubble sort algorithm works 

// 	@Test
// 	@DisplayName("/companies endpoint returns the list of FTSE 100 companies")
// 	public void getAllFtse100Companies(){

// 		List<Ftse100> companies = new ArrayList<>() {
// 			{
// 				add(new Ftse100("Mining PLC", "MG", "Mining and materials", 44.00, new BigInteger("2000000000"), 20.50, 30.50, 8.50, 20.50));
// 				add(new Ftse100("HairSure PLC", "HSE", "Beauty and Haircare", 517.60, new BigInteger("1842100000"), 2.50, 1.57, 38.67, 14.70));
	
// 			}
// 		};

// 		for (Ftse100 company : companies) {
// 			restTemplate.postForEntity("/companies", company, Ftse100.class);
// 		}

// 		ResponseEntity<Ftse100[]> response = restTemplate.getForEntity("/companies", Ftse100[].class);
// 		Ftse100[] responseIOUs = response.getBody();

// 		assertEquals(HttpStatus.OK, response.getStatusCode());
// 		assertNotNull(responseIOUs);
// 		assertTrue(companies.size() <= responseIOUs.length);
// 		//remember to add asserts + error and exception handling - an exception should be throw if some of the fields are empty etc
// 		// test passes but how do I call my getAllFtse100 companies method and usewhilst still adhering to the rules of TDD 

// 	}

// 	@Test
// 	public void testCreateFtse100() {
// 		Ftse100 company = new Ftse100("Manufacture Metal PLC", "MML", "General Industrial", 24.50, new BigInteger("3800000000"), 8.17, 3.57, 28.67, 44.20);
// 		ResponseEntity<Ftse100> response = restTemplate.postForEntity("/companies", company, Ftse100.class);


// 		assertEquals(HttpStatus.CREATED, response.getStatusCode());
// 		assertNotNull(response.getBody());
// 		assertNotNull(response.getBody().getTickerSymbol());
// 	}
// }

// 	// @Test
// 	// @DisplayName("get specific FTSE 100 company")

// 	// @Test
// 	// @DisplayName("add a company to the FTSE 100")

// 	// @Test
// 	// @DisplayName("remove a company from the FTSE 100")

// 	// @Test
// 	// @DisplayName("update information of a FTSE 100 company")
// 	// remeber to test that exceptions are also thrown!

