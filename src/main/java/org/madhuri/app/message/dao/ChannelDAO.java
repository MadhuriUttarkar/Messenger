package org.madhuri.app.message.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.madhuri.app.message.model.Channel;
import org.madhuri.app.message.util.HibernateUtil;

public class ChannelDAO {

	public List<Channel> getchannels() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("from Channel");
		List<Channel> channelmessages = query.list();
		session.close();
		return channelmessages;
	}

	public Channel createChannel(Channel channel) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(channel); // Save the new group entity
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return channel;
	}

	public void deleteChannel(long id) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Channel channel = session.get(Channel.class, id);
			if (channel != null) {
				session.delete(channel); // Delete the group entity
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
}