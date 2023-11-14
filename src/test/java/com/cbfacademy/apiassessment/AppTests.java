
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
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
	@Description("Reading from json file and returning list of objects")
	public void readFromJsonArray() throws IOException {

		final String jsonTestFile = "src/test/resources/ftseTest.json"; 

		Ftse100JsonFileHandler fileHandler = new Ftse100JsonFileHandler();
		List<Ftse100> actualCompaniesList = fileHandler.readFtse100JsonFile(jsonTestFile);

		assertNotNull(actualCompaniesList);
		assertFalse(actualCompaniesList.isEmpty());
		}


	@Test
	@Description("Writing to json file and comparing output")
	public void writeToJsonFile() throws IOException {

		final String jsonTestFile = "src/test/resources/ftseTest.json";

			List<Ftse100> expectedCompanies = new ArrayList<>(){
			{
				add (new Ftse100("Endeavour Plc", "EDV", "Precious Metals and Mining", 1678.0, 4333000000L, -17.22, 1.52, 27.23, 23.09));
				add (new Ftse100("ConvaTec Group Plc", "CTEC", "Medical Equipment and Services", 201.08, 4554000000L, 67.67, 3.11, 90.12, 16.6));
				add (new Ftse100("BAE Systems Plc", "BA", "Aerospace and Defense", 1086.0, 32770000000L, 16.85, 3.04, 61.08, 31.6));
				add (new Ftse100("Unite Group Plc", "UTG", "Real Estate", 854.5, 3984000000L, 26.5, 0.99, 35.73, 15.5));
			}
		};

		Ftse100JsonFileHandler fileHandler = new Ftse100JsonFileHandler();
		fileHandler.ftse100WriteToJsonFile(jsonTestFile, expectedCompanies);

		List<Ftse100> actualCompanies = fileHandler.readFtse100JsonFile(jsonTestFile);
		
		assertTrue(new File(jsonTestFile).exists());
		assertEquals(expectedCompanies, actualCompanies);

	}
	
		// getting a return of null for this test 

	@Test 
	@Description("Returns a list of company names, ticker symbols and stock prices")
	public void bubbleSortAlgorithm(){

		List<Ftse100> companies = new ArrayList<>(){

			{
				add (new Ftse100("Endeavour Plc", "EDV", "Precious Metals and Mining", 1678.0, 4333000000L, -17.22, 1.52, 27.23, 23.09));
				add (new Ftse100("ConvaTec Group Plc", "CTEC", "Medical Equipment and Services", 201.08, 4554000000L, 67.67, 3.11, 90.12, 16.6));
				add (new Ftse100("BAE Systems Plc", "BA", "Aerospace and Defense", 1086.0, 32770000000L, 16.85, 3.04, 61.08, 31.6));
				add (new Ftse100("Unite Group Plc", "UTG", "Real Estate", 854.5, 39840000000L, 26.5, 0.99, 35.73, 15.5));
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
// writing from a file 
// rest template also 
// exception handling in file reading 

	// @Test
	// @DisplayName("get specific FTSE 100 company")

// 	// @Test
// 	// @DisplayName("add a company to the FTSE 100")

// 	// @Test
// 	// @DisplayName("remove a company from the FTSE 100")

// 	// @Test
// 	// @DisplayName("update information of a FTSE 100 company")


