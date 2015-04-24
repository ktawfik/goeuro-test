package com.goeuro.model;

import org.codehaus.jackson.annotate.JsonProperty;
/**
 * This a simple POJO class that represents the City object that represents 1 unit of the json array returned from the API call.
 * 
 * I've decided to use json annotation to map the member variables with the fields names in the json object to be more clearer.
 * @author Karim
 *
 */
public class City{
	@JsonProperty("_id")
	private long id;
	
	@JsonProperty("key")
	private String key;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("fullName")
	private String fullName; 
	
	@JsonProperty("iata_airport_code")
	private String iata_airport_code;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("locationId")
	private long location_id;
	
	@JsonProperty("inEurope")
	private boolean inEurope;
	
	@JsonProperty("countryCode")
	private String countryCode;
	
	@JsonProperty("distance")
	private double distance;
	
	@JsonProperty("coreCountry")
	private boolean  coreCountry;
	
	@JsonProperty("geo_position")
	private GeoLocation geoPosition;
	
	/**
	 * this is the class that represents the GeoLocation coordinates (longitude, latitude).
	 * I've intentionally created it as inner class as this is the best way to live in -in the scope of this simple application-, it can't be presented 
	 * as a stand alone object. 
	 * @author Karim
	 *
	 */
	private class GeoLocation{
		public GeoLocation(){}

		private double latitude;
		private double longitude;
		public double getLatitude() {
			return latitude;
		}
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		public double getLongitude() {
			return longitude;
		}
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
	}
	public long get_id() {
		return id;
	}
	public void set_id(long _id) {
		this.id = _id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getIata_airport_code() {
		return iata_airport_code;
	}
	public void setIata_airport_code(String iata_airport_code) {
		this.iata_airport_code = iata_airport_code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getLocation_id() {
		return location_id;
	}
	public void setLocation_id(long location_id) {
		this.location_id = location_id;
	}
	public boolean isInEurope() {
		return inEurope;
	}
	public void setInEurope(boolean inEurope) {
		this.inEurope = inEurope;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public boolean isCoreCountry() {
		return coreCountry;
	}
	public void setCoreCountry(boolean coreCountry) {
		this.coreCountry = coreCountry;
	}
	public GeoLocation getGeo_position() {
		return geoPosition;
	}
	public void setGeo_position(GeoLocation geoPosition) {
		this.geoPosition = geoPosition;
	}
	
	public String toString(){
		return id+"," + name+","+type +","+geoPosition.latitude + ","+geoPosition.longitude; 
	}
}
