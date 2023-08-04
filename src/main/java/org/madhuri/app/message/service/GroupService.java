package org.madhuri.app.message.service;

import java.util.List;
import org.madhuri.app.message.dao.GroupDAO;
import org.madhuri.app.message.model.MessageGroup;

public class GroupService {
	
	private GroupDAO groupDAO = new GroupDAO();
	public List<MessageGroup> getGroups() {
        List<MessageGroup> groupMessages = groupDAO.getgroups();
        return groupMessages;
    }
}

