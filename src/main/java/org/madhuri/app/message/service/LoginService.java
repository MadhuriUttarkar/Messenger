package org.madhuri.app.message.service;

import java.util.Optional;

import org.madhuri.app.message.dao.ProfileDAO;
import org.madhuri.app.message.model.Profile;

public class LoginService {

	private ProfileDAO profileDAO;

    public LoginService() {
        this.profileDAO = new ProfileDAO();
    }

    public boolean authenticate(String username, String password) {
        Optional<Profile> foundProfile = profileDAO.findByUsername(username);
        return foundProfile.isPresent() && foundProfile.get().getPassword().equals(password);
    }
}