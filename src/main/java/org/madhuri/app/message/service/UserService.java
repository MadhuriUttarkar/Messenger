package org.madhuri.app.message.service;

import java.util.List;

import org.madhuri.app.message.dao.ChannelDAO;
import org.madhuri.app.message.dao.UserDAO;
import org.madhuri.app.message.model.Channel;
import org.madhuri.app.message.model.User;

public class UserService {

	private UserDAO userDAO = new UserDAO();
	private ChannelDAO channelDAO = new ChannelDAO();

	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	public User getUserById(Long userId) {
		return userDAO.getUserById(userId);		
	}

	public User getUser(Long userId) {
		return userDAO.getUser(userId);
	}
	public void addUserToChannel(Long userId, Long channelId) {
        User user = userDAO.getUser(userId);
        Channel channel = channelDAO.getChannel(channelId);

        if (user != null && channel != null) {
            channel.addUser(user);
            channelDAO.updateChannel(channel);
        } else {
            // Handle error conditions, e.g., user or channel not found
            throw new IllegalArgumentException("User or channel not found");
        }
    }
}
