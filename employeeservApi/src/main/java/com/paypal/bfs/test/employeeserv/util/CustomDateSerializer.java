package com.paypal.bfs.test.employeeserv.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;




public class CustomDateSerializer extends StdDeserializer<Date> {
	 

	public CustomDateSerializer() {
		this(null);
	}

	public CustomDateSerializer(Class t) {
		super(t);
	}

	@Override 
	public Date deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException { 
		String date = jsonparser.getText(); 
		try { 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			return sdf.parse(date); 
		} 
		catch (Exception e) {
			e.printStackTrace(); 
		}
		return null;
	}
	

}