package com.shopping.ProductTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shopping.model.Product;

//import com.cognizant.model.Product;

class ProductTest {

	Product p1;
	@BeforeEach
	public void before() {
		p1=new Product(1,"household","fan","furniture",null,null,null,3500,"Good quality",null);
	}
	
	
	@AfterEach
	public void after() {
		p1=null;
	}
	
	@Test
	void testGetId() {
		assertEquals(1, p1.getProductId());
	}

	@Test
	void testGetName() {
		assertEquals("fan", p1.getProductName());
	}
	@Test
	void testGetType() {
		assertEquals("household", p1.getProductType());
	}

	@Test
	void testGetCategory() {
		assertEquals("furniture", p1.getCategory());
	}

	@Test
	void testGetPrice() {
		assertEquals(3500, p1.getPrice());
	}
	
	

	@Test
	void testSetId() {
		p1.setProductId(1);
		assertEquals(1, p1.getProductId());
	}

	@Test
	void testSetName() {
		p1.setProductName("fan");
		assertEquals("fan", p1.getProductName());
	}

	@Test
	void testSetCategory() {
		p1.setCategory("furniture");
		assertEquals("furniture", p1.getCategory());
	}
	
	@Test
	void testSetType() {
		p1.setProductType("household");
		assertEquals("household", p1.getProductType());
	}
	

	@Test
	void testSetPrice() {
		p1.setPrice(500);
		assertEquals(500, p1.getPrice());
	}

}
