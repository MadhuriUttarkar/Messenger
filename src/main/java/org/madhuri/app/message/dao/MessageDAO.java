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
            statement.setTimestamp(2, new Timestamp(msg.getCreated().getTime())); // Use setTimestamp instead of setDate
            statement.setString(3, msg.getUsername());
            statement.setString(4, msg.getRecipient());

            // 3. Execute the INSERT statement
            int rowsAffected = statement.executeUpdate();

            // 4. Check if the message was successfully added
            if (rowsAffected > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Failed to insert the record.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msg;
    }

}
