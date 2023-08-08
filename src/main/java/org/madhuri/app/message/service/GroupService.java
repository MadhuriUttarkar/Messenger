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

	public MessageGroup createGroup(MessageGroup group) {
		MessageGroup createdGroup = groupDAO.createGroup(group);
		return createdGroup;

	}

	public void deleteGroup(long groupid) {
		groupDAO.deleteGroup(groupid);
	}
}
