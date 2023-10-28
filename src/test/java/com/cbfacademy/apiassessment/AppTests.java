package com.cbfacademy.apiassessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
		this.base = new URL("http://localhost:" + port + "/companies");
	}

	//use before all annotation to run this before each method (once)
	// come back to my rest templates to ensure rest templates are functioning correctly after implementaiton of service

	@Test
	@DisplayName("/companies endpoint returns the list of FTSE 100 companies")
	public void getAllFtse100Companies(){

		List<Ftse100> companies = new ArrayList<>() {
			{
				add(new Ftse100("Mining PLC", "MG", "Mining and materials", 44.00, new BigInteger("2000000000"), 20.50, 30.50, 8.50, 20.50));
				add(new Ftse100("HairSure PLC", "HSE", "Beauty and Haircare", 517.60, new BigInteger("1842100000"), 2.50, 1.57, 38.67, 14.70));
	
			}
		};

		for (Ftse100 company : companies) {
			restTemplate.postForEntity("/companies", company, Ftse100.class);
		}

		ResponseEntity<Ftse100[]> response = restTemplate.getForEntity("/companies", Ftse100[].class);
		Ftse100[] responseIOUs = response.getBody();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(responseIOUs);
		assertTrue(companies.size() <= responseIOUs.length);
		//remember to add asserts + error and exception handling - an exception should be throw if some of the fields are empty etc
		// test passes but how do I call my getAllFtse100 companies method and usewhilst still adhering to the rules of TDD (repeatble and isolated) 

	}

	@Test
	public void testCreateFtse100() {
		Ftse100 company = new Ftse100("Manufacture Metal PLC", "MML", "General Industrial", 24.50, new BigInteger("3800000000"), 8.17, 3.57, 28.67, 44.20);
		ResponseEntity<Ftse100> response = restTemplate.postForEntity("/companies", company, Ftse100.class);


		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertNotNull(response.getBody());
		assertNotNull(response.getBody().getTickerSymbol());
	}
}

// 	// @Test
// 	// @DisplayName("get specific FTSE 100 company")

// 	// @Test
// 	// @DisplayName("add a company to the FTSE 100")

// 	// @Test
// 	// @DisplayName("remove a company from the FTSE 100")

// 	// @Test
// 	// @DisplayName("update information of a FTSE 100 company")
// 	// remeber to test that exceptions are also thrown!

