//package com.demo.user;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.demo.user.entity.User;
//import com.demo.user.exception.UserAlreadyExistsException;
//import com.demo.user.exception.UserDoesntExistException;
//import com.demo.user.repository.UserRepository;
//import com.demo.user.service.UserService;
//
////@TestMethodOrder(OrderAnnotation.class)
//@SpringBootTest(classes = { ServiceMackitoTests.class })
//public class ServiceMackitoTests {
//
//	@Mock
//	UserRepository userRepo;
//
//	@InjectMocks
//	UserService userserv;
//
//	public List<User> myusers;
//
//	@Test
//	@Order(1)
//	public void test_getAllUsers() {
//
//		List<User> myusers = new ArrayList<User>();
//		myusers.add(new User(1, "Ritika", "Hangargi", 0, null, null, null, null));
//		myusers.add(new User(2, "Tanishka", "Hangargi", 0, null, null, null, null));
//
//		when(userRepo.findAll()).thenReturn(myusers);
//		assertEquals(2, userserv.getAllUsers().size());
//	}
//
//	@Test
//	@Order(2)
//	public void test_getUserById() throws UserDoesntExistException {
//
//		List<User> myusers = new ArrayList<User>();
//		myusers.add(new User(1, "Ritika", "Hangargi", 0, null, null, null, null));
//		myusers.add(new User(2, "Tanishka", "Hangargi", 0, null, null, null, null));
//		int userId = 1;
//		when(userRepo.findAll()).thenReturn(myusers);
//		assertEquals(1, userserv.getUserById(userId).get());
//
//	}
//
//	@Test
//	@Order(3)
//	public void test_saveUser() throws UserAlreadyExistsException {
//		User user = new User(1, "sahana", "member 2",0, null, null, null, null);
//
//		when(userRepo.save(user)).thenReturn(user);
//		assertEquals(user, userserv.saveUser(user));
//
//	}
///*
//	@Test
//	@Order(4)
//	public void test_update() {
//		User user = new User(1, "sahana", "member 2", 0, null, null, null);
//		when(userRepo.save(user)).thenReturn(user);
//		assertEquals(user,userserv.update(user));
//		//assertEquals(user, userserv.update(user));
//	}  */
//	
//	@Test
//	@Order(5)
//	public void test_delete() throws UserDoesntExistException {
//		User user = new User(1, "sahana", "member 2", 0, null, null, null);
//		
//		userserv.deleteUser(user);
//		verify(userRepo,times(1)).delete(user);
//		
//	}
//
//}
