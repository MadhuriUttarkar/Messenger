package org.madhuri.app.message.service;

import java.util.List;
import org.madhuri.app.message.dao.ChannelDAO;
import org.madhuri.app.message.model.Channel;
import jakarta.ws.rs.NotFoundException;


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

	public Channel updateChannel(Channel updatedChannel) {
		if (updatedChannel.getId() == null) {
			throw new IllegalArgumentException("Channel ID cannot be null");
		}

		// Check if the channel exists
		Channel existingChannel = channelDAO.getChannelById(updatedChannel.getId());
		if (existingChannel == null) {
			throw new NotFoundException("Channel with ID " + updatedChannel.getId() + " not found");

		}

		// Update the fields of the existing channel with the updated channel's data
		existingChannel.setChannelName(updatedChannel.getChannelName());
		existingChannel.setAdminId(updatedChannel.getAdminId());
		existingChannel.setWelcomeMessage(updatedChannel.getWelcomeMessage());
		existingChannel.setUpdatedAt(updatedChannel.getUpdatedAt());
		existingChannel.setUpdatedBy(updatedChannel.getUpdatedBy());

		return channelDAO.updateChannel(existingChannel);
	}

	public Channel getChannelById(long channelId) {
		Channel channel = channelDAO.getChannelById(channelId);

	    if (channel == null) {
	        throw new NotFoundException("Channel with ID " + channelId + " not found");
	    }

	    return channel;
	}

}
