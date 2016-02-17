import user.services.User;
import user.services.UserService;
import user.services.UserServiceService;

public class TestUser {
	
	public static void main(String[] args)
	{
		// wsimport -keep -verbose -s ./src/ -d ./bin/ http://localhost:8080/webservices/userservice?wsdl

		UserService userService = new UserServiceService().getUserServicePort();
		
		System.out.println("User exist:" + userService.login("randomuser", "lol"));
		
		User u = userService.getUser(1);
		if(u != null)
		{
			System.out.println("Current User : "+ u.getFirstName());
			u.setFirstName("adam");
			System.out.println("Update successful : " + userService.update(u));
		}
		
		User newUser = new User();
		newUser.setUserName("newUser");
		newUser.setPassword("lol");
		newUser.setFirstName("Adam");
		newUser.setLastName("John");
		newUser.setEmail("adamjohn@gmail.com");
			
		if(userService.register(newUser))
		{
			System.out.println("Successfully registered new user");
		}

	}

}
