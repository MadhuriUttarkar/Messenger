
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

	public User createUser(User newUser) {
		return userDAO.addUser(newUser);

	}

	public void deleteUser(long id) {
		userDAO.deleteUser(id);

	}
	
	/*public User addUserToChannel(Long userId, Long channelId) {
		try {
            User user = userDAO.getUserById(userId);
            Channel channel = channelDAO.getChannelById(channelId);

            if (user != null && channel != null) {
                channel.addUser(user);
                channelDAO.updateChannel(channel);
                return user;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Failed to add user to channel: " + e.getMessage(), e);
        }
    }*/

}