package org.madhuri.app.message.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.madhuri.app.message.model.ChannelUser;
import org.madhuri.app.message.util.HibernateUtil;

public class ChannelUserDAO {

	public void addUserToChannel(Long userId, Long channelId) {
		try {
			if (userId == null || channelId == null) {
				throw new IllegalArgumentException("User ID and channel ID must not be null");
			}

			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();

			ChannelUser channelUser = new ChannelUser();
			channelUser.setUserId(userId);
			channelUser.setChannelId(channelId);

			session.save(channelUser);

			transaction.commit();
			session.close();
		} catch (Exception e) {
			throw new RuntimeException("Failed to add user to channel: " + e.getMessage(), e);
		}
	}
	
}
