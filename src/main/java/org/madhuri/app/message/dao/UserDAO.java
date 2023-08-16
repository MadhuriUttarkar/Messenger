package org.madhuri.app.message.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.madhuri.app.message.model.Channel;
import org.madhuri.app.message.model.User;
import org.madhuri.app.message.util.HibernateUtil;

public class UserDAO {

	public List<User> getUsers() {
		Session session = HibernateUtil.getSession();
		Query<User> query = session.createQuery("from User", User.class);
		List<User> allUsers = query.list();
		session.close();
		return allUsers;
	}

	public User getUserById(Long userId) {
		Session session = HibernateUtil.getSession();
		User user = session.get(User.class, userId);
		session.close();
		return user;

	}

}
