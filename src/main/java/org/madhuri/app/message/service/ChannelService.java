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
}
