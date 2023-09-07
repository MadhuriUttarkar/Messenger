package org.madhuri.app.message.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.madhuri.app.message.model.Channel;
import org.madhuri.app.message.model.Message;

import org.madhuri.app.message.util.HibernateUtil;

public class MessageDAO {

	public List<Message> getAllMessages() {
		Session session = HibernateUtil.getSession();
		Query<Message> query = session.createQuery("from Message", Message.class);
		List<Message> messages = query.list();
		session.close();
		return messages;
	}

	public Message addMessage(Message msg) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(msg); // Save the new message entity
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return msg;
	}

	public void deleteMessage(long id) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Message message = session.get(Message.class, id);
			if (message != null) {
				session.delete(message); // Delete the group entity
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public Message getMessageById(long id) {
		Session session = HibernateUtil.getSession();
		Message message = session.get(Message.class, id);
		session.close();
		return message;
	}

	public Channel getChannelById(long channelId) {
		Session session = HibernateUtil.getSession();
		Channel channel = session.get(Channel.class, channelId);
		session.close();
		return channel;
	}

	public Message addMessageToChannel(long channelId, Message msg) {
		try (Session session = HibernateUtil.getSession()) {
			Transaction transaction = session.beginTransaction();

			// Retrieve the channel by its ID
			Channel channel = session.get(Channel.class, channelId);

			if (channel != null) {
				// Set the channelId in the message
				msg.setChannelId(channelId);

				// Add the message to the channel
				channel.getMessages().add(msg);

				// Save the message and update the channel
				session.save(msg);
				session.update(channel);

				transaction.commit();

				return msg;
			} else {
				throw new IllegalArgumentException("Channel not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to add message to channel");
		}
	}

}
