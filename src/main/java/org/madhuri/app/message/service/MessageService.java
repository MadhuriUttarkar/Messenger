package org.madhuri.app.message.service;

import java.util.List;
import org.madhuri.app.message.dao.MessageDAO;
import org.madhuri.app.message.model.Message;


public class MessageService {

    private MessageDAO messageDAO=new MessageDAO();
    
    public MessageService()
    {
    	
    }
    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }
    
    
}
