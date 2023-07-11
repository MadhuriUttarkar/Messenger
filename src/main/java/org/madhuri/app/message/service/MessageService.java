package org.madhuri.app.message.service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.madhuri.app.message.database.DatabaseClass;
import org.madhuri.app.message.exception.DataNotFoundException;
import org.madhuri.app.message.model.Msg;
public class MessageService {
	
	private Map<Long,Msg>messages=DatabaseClass.getMessages();
	
	public MessageService()
	{
		messages.put(1L, new Msg(1,"Hello World!","Madhuri"));
		messages.put(2L, new Msg(2,"Hello Jersey!","Madhuri"));
	}
	
	public List<Msg> getAllMessages()
	{
		return new ArrayList <Msg>(messages.values());
	}
	
	public List<Msg> getAllMessagesForYear(int year)
	{
		List<Msg>messagesForYear=new ArrayList<>();
		Calendar cal=Calendar.getInstance();
		for(Msg msg:messages.values())
		{
			cal.setTime(msg.getCreated());
			if(cal.get(Calendar.YEAR)==year)
			{
				messagesForYear.add(msg);
			}
		}
		return messagesForYear;
	}
	
	public List<Msg> getAllMessagesPaginated(int start, int size)
	{
		ArrayList<Msg> list=new ArrayList<Msg>(messages.values());
		if(start+size>list.size())return new ArrayList<Msg>();
		return list.subList(start,start+size);
	}
	
	
	public Msg getMessage(long id)
	{
		Msg message=messages.get(id);
		if(message==null)
		{
			throw new DataNotFoundException("Message with id " + id + "not found");
		}
		return message;
	}
	public Msg addMessage(Msg msg)
	{
		msg.setId(messages.size()+1);
		messages.put(msg.getId(),msg);
		return msg;
	}
	public Msg updateMessage(Msg msg)
	{
		if(msg.getId()<=0)
		{
			return null;
		}
		messages.put(msg.getId(),msg);
		return msg;
	}
	public Msg removeMessage(long id)
	{
		return messages.remove(id);
	}

}
