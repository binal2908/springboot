/**
 * 
 */
package org.binal.javabrains.paramsNew;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

/**
 * @author Binal
 *
 */

@Provider
public class MyDateConverterProvider implements ParamConverterProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ws.rs.ext.ParamConverterProvider#getConverter(java.lang.Class,
	 * java.lang.reflect.Type, java.lang.annotation.Annotation[])
	 */
	@Override
	public <T> ParamConverter<T> getConverter(final Class<T> rawType,
			Type genericType, Annotation[] annotations) {
		if (rawType.getName().equals(MyDate.class.getName())) {
			return new ParamConverter<T>() {
				@Override
				public T fromString(String value) {
					Calendar calendar = Calendar.getInstance();
					if ("tommorrow".equals(value)) {
						calendar.add(Calendar.DATE, 1);
					} else if ("yesterday".equals(value)) {
						calendar.add(Calendar.DATE, -1);
					}

					MyDate myDate = new MyDate();
					myDate.setDate(calendar.get(Calendar.DATE));
					myDate.setMonth(calendar.get(Calendar.MONTH));
					myDate.setYear(calendar.get(Calendar.YEAR));

					return rawType.cast(myDate);
				}

				@Override
				public String toString(T myBean) {
					if (myBean == null) {
						return null;
					}
					return myBean.toString();
				}
			};
		}
		return null;
	}

}
