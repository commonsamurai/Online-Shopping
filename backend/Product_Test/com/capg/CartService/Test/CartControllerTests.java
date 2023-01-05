package com.capg.CartService.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.capg.CartService.model.Cart;
import com.capg.CartService.service.CartServiceImpl;

//import com.cognizant.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTests {

	@MockBean
	private CartServiceImpl service;
	
	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	void testServiceNotNull() {
		assertThat(service).isNotNull();
	}
	
	@Test
	void testMockMvcNotNull() {
		assertThat(mockMvc).isNotNull();
	}
	
	
	@Test
	void testShowProducts() throws Exception {
		Cart p1=new Cart(101,null);
		Cart p2=new Cart(102,null);
		List<Cart> cartList=new ArrayList<Cart>();
		cartList.add(p1);
		cartList.add(p2);
		when(service.getallcarts()).thenReturn(cartList);
	mockMvc.perform(get("/cart/getAllCarts"))
	.andExpect(status().isOk())
	.andExpect(content().contentType("application/json"))
//	.andExpect(jsonPath("$[*]", hasSize(2)))
	.andExpect(jsonPath("$[0].cartId").value(101));
//	.andExpect(jsonPath("$[0].name").value("MI-pro7"))
//	.andExpect(jsonPath("$[0].category").value("mobile"))
//	.andExpect(jsonPath("$[0].price").value(20000));
		
	}
	
	@Test
	void testShowProductById() throws Exception {
		Cart p1=new Cart(101,null);
	when(service.getcartById(101)).thenReturn(p1);
	mockMvc.perform(get("/cart/cartbyId/101"))
	.andExpect(status().isOk())
	.andExpect(content().contentType("application/json"))
	.andExpect(jsonPath("$.cartId").value(101));
//	.andExpect(jsonPath("$.name").value("MI-pro7"))
//	.andExpect(jsonPath("$.category").value("mobile"))
//	.andExpect(jsonPath("$.price").value(20000));
		
	}
//	
//	
//	@Test
//	void testShowProductInvalidId() throws Exception {
//		Cart p1=new Cart(101,null);
//	when(service.getcartById(1)).thenReturn(p1);
//	MvcResult result=mockMvc.perform(get("/cartbyId/1"))
//	.andExpect(status().isOk())
//	.andReturn();
//	assertThat(result.getResponse().toString())
//	.as("Product with the id 1 doesn't exist");
//		
//	}
	
	
	
	@Test
	void testShowProductInvalidId() throws Exception {
		Cart p1=new Cart(101,null);
	when(service.getcartById(101)).thenReturn(p1);
	MvcResult result=mockMvc.perform(get("/cart/cartbyId/1"))
	.andExpect(status().isOk())
	.andReturn();
	assertThat(result.getResponse().toString())
	.as("Product with the id 1 doesn't exist");
		
	}
//	
//	
//	@Test
//	void testDeleteProductById() throws Exception {
//		Product p1=new Product(101,"MI-pro7","mobile",20000);
//		String s="deleted successfully....";
//	when(service.deleteProductById(101)).thenReturn(s);
//	mockMvc.perform(delete("/products/101"))
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));	
//	}
//	
//	@Test
//	void testdeleteProductInvalidId() throws Exception {
//		Product p1=new Product(101,"MI-pro7","mobile",20000);
//		String s="deleted successfully....";
//		when(service.deleteProductById(101)).thenReturn(s);
//	MvcResult result=mockMvc.perform(delete("/products/11"))
//	.andExpect(status().isOk())
//	.andReturn();
//	assertThat(result.getResponse().toString())
//	.as("Product with the id 1 doesn't exist");
//		
//	}
//	
//	@Test
//	void testAddProduct() throws Exception {
//		Cart p1=new Cart(101,null);
//		String s="added successfully....";
//		when(service.addCart(p1)).thenReturn(s);
//		
//		ObjectMapper mapper=new ObjectMapper();
//		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
//		String reqstr=writer.writeValueAsString(p1);
//	mockMvc.perform(post("/add")
//			.contentType("application/json")
//			.content(reqstr))
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));
//		
//	}
	
	@Test
	void testAddProduct() throws Exception {
		Cart p1=new Cart(101,null);
		String s="added successfully....";
//		when(service.addCart(p1)).thenReturn(s);
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
		String reqstr=writer.writeValueAsString(p1);
	mockMvc.perform(post("/add/")
			.contentType("application/json")
			.content(reqstr));
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));
	}
	
	@Test
	void testUpdateProduct() throws Exception {
		Cart p1=new Cart(101,null);
		String s="updated successfully....";
		when(service.updateCart(101,p1)).thenReturn(p1);
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
		String reqstr=writer.writeValueAsString(p1);
	mockMvc.perform(put("/update/101")
			.contentType("application/json")
			.content(reqstr));
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));
		
	}
}





