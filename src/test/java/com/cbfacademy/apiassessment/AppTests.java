package com.cbfacademy.apiassessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

	// @Test
	// @Description("/greeting endpoint returns expected response for default name")
	// public void greeting_ExpectedResponseWithDefaultName() {
	// 	ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);

	// 	assertEquals(200, response.getStatusCode().value());
	// 	assertEquals("Hello World", response.getBody());
	// }

	// @Test
	// @Description("/greeting endpoint returns expected response for specified name parameter")
	// public void greeting_ExpectedResponseWithNameParam() {
	// 	ResponseEntity<String> response = restTemplate.getForEntity(base.toString() + "?name=John", String.class);

	// 	assertEquals(200, response.getStatusCode().value());
	// 	assertEquals("Hello John", response.getBody());
	}

	// @Test
	// @DisplayName("get list of FTSE 100 companies")

	// @Test
	// @DisplayName("get specific FTSE 100 company")

	// @Test
	// @DisplayName("add a company to the FTSE 100")

	// @Test
	// @DisplayName("remove a company from the FTSE 100")

	// @Test
	// @DisplayName("update information of a FTSE 100 company")
	// remeber to test that exceptions are also thrown!
}
