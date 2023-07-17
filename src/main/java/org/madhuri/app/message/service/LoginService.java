package org.madhuri.app.message.service;

import java.util.Optional;

import org.madhuri.app.message.dao.ProfileDAO;
import org.madhuri.app.message.model.Profile;

public class LoginService {

    private ProfileDAO profileDAO;

    public LoginService(ProfileDAO profileDAO) {
        this.profileDAO = profileDAO;
    }

    public Optional<Profile> login(String username, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        Optional<Profile> foundProfile = profileDAO.findByUsername(username);

        if (foundProfile.isPresent()) {
            if (foundProfile.get().getPassword().equals(password)) {
                return foundProfile;
            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }
}