package org.jahan.apitest.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.jahan.apitest.messenger.model.Message;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	//private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}

}
