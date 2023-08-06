package org.madhuri.app.message.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.madhuri.app.message.model.MessageGroup;
import org.madhuri.app.message.util.HibernateUtil;

public class GroupDAO {
	
	public List<MessageGroup> getgroups(){
	    Session session = HibernateUtil.getSession();  
	    Query query = session.createQuery("from MessageGroup");
	    List<MessageGroup> groupmessages =  query.list();
	        session.close();
	    return groupmessages;
	  }

	public MessageGroup createGroup(MessageGroup group) {
		Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.save(group); // Save the new group entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return group;
	}

	public void deleteGroup(long groupid) {
		Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            MessageGroup group = session.get(MessageGroup.class, groupid);
            if (group != null) {
                session.delete(group); // Delete the group entity
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
