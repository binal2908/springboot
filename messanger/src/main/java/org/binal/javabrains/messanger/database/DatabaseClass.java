/**
 * 
 */
package org.binal.javabrains.messanger.database;

import java.util.HashMap;
import java.util.Map;

import org.binal.javabrains.messanger.model.Message;
import org.binal.javabrains.messanger.model.Profile;

/**
 * @author Binal
 *
 */
public class DatabaseClass {
	
	//These are not thread-safe.It allows concurrent use
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<Long, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}

}
