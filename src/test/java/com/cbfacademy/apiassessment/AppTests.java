
package com.cbfacademy.apiassessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;

import com.cbfacademy.apiassessment.bubblesortalgo.BubbleSortAlgo;
import com.cbfacademy.apiassessment.datamodel.Ftse100;
import com.google.gson.Gson;

import net.minidev.json.JSONArray;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppTests {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeEach
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/greeting");
	}

	@Test
	@Description("/greeting endpoint returns expected response for default name")
	public void greeting_ExpectedResponseWithDefaultName() {
		ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);

		assertEquals(200, response.getStatusCode().value());
		assertEquals("Hello World", response.getBody());
	}

	@Test
	@Description("/greeting endpoint returns expected response for specified name parameter")
	public void greeting_ExpectedResponseWithNameParam() {
		ResponseEntity<String> response = restTemplate.getForEntity(base.toString() + "?name=John", String.class);

		assertEquals(200, response.getStatusCode().value());
		assertEquals("Hello John", response.getBody());
	}

	@Test
	@Description("Reading from json file and returning list of objects")
	public void readFromJsonArray() throws IOException {

		final String jsonTestFile = "src/test/resources/ftseTest.json";

		// if file doesn't exist throw IO exception 

		Ftse100JsonFileHandler fileHandler = new Ftse100JsonFileHandler(jsonTestFile);
		List<Ftse100> actualCompaniesList = fileHandler.readFtse100JsonFile(jsonTestFile);

		assertNotNull(actualCompaniesList);
		assertFalse(actualCompaniesList.isEmpty());
		}


	@Test
	@Description("Writing from java objects back to json file")
	public void writeToJsonFile() throws IOException {

		final String jsonTestFile = "src/test/resources/ftseTest.json";
		
		// if !(jsonTestFile.exists()){
			// if file doesnt exist throw exception here 

			List<Ftse100> expectedCompanies = new ArrayList<>(){
			{
				add (new Ftse100("Endeavour Plc", "EDV", "Precious Metals and Mining", 1678.0, new BigInteger("4333000000"), -17.22, 1.52, 27.23, 23.09));
				add (new Ftse100("ConvaTec Group Plc", "CTEC", "Medical Equipment and Services", 201.08, new BigInteger("4554000000"), 67.67, 3.11, 90.12, 16.6));
				add (new Ftse100("BAE Systems Plc", "BA", "Aerospace and Defense", 1086.0, new BigInteger("32770000000"), 16.85, 3.04, 61.08, 31.6));
				add (new Ftse100("Unite Group Plc", "UTG", "Real Estate", 854.5, new BigInteger("39840000000"), 26.5, 0.99, 35.73, 15.5));
			}
		};

		Ftse100JsonFileHandler fileHandler = new Ftse100JsonFileHandler(jsonTestFile);
		fileHandler.ftse100WriteToJsonFile(jsonTestFile, expectedCompanies);

		List<Ftse100> actualCompanies = fileHandler.readFtse100JsonFile(jsonTestFile);

		assertTrue(new File(jsonTestFile).exists());
		assertEquals(expectedCompanies, actualCompanies);

				// doesnt work currently - keep springting null
		// my have to compare them directly due to data structure 
		
		}

	@Test 
	@Description("Returns a list of company names, ticker symbols and stock prices")
	public void bubbleSortAlgorithm(){

		List<Ftse100> companies = new ArrayList<>(){

			{
				add (new Ftse100("Endeavour Plc", "EDV", "Precious Metals and Mining", 1678.0, new BigInteger("4333000000"), -17.22, 1.52, 27.23, 23.09));
				add (new Ftse100("ConvaTec Group Plc", "CTEC", "Medical Equipment and Services", 201.08, new BigInteger("4554000000"), 67.67, 3.11, 90.12, 16.6));
				add (new Ftse100("BAE Systems Plc", "BA", "Aerospace and Defense", 1086.0, new BigInteger("32770000000"), 16.85, 3.04, 61.08, 31.6));
				add (new Ftse100("Unite Group Plc", "UTG", "Real Estate", 854.5, new BigInteger("39840000000"), 26.5, 0.99, 35.73, 15.5));
			}
		};

		List<String> sortedPricesExpectedOutput = new ArrayList<>(){
			{
				add (new String("ConvaTec Group Plc" + " (" + "CTEC" + "): " + "201.08" + " GBX"));
				add (new String("Unite Group Plc" + " (" + "UTG" + "): " + "854.5" + " GBX"));
				add (new String("BAE Systems Plc" + " (" + "BA" + "): " + "1086.0" + " GBX"));
				add (new String("Endeavour Plc" + " (" + "EDV" + "): " + "1678.0" + " GBX"));
			}
		};

		assertEquals(sortedPricesExpectedOutput, BubbleSortAlgo.bubbleSortStockPrices(companies));
			}
		


}



// 	// TESTS I WANT TO WRITE 
// 	// reading and writing from a file 

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

// asserts and exception handling - remember to throw them

		// List<Ftse100> expectedCompaniesList = new ArrayList<>(){
		// 	{
		// 		add (new Ftse100("Endeavour Plc", "EDV", "Precious Metals and Mining", 1678.0, new BigInteger("4333000000"), -17.22, 1.52, 27.23, 23.09));
		// 		add (new Ftse100("ConvaTec Group Plc", "CTEC", "Medical Equipment and Services", 201.08, new BigInteger("4554000000"), 67.67, 3.11, 90.12, 16.6));
		// 		add (new Ftse100("BAE Systems Plc", "BA", "Aerospace and Defense", 1086.0, new BigInteger("32770000000"), 16.85, 3.04, 61.08, 31.6));
		// 		add (new Ftse100("Unite Group Plc", "UTG", "Real Estate", 854.5, new BigInteger("39840000000"), 26.5, 0.99, 35.73, 15.5));
		// 	}
			
		// }; 

	// @Test
	// @DisplayName("get specific FTSE 100 company")

// 	// @Test
// 	// @DisplayName("add a company to the FTSE 100")

// 	// @Test
// 	// @DisplayName("remove a company from the FTSE 100")

// 	// @Test
// 	// @DisplayName("update information of a FTSE 100 company")
// 	// remeber to test that exceptions are also thrown!

