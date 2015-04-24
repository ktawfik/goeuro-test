/**
 * This is a generic utility class that map json objects to java objects
 * @author Karim
 *
 */
package com.goeuro.util;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.TypeFactory;

public class JsonMapper {

	/**
	 * This method parse the json array object and return list of the passed class type.
	 * @param json
	 * @param c
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static Object parseList(String json, Class<?>c) throws InstantiationException, IllegalAccessException, JsonParseException, JsonMappingException, IOException{
		if(json == null || json.isEmpty()){
			return null;
		}
		
		Object o;
		ObjectMapper mapper = new ObjectMapper();
		// construct a collection type --> List<c>, in our sample application will be List<City>,
		CollectionType ct = TypeFactory.defaultInstance().constructCollectionType(List.class,  c);
		o = mapper.readValue(json, ct);
		return o;
	}
}
