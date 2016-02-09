package com.coding.springservice.response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import au.com.bytecode.opencsv.CSVWriter;

public class CustomMessageConverter extends AbstractHttpMessageConverter<CustomResponse> {
	public static final MediaType MEDIA_TYPE = new MediaType("text", "csv", Charset.forName("utf-8"));
	   
	public CustomMessageConverter() {
	       super(MEDIA_TYPE);
	   }
	@Override
	protected CustomResponse readInternal(Class<? extends CustomResponse> arg0, HttpInputMessage arg1)
			throws IOException, HttpMessageNotReadableException {
		
		return null;
	}

	@Override
	protected boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void writeInternal(CustomResponse response, HttpOutputMessage output)
			throws IOException, HttpMessageNotWritableException {
		 output.getHeaders().setContentType(MEDIA_TYPE);
	       output.getHeaders().set("Content-Disposition", "attachment; filename=\"" + response.getId() + "\"");
	       OutputStream out = output.getBody();
	       CSVWriter writer = new CSVWriter(new OutputStreamWriter(out), '\u0009');
	       HashMap allRecords = response.getRecords();
	       Set keys  = allRecords.keySet();
	       Iterator valIter = keys.iterator();
	       while (valIter.hasNext())
	       {    String key =  (String)valIter.next();
	            Integer value =  (Integer)allRecords.get(key);
	            String[] arry = new String [2];
	            arry[0] = key; 
	            arry[1] = value.toString();
	            writer.writeNext(arry);
	       }
	       writer.close();
		
	}

}
