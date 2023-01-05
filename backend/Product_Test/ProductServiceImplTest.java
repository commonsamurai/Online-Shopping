

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.shopping.model.Product;
//import com.cognizant.exception.ProductNotFoundException;
//import com.cognizant.model.Product;
import com.shopping.repository.ProductRepository;
import com.shopping.service.ProductServiceImpl;

@SpringBootTest(classes=ProductServiceImplTest.class)
@AutoConfigureMockMvc
public class ProductServiceImplTest {

	
	@InjectMocks
	private ProductServiceImpl service;
	
	@Mock
	private ProductRepository repository;
	
	@Test
	void testServiceNotNull() {
		assertThat(service).isNotNull();
	}
	
	@Test
	void testRepositoryNotNull() {
		assertThat(repository).isNotNull();
	}
	
	@Test
	void testGetAllProducts() {
		Product p1=new Product(101,"household","fan","furniture",null,null,null,3500,"Good quality",null);
		Product p2=new Product(102,"household","fan","furniture",null,null,null,3500,"Good quality",null);
		List<Product> productList=new ArrayList<Product>();
		productList.add(p1);
		productList.add(p2);
		when(repository.findAll()).thenReturn(productList);
		assertEquals(productList,service.getAllProducts());
		
	}
	
//	@Test
//	void testGetProductById() throws ProductNotFoundException {
//		Product p1=new Product(101,"MI-pro7","mobile",20000);
//		when(repository.findById(101)).thenReturn(Optional.of(p1));
//		assertEquals(p1,service.getProductById(101));
//	}
//	
//	@Test
//	void testGetProductByInvalidId() throws ProductNotFoundException {
//		Product p1=new Product(101,"MI-pro7","mobile",20000);
//		when(repository.findById(101)).thenReturn(Optional.of(p1));
//		try {
//			assertThat(service.getProductById(1)).as("Product with the id 1 doesn't exist");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	void testAddProduct() throws ProductNotFoundException {
//		Product p1=new Product(101,"MI-pro7","mobile",20000);
//		assertThat(service.addProduct(p1))
//		.contains("added successfully....");
//	
//	}	
//	@Test
//	void testAddProductAlreadyExists() throws ProductNotFoundException {
//		Product p1=new Product(101,"MI-pro7","mobile",20000);
//		when(repository.findById(101)).thenReturn(Optional.of(p1));
//	try {
//		assertThat(service.addProduct(p1))
//		.contains("Product with the id "+p1.getId()+" already exist");
//	}catch(Exception e) {
//		
//	}
//	}
//	
//	@Test
//	void testupdateProduct() throws ProductNotFoundException {
//		Product p1=new Product(101,"MI-pro7","mobile",20000);
//		when(repository.findById(101)).thenReturn(Optional.of(p1));
//		assertThat(service.updateProduct(p1))
//		.contains("updated successfully....");
//	
//	}
//	
//	@Test
//	void testupdateProductDoesnotExists() throws ProductNotFoundException {
//		Product p1=new Product(101,"MI-pro7","mobile",20000);
//		when(repository.findById(10)).thenReturn(Optional.of(p1));
//	try {
//		assertThat(service.updateProduct(p1))
//		.contains("Product with the id "+p1.getId()+" doesn't exist for update");
//	}catch(Exception e) {
//		
//	}
//	}
//	
//	@Test
//	void testDeleteProductById() throws ProductNotFoundException {
//		Product p1=new Product(101,"MI-pro7","mobile",20000);
//		when(repository.findById(101)).thenReturn(Optional.of(p1));
//		assertThat(service.deleteProductById(101))
//		.contains("deleted successfully....");
//	}
//	
//	@Test
//	void testDeleteProductByInvalidId() throws ProductNotFoundException {
//		Product p1=new Product(101,"MI-pro7","mobile",20000);
//		when(repository.findById(101)).thenReturn(Optional.of(p1));
//		try {
//			assertThat(service.deleteProductById(111))
//			.contains("Product with the id "+p1.getId()+" doesn't exist");
//		}catch(Exception e) {
//			
//		}
//	}
	
	
	}

