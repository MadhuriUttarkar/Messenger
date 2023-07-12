package org.madhuri.app.message.service;

import java.util.List;
import org.madhuri.app.message.dao.ProfileDAO;
import org.madhuri.app.message.model.Profile;

public class ProfileService {
	
	
	private ProfileDAO profileDAO = new ProfileDAO();
	
	
	public ProfileService()
	{
	}
	
	public List<Profile> getAllProfiles()
	{
		List<Profile> allProfiles = profileDAO.getAllProfiles();
		return allProfiles;
	}
	
	public Profile getProfile(String profileName)
	{
		
		return new Profile();
	}
	
	
//	public Profile addProfile(Profile profile)
//	{
//		profile.setId(profiles.size()+1);
//		profiles.put(profile.getProfileName(),profile);
//		return profile;
//	}
//	public Profile updateProfile(Profile profile)
//	{
//		if(profile.getProfileName().isEmpty())
//		{
//			return null;
//		}
//		profiles.put(profile.getProfileName(),profile);
//		return profile;
//	}
//	public Profile removeProfile(String profileName)
//	{
//		return profiles.remove(profileName);
//	}


}
