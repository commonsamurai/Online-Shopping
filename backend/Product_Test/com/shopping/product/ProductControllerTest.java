package com.shopping.product;

//import static org.assertj.core.api.Assertions.assertThat;
//import static org.hamcrest.Matchers.hasSize;
////import static org.hamcrest.Matchers.is;
////import static org.hamcrest.Matchers.notNullValue;
////import static org.mockito.BDDMockito.willDoNothing;
//import static org.mockito.Mockito.when;
////import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
////import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
////import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
////import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
////import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
////import org.junit.Before;
//import org.junit.Test;
////import org.junit.runner.RunWith;
////import org.mockito.InjectMocks;
////import org.mockito.Mock;
////import org.mockito.Mockito;
////import org.mockito.MockitoAnnotations;
////import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
////import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.shopping.service.ProductServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.hasSize;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.shopping.controller.ProductController;
import com.shopping.model.Product;
//import com.shopping.service.ProductService;


@SpringBootTest(classes= ProductControllerTest.class)
@AutoConfigureMockMvc
public class ProductControllerTest {

	@MockBean
	private ProductServiceImpl service;
	
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
	void testShowProducts() throws Exception  {
		Product p1=new Product(1,"household","fan","furniture",null,null,null,3500,"Good quality",null);
		Product p2=new Product(2,"household","fan","furniture",null,null,null,3500,"Good quality",null);
		List<Product> productList=new ArrayList<Product>();
		productList.add(p1);
		productList.add(p2);
		when(service.getAllProducts()).thenReturn(productList);
	mockMvc.perform(get("/Product"))
	.andExpect(status().isOk())
	.andExpect(content().contentType("application/json"));
//	.andExpect(jsonPath("$[*]", hasSize(2)))
//	.andExpect(jsonPath("$[0].id").value(1))
//	.andExpect(jsonPath("$[0].name").value("household"))
//	.andExpect(jsonPath("$[0].category").value("fan"))
//	.andExpect(jsonPath("$[0].price").value(3500));
//		
	}
	
	

//	@Test
//	void testShowProductById() throws Exception {
//		Optional<Product> p1=Optional.of(new Product(1,"household","fan","furniture",null,null,null,3500,"Good quality",null));
//	when(service.getProductById(1)).thenReturn(p1);
//	mockMvc.perform(get("/products/1"))
//	.andExpect(status().isOk())
//	.andExpect(content().contentType("application/json"))
//	.andExpect(jsonPath("$.productId").value(1))
//	.andExpect(jsonPath("$.productType").value("household"))
//	.andExpect(jsonPath("$.productName").value("fan"))
//	.andExpect(jsonPath("$.price").value(3500));
//		
//	}
	
	
//	@Test
//	void testShowProductInvalidId() throws Exception {
//		Product p1=new Product(101,"MI-pro7","mobile",20000);
//	when(service.getProductById(101)).thenReturn(p1);
//	MvcResult result=mockMvc.perform(get("/products/1"))
//	.andExpect(status().isOk())
//	.andReturn();
//	assertThat(result.getResponse().toString())
//	.as("Product with the id 1 doesn't exist");
//		
//	}
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
//		Product p1=new Product(101,"MI-pro7","mobile",20000);
//		String s="added successfully....";
//		when(service.addProduct(p1)).thenReturn(s);
//		
//		ObjectMapper mapper=new ObjectMapper();
//		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
//		String reqstr=writer.writeValueAsString(p1);
//	mockMvc.perform(post("/products/")
//			.contentType("application/json")
//			.content(reqstr))
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));
//		
//	}
//	
//	@Test
//	void testUpdateProduct() throws Exception {
//		Product p1=new Product(101,"MI-pro7","mobile",20000);
//		String s="updated successfully....";
//		when(service.updateProduct(p1)).thenReturn(s);
//		
//		ObjectMapper mapper=new ObjectMapper();
//		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
//		String reqstr=writer.writeValueAsString(p1);
//	mockMvc.perform(put("/products/")
//			.contentType("application/json")
//			.content(reqstr))
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));
//		
//	}
}
