
package org.madhuri.app.message.dao;

import org.madhuri.app.message.model.Channel;
import org.madhuri.app.message.model.User;

public class ChannelUserDAO {
	
private ChannelDAO channelDAO = new ChannelDAO();
    
    public User addUserToChannel(User user, Channel channel) {
    	try {
            if (user == null || channel == null) {
                throw new IllegalArgumentException("User and channel must not be null");
            }

            channel.addUser(user);
            channelDAO.updateChannel(channel);
            
            return user;
        } catch (Exception e) {
            throw new RuntimeException("Failed to add user to channel: " + e.getMessage(), e);
        }
    }

	public Channel getChannelById(Long channelId) {
		
		Channel channel = null;
		return channel;
		
	}
}
