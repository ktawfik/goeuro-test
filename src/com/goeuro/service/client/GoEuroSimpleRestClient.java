package com.goeuro.service.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.goeuro.model.City;
import com.goeuro.util.GoEuroURLReader;
import com.goeuro.util.JsonMapper;

public class GoEuroSimpleRestClient {
	
	/**
	 * this method reads data from the API url for the pass city
	 * 
	 * @param city String represents the desired city to retrieve data about
	 */
	public List<City> getDataForCity(String city) {
		List<City> cityList = null;
		if (city == null || city.isEmpty()) {
			System.out.println("Invalid data sent, city name can't be null or empty");
			return cityList;
		}
		BufferedReader br;
		try {
			InputStreamReader in = new InputStreamReader(GoEuroURLReader.getInputStream(GoEuroURLReader.DEFAULT_API_ENDPOINT + "/" + city));
			br = new BufferedReader(in);
			String tmpStr = "";
			StringBuilder jsonStr = new StringBuilder();
			while ((tmpStr = br.readLine()) != null) {
				jsonStr.append(tmpStr);
			}
			System.out.println("successfully read the data from the url.");
			cityList = (List<City>)JsonMapper.parseList(jsonStr.toString(), City.class);
			System.out.println("successfully parsed the json object to List of objects");
		} catch (IOException e) {
			System.err.println("Error occurred while reading data from the URL.");
			System.err.println(e.getMessage());
		} catch (InstantiationException | IllegalAccessException e) {
			System.err.println("Error occurred while parsing the json object to List of City");
			System.err.println(e.getMessage());
		}
		return cityList;
	}

}
