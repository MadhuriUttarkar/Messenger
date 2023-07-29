package org.madhuri.app.message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.madhuri.app.message.database.DbConnection;
import org.madhuri.app.message.model.Message;

public class MessageDAO {

    public List<Message> getAllMessages() {
        List<Message> messages = new ArrayList<>();

        try {
            // 1. Get SQL connection
            DbConnection dbConnection = new DbConnection();
            Connection connection = dbConnection.getConnection();

            // 2. Query the database
            String sql = "SELECT * FROM Message";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // 3. Loop through the results and create message entities
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String username = resultSet.getString("username");
                String messageContent = resultSet.getString("messageContent");
                Timestamp timestamp = resultSet.getTimestamp("created");

                // Convert the Time stamp to a Date object
                Date created = new Date(timestamp.getTime());
                String recipient = resultSet.getString("recipient");

                // Create a new Message object and set its properties
                Message message = new Message(id, messageContent, created, username,recipient);

                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return messages;
    }


    public Message addMessage(Message msg) {
        try {
            // 1. Get SQL connection
            DbConnection dbConnection = new DbConnection();
            Connection connection = dbConnection.getConnection();

            // 2. Prepare the INSERT statement
            String sql = "INSERT INTO Message (messageContent, created, username, recipient) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, msg.getMessageContent());
            statement.setDate(2, new java.sql.Date(msg.getCreated().getTime())); 
            statement.setString(3, msg.getUsername());
            statement.setString(4, msg.getRecipient());

            // 3. Execute the INSERT statement
            int rowsAffected = statement.executeUpdate();

            // 4. Check if the message was successfully added
            if (rowsAffected > 0) 
            {
                System.out.println("Record inserted successfully.");
            } 
            else 
            {
                System.out.println("Failed to insert the record.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msg;
    }

	private Message createMessageFromResultSet(ResultSet resultSet, String username) throws SQLException {
        long id = resultSet.getLong("id");
        String messageContent = resultSet.getString("messageContent");
        Timestamp timestamp = resultSet.getTimestamp("created");
        Date created = new Date(timestamp.getTime());
        String recipient = resultSet.getString("recipient");
        return new Message(id, messageContent, created, username, recipient);
    }
	
	public Message getMessageById(long messageId) {
        Message message = null;
        try {
            // 1. Get SQL connection
            DbConnection dbConnection = new DbConnection();
            Connection connection = dbConnection.getConnection();

            // 2. Query the database for the message with the given messageId
            String sql = "SELECT * FROM Message WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, messageId);
            ResultSet resultSet = statement.executeQuery();

            // 3. If the message with the given messageId is found, create the Message object
            if (resultSet.next()) {
                message = createMessageFromResultSet(resultSet, resultSet.getString("username"));
            }
            // 4. Close the resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return message;  
	}
	
	public List<Message> getMessagesByUsername(String username) {
		List<Message> messages = new ArrayList<>();

        try {
            // 1. Get SQL connection
            DbConnection dbConnection = new DbConnection();
            Connection connection = dbConnection.getConnection();

            // 2. Prepare the SELECT statement
            String sql = "SELECT * FROM Message WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            // 3. Execute the SELECT statement
            ResultSet resultSet = statement.executeQuery();

            // 4. Loop through the results and create message entities
            while (resultSet.next()) {
                Message message = createMessageFromResultSet(resultSet, username);
                messages.add(message);
            }
            // 5. Close the resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return messages;
    }
	
}
