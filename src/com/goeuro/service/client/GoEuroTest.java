package com.goeuro.service.client;

import java.io.IOException;
import java.util.List;

import com.goeuro.model.City;
import com.goeuro.util.CSVFileWriter;
/**
 * this is the entry point class to the application
 * @author Karim
 *
 */
public class GoEuroTest {
	
	// the API endpoint url.
	public static final String API_ENDPOINT="http://api.goeuro.com/api/v2/position/suggest/en/";
	
	public static void main(String[] args) throws Exception {
		GoEuroTest g = new GoEuroTest();
		if(args.length > 0)
			g.go(args[0]);
		else
			System.out.println("invalid parameter passed, can't call with no parameter.");
	}
	
	/**
	 * The entry method to the example logic
	 * @param city, the city name
	 */
	public void go(String city){
		// call the client that access the endpoint url.
		GoEuroSimpleRestClient client = new GoEuroSimpleRestClient();
		// retrieve list of citys from the endpoint url after deserializing it to List of City objects.
		List<City> cityList = client.getDataForCity(city);
		// will construct a csv file with the city name ==> "Berlin.csv"
		CSVFileWriter csvWriter;
		try {
			csvWriter = new CSVFileWriter(city);
			// write the data to the csv file.
			csvWriter.writeData(cityList);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.err.println("Error occurred while writing data to the file");
			e.printStackTrace();
		}
		
	}
	
}
