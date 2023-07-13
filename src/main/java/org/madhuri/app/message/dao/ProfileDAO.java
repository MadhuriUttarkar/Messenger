package org.madhuri.app.message.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
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
                Date created = resultSet.getDate("created");

                Profile profile = new Profile(id, profileName, firstName, lastName, created);
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
        	// 1. get sql connection
        	DbConnection dbConnection = new DbConnection();
        	Connection connection = dbConnection.getConnection();
        	String sql = "INSERT INTO Profile(profileName,firstName,lastName,created)VALUES(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, profile.getProfileName());
            statement.setString(2, profile.getFirstName());
            statement.setString(3, profile.getLastName());
            statement.setDate(4, (java.sql.Date) profile.getCreated());
            
            int rowsAffected = statement.executeUpdate();
            
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
