package org.madhuri.app.message.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private final String url = "jdbc:postgresql://localhost:5432/Message";
	private final String user = "postgres";
	private final String password = "Madhuri@1996";
	
	public Connection getConnection() throws Exception{
		 try {
			 Class.forName("org.postgresql.Driver");
			 Connection connection = DriverManager.getConnection(url, user, password);
			 return connection;
		 }
		 catch(Exception e) {
			 throw e;
		 }
	}
}