package com.demo.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.user.entity.User;
import com.demo.user.exception.UserAlreadyExistsException;
import com.demo.user.exception.UserDoesntExistException;
import com.demo.user.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User saveUser(User user) throws UserAlreadyExistsException {
		
		if(userRepo.existsById(user.getId()))
			throw new UserAlreadyExistsException();
		User savedUser=userRepo.save(user);
		return savedUser;
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) userRepo.findAll();
	}

	@Override
	public Optional<User> getUserById( int id) throws UserDoesntExistException {
		// TODO Auto-generated method stub
		if(!userRepo.existsById(id)) {
			throw new UserDoesntExistException();
		}
		Optional<User> userObj=userRepo.findById(id);
		return userObj;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

@Override
	public void deleteById(int id) throws UserDoesntExistException {
		// TODO Auto-generated method stub
	if(!userRepo.existsById(id)) {
		throw new UserDoesntExistException();
	}
		userRepo.deleteById(id);
	} 

	
}
