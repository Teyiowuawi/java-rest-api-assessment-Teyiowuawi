
package com.cbfacademy.apiassessment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.context.annotation.Description;
import com.cbfacademy.apiassessment.bubblesortalgo.BubbleSortAlgo;
import com.cbfacademy.apiassessment.datamodel.Ftse100;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppTests {

	@Test
	@Description("Reading from json file and returning list of objects")
	public void readFromJsonArray() throws IOException {

		final String jsonTestFile = "src/test/resources/ftseTest.json"; 

		Ftse100JsonFileHandler fileHandler = new Ftse100JsonFileHandler();
		List<Ftse100> actualCompaniesList = fileHandler.readFtse100JsonFile(jsonTestFile);

		assertNotNull(actualCompaniesList);
		assertFalse(actualCompaniesList.isEmpty());
		}


	// @Test
	// @Description("Writing to json file and comparing output")
	// public void writeToJsonFile() throws IOException {

	// 	final String jsonTestFile = "src/test/resources/ftseTest.json";

	// 		List<Ftse100> expectedCompanies = new ArrayList<>(){
	// 		{
	// 			add (new Ftse100("Endeavour Plc", "EDV", "Precious Metals and Mining", 1678.0, 4333000000L, -17.22, 1.52, 27.23, 23.09));
	// 			add (new Ftse100("ConvaTec Group Plc", "CTEC", "Medical Equipment and Services", 201.08, 4554000000L, 67.67, 3.11, 90.12, 16.6));
	// 			add (new Ftse100("BAE Systems Plc", "BA", "Aerospace and Defense", 1086.0, 32770000000L, 16.85, 3.04, 61.08, 31.6));
	// 			add (new Ftse100("Unite Group Plc", "UTG", "Real Estate", 854.5, 3984000000L, 26.5, 0.99, 35.73, 15.5));
	// 		}
	// 		//  move this outside of the method
	// 		// look at company input here 
	// 		// try to write something!
	// 		// simplify the object I am sending and then try and fix the issue here 
	// 		// running in debug mode the regular test - compare how the test looks like when running through both
	// 		//attempt read first to see if it works 

	// 	};
		
	// 	// Ftse100 company = new Ftse100("ConvaTec Group Plc", "CTEC", "Medical Equipment and Services", 201.08, 4554000000L, 67.67, 3.11, 90.12, 16.6);

	// 	// Ftse100JsonFileHandler fileHandler = new Ftse100JsonFileHandler();
	// 	// fileHandler.ftse100WriteToJsonFile(jsonTestFile, expectedCompanies);
	// 	 Gson gson = new GsonBuilder().setPrettyPrinting().create();

    //             try (Writer writer = new FileWriter(jsonTestFile)){
    //                 gson.toJson(expectedCompanies, writer);
    //             } catch(IOException e) {
    //                 System.out.println("File not found. Please ensure this file is in the correct location and it exists");
    //                 e.printStackTrace();
    //             }

	// 	// List<Ftse100> actualCompanies = fileHandler.readFtse100JsonFile(jsonTestFile);

	// 	assertTrue(new File(jsonTestFile).exists());
	// 	// assertEquals(expectedCompanies, actualCompanies);

	// }

		        // run the write method in my test file to isolate it 
        // using the body 
        //  Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //         try (Writer writer = new FileWriter(file)){
        //             gson.toJson(companies, writer);
        //         } catch(IOException e) {
        //             System.out.println("File not found. Please ensure this file is in the correct location and it exists");
        //             e.printStackTrace();
        //         }
        
        // writing to the file assuming it isn't empty 
		// if all fails after debugging 
// create two different files and then read from one and write to another
// would need to understand why I did that
// the actual list of companies arent even the same size as each other 

	@Test
	@Description("Adding a company to the json file to json file")
	public void fileWritingTest() throws IOException{
		final String jsonTestFile = "src/test/resources/ftseTest.json";

		Ftse100JsonFileHandler fileHandler = new Ftse100JsonFileHandler();
		List<Ftse100> expectedCompanies = fileHandler.readFtse100JsonFile(jsonTestFile);

		Ftse100 newCompany = new Ftse100("New Group Plc", "NG", "Services", 11.11, 4554000000L, 1.11, -1.11, 100.00, 10);

		expectedCompanies.add(newCompany);

		fileHandler.ftse100WriteToJsonFile(jsonTestFile, expectedCompanies);

		List<Ftse100> actualCompanies = fileHandler.readFtse100JsonFile(jsonTestFile);

		assertEquals(expectedCompanies.size(), actualCompanies.size());
	}

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
			// remove repeated code 
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





