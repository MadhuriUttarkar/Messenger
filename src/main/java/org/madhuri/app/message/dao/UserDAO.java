package org.madhuri.app.message.dao;

import org.hibernate.Session;
import org.madhuri.app.message.model.User;
import org.madhuri.app.message.util.HibernateUtil;

public class UserDAO {

	public User getUserById(long userId) {
		Session session = HibernateUtil.getSession();
        try {
            return session.get(User.class, userId);
        } finally {
            session.close();
        }
    }
}
