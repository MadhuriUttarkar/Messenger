package org.madhuri.app.message.handler;
import org.madhuri.app.message.service.ProfileService;
import java.util.List;
import org.madhuri.app.message.model.Profile;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ProfileHandler {
	
	private ProfileService profileService=new ProfileService(); 
	
	@GET
	@Path("/all")
	public List<Profile>getProfiles()
	{
		
		return profileService.getAllProfiles();
	} 
		
	@POST
	@Path("/add")
	public Profile addProfile(Profile profile)
	{
		return profileService.addProfile(profile);
	}
	
//	@GET
//	@Path("/{profileName}")
//	public Profile getProfile(@PathParam("profileName")String profileName)
//	{
//		return profileService.getProfile(profileName);
//	}
//	
//	@PUT
//	@Path("/{profileName}")
//	public Profile updateProfile(@PathParam("profileName")String profileName,Profile profile)
//	{
//		profile.setProfileName(profileName);
//		return profileService.updateProfile(profile);
//	}
//	
//	@DELETE
//	@Path("/{profileName}")
//	public void deleteProfile(@PathParam("profileName")String profileName)
//	{
//		profileService.removeProfile(profileName);
//	}
	
}
