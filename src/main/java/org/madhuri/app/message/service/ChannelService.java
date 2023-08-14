package org.madhuri.app.message.service;

import java.util.List;
import org.madhuri.app.message.dao.ChannelDAO;
import org.madhuri.app.message.model.Channel;

public class ChannelService {

	private ChannelDAO channelDAO = new ChannelDAO();

	public List<Channel> getChannels() {
		List<Channel> channelMessages = channelDAO.getchannels();
		return channelMessages;
	}

	public Channel createChannel(Channel channel) {
		Channel createdChannel = channelDAO.createChannel(channel);
		return createdChannel;

	}

	public void deleteChannel(long id) {
		channelDAO.deleteChannel(id);
	}

	

	public Channel getChannelById(long id) {
		return channelDAO.getChannelById(id);
	}

	public Channel updateChannel(Channel updatedChannel) {
		if (updatedChannel.getId() == null) {
            throw new IllegalArgumentException("Channel ID cannot be null");
        }

        // Check if the channel exists
        Channel existingChannel = channelDAO.getChannelById(updatedChannel.getId());
        if (existingChannel == null) {
            throw new IllegalArgumentException("Channel with ID " + updatedChannel.getId() + " not found");
        }

        // Update the fields of the existing channel with the updated channel's data
        existingChannel.setName(updatedChannel.getName());
        existingChannel.setWelcomeMessage(updatedChannel.getWelcomeMessage());
        existingChannel.setUpdatedAt(updatedChannel.getUpdatedAt());
        existingChannel.setUpdatedBy(updatedChannel.getUpdatedBy());
        return channelDAO.updateChannel(existingChannel);		
	}
}
