package com.websystique.springmvc.service;

import java.util.List;


import com.websystique.springmvc.model.UserDTO;



public interface UserService {
	
	UserDTO findById(long id);
	
	long saveUser(UserDTO user);
	
	void updateUser(UserDTO user);
	
	void deleteUserById(long id);

	List<UserDTO> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(UserDTO user);
	
}
