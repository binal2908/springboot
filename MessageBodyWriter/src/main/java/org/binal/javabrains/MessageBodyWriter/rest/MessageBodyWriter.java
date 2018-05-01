/**
 * 
 */
package org.binal.javabrains.MessageBodyWriter.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

/**
 * @author Binal
 *
 */
@Provider
//here we tell that it will covert the date to mediaType text_plain
@Produces(MediaType.TEXT_PLAIN)
public class MessageBodyWriter implements javax.ws.rs.ext.MessageBodyWriter<Date>{

	@Override
	public boolean isWriteable(Class<?> inputType, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		//the below method will check whether inputType is of type date then send true else it sends false
		return Date.class.isAssignableFrom(inputType);
	}

	@Override
	public long getSize(Date date, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		
		return -1;
	}

	@Override
	public void writeTo(Date date, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream out) throws IOException,
			WebApplicationException {
		out.write(date.toString().getBytes());
		
	}

}
