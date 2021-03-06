package tr.com.obss.service;

import java.util.List;

import tr.com.obss.model.User;

public interface UserService {
	public User post(User user);

	public List<User> get(String userName);
	
	public User put(int userID,User user);
	
	public void delete(int userID);
	
	public List<User> getAllUsers();
}
