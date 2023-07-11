package org.madhuri.app.message.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.madhuri.app.message.model.Profile;

public class ProfileDAO {
	
	private final String url = "jdbc:postgresql://localhost:5432/Message";
    private final String user = "postgresql";
    private final String password = "Madhuri@1996";

    public List<Profile> getAllProfiles() {
        List<Profile> profiles = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM Profile";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String profileName = resultSet.getString("profileName");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                Date created = resultSet.getDate("created");

                Profile profile = new Profile(id, profileName, firstName, lastName, created);
                profiles.add(profile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
        }

        return profiles;
    }

}
