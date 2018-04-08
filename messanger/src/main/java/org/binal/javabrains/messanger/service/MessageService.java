/**
 * 
 */
package org.binal.javabrains.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.binal.javabrains.messanger.database.DatabaseClass;
import org.binal.javabrains.messanger.model.Message;

/**
 * @author Binal
 *
 */
public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1L, "hello world", "binal"));
		messages.put(2L, new Message(2L, "hello jersey", "binal"));
	}

	public List<Message> getAllMessages() {
		// Message m1 = new Message(1L, "hello world", "binal");
		// Message m2 = new Message(2L, "hello jersey", "binal");
		// List<Message> messages = new ArrayList<Message>();
		// messages.add(m1);
		// messages.add(m2);
		// return messages;

		return new ArrayList<Message>(messages.values());

	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;

	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
