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
import org.madhuri.app.message.model.Profile;

public class ProfileDAO {

    public List<Profile> getAllProfiles() {
        List<Profile> profiles = new ArrayList<>();

        try {
        	// 1. get sql connection
        	DbConnection dbConnection = new DbConnection();
        	Connection connection = dbConnection.getConnection();
           
        	// 2. query the database
        	String sql = "SELECT * FROM Profile";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            // 3. loop through the results and create profile entity
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String profileName = resultSet.getString("profileName");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                //Date created = resultSet.getDate("created");
                Timestamp timestamp = resultSet.getTimestamp("created");

                // Convert the Timestamp to a Date object
                Date created = new Date(timestamp.getTime());
                
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                Profile profile = new Profile(id, profileName, firstName, lastName, created);
                
                profile.setUsername(username);
                profile.setPassword(password);
                
                profiles.add(profile);
            }
            // 4. return list of profiles
        }
        
        catch(SQLException e) {
        	e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        } 

        return profiles;
    }

    public Profile addProfile(Profile profile) {
        try {
            // 1. Get SQL connection
            DbConnection dbConnection = new DbConnection();
            Connection connection = dbConnection.getConnection();

            // 2. Prepare the INSERT statement
            String sql = "INSERT INTO Profile (profileName, firstName, lastName, created, username, password) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, profile.getProfileName());
            statement.setString(2, profile.getFirstName());
            statement.setString(3, profile.getLastName());
            statement.setDate(4, new java.sql.Date(profile.getCreated().getTime()));
            statement.setString(5, profile.getUsername());
            statement.setString(6, profile.getPassword());

            // 3. Execute the INSERT statement
            int rowsAffected = statement.executeUpdate();

            // 4. Check if the profile was successfully added
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

        return profile;
    }
    
}
