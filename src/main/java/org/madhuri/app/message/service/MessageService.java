package org.madhuri.app.message.service;

import java.util.List;
import org.madhuri.app.message.dao.MessageDAO;
import org.madhuri.app.message.model.Message;


public class MessageService {

    private MessageDAO messageDAO=new MessageDAO();
    
    
    public List<Message> getAllMessages() {
    	List<Message> allMessages = messageDAO.getAllMessages();
        return allMessages;
    }
    

    public Message addMessage(Message msg) {
    	
        return messageDAO.addMessage(msg);
    }


	public Message getMessageById(long messageId) {
		return messageDAO.getMessageById(messageId);
	}


	public List<Message> getMessagesForUsername(String username) {
		List<Message> userMessages = messageDAO.getMessagesByUsername(username);
        return userMessages;

	}

}
