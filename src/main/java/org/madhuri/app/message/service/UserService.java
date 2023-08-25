
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
	public User getUserById(long id) {
		User user = userDAO.getUserById(id);

		if (user == null) {
			throw new IllegalArgumentException("User with ID " + id + " not found");
		}

		return user;

	}

	public User getUserById(Long userId) {
		User user = null;
		return user;
	}
	
	public User addUserToChannel(Long userId, Long channelId) {
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
    }

	public User updateUser(long id, User updatedUser) {
		try {
            User existingUser = userDAO.getUserById(id);

            if (existingUser != null) {
                existingUser.setName(updatedUser.getName());
                userDAO.updateUser(existingUser);
                return existingUser;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Failed to update user: " + e.getMessage(), e);
        }
    }
}
