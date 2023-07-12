package org.madhuri.app.message.mockdata;
import java.util.HashMap;
import java.util.Map;

import org.madhuri.app.message.model.Msg;
public class MockDataClass {
	
	private static Map<Long,Msg>messages=new HashMap<>();
	
	private static Map<String, org.madhuri.app.message.model.Profile> profiles=new HashMap<>();
	
	public static Map<Long, Msg> getMessages()
	{
		return messages;
	}
	public static Map<String, org.madhuri.app.message.model.Profile> getProfiles()
	{
		return profiles;
	}
	
}
