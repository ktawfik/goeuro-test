package com.goeuro.util;

/**
 * @author Karim
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class GoEuroURLReader {

	public static final String DEFAULT_API_ENDPOINT = "http://api.goeuro.com/api/v2/position/suggest/en";
	public static final String REQUEST_METHOD="GET";
	
	public static InputStream getInputStream(String apiEndPoint, String reqMethod){
		URL url;
		HttpURLConnection conn;
		BufferedReader br;
		try {
			url = new URL(apiEndPoint);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestMethod(reqMethod);
			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			return conn.getInputStream();
		} catch (MalformedURLException e) {
			System.err.println("API Endpoint is not a valid url");
			System.err.println(e.getMessage());
		} catch (ProtocolException e) {
			System.err.println("Invalid request method:" + reqMethod);
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println("Error occurred while reading data from the URL.");
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	
	public static InputStream getInputStream(String apiEndPoint){
		return getInputStream(apiEndPoint, REQUEST_METHOD);
	}
	
	
}
