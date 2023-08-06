package org.madhuri.app.message.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	
	//private static SessionFactory sessionFactory;

	

	/*public HibernateUtil() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		sessionFactory = configuration.buildSessionFactory();
	}*/

	public static Session getSession() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		return session;
	}

}
