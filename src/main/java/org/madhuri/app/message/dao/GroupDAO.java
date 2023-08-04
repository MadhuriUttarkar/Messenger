package org.madhuri.app.message.dao;

import java.util.List;
import org.hibernate.Session;
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

}



