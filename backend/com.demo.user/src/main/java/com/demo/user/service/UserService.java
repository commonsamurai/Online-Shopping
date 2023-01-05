package com.demo.user.service;

import java.util.List;
import java.util.Optional;

import com.demo.user.entity.User;
import com.demo.user.exception.UserAlreadyExistsException;
import com.demo.user.exception.UserDoesntExistException;

public interface UserService {

	User saveUser(User user) throws UserAlreadyExistsException;

	List<User> getAllUsers();

	Optional<User> getUserById(int id) throws UserDoesntExistException;

	void update(User user);

	static boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	void deleteById(int id) throws UserDoesntExistException;

	void deleteUser(User user);

	//void deleteUser(User user);

	/* static  update(User user, User id) {
		// TODO Auto-generated method stub
		
	} */

}
