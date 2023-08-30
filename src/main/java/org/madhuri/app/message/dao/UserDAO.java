package org.madhuri.app.message.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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

	public User addUser(User newUser) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(newUser);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
	            session.close();
		}
		return newUser;
	}

	public void deleteUser(long id) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			User user = session.get(User.class, id);
			if (user != null) {
				session.delete(user);
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

	public User getUserById(long userId) {
		Session session = HibernateUtil.getSession();
		User user = session.get(User.class, userId);
		session.close();
		return user;
	}

	public void updateUser(User existingUser) {
		Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            existingUser.setUpdatedAt(new Date());
            session.update(existingUser);
            transaction.commit();
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
