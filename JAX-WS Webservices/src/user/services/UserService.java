package user.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import user.model.User;

@WebService
public class UserService {
	
	@WebMethod(operationName = "getUser")
	public User getUserById(int id)
	{
		if(id ==1 )
		{
			return new User("randomuser","lol","bat","dorj","bat@gmail.com");
		}		
		return null;
	}
	
	@WebMethod(operationName = "login")
	public boolean loginUser(String username, String password)
	{
		if(username.equals("randomuser") && password.equals("lol"))
		{
			return true;
		}
		return false;
	}
	
	@WebMethod(operationName = "register" , action = "urn:preferences")
	public boolean registerUser(@WebParam(name = "user") User user)
	{
		return true;
	}

	
	
	@WebMethod(operationName = "update" , action = "urn:preferences")
	public boolean updateUserProfile(@WebParam(name = "user") User user)
	{
		return true;
	}

}
