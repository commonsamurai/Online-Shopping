package com.capg.CartServiceModelTest;
//package com.cognizant.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capg.CartService.model.Cart;

class CartTest {

	Cart p1;
	@BeforeEach
	public void before() {
		p1=new Cart(101, null);
	}
	
	
	@AfterEach
	public void after() {
		p1=null;
	}
	
	@Test
	void testGetId() {
		assertEquals(101, p1.getCartId());
	}

//	@Test
//	void testGetName() {
//		assertEquals("Mi-por7", p1.getName());
//	}
//
//	@Test
//	void testGetCategory() {
//		assertEquals("mobile", p1.getCategory());
//	}
//
//	@Test
//	void testGetPrice() {
//		assertEquals(10000, p1.getPrice());
//	}

	@Test
	void testSetId() {
		p1.setCartId(101);
		assertEquals(101, p1.getCartId());
	}

//	@Test
//	void testSetName() {
//		p1.setName("oppo");
//		assertEquals("oppo", p1.getName());
//	}
//
//	@Test
//	void testSetCategory() {
//		p1.setCategory("tv");
//		assertEquals("tv", p1.getCategory());
//	}
//
//	@Test
//	void testSetPrice() {
//		p1.setPrice(100);
//		assertEquals(100, p1.getPrice());
//	}

}
