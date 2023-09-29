package com.testProductService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
  
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


import com.product.app.controller.ProductController;
import com.product.app.model.Category;
import com.product.app.model.Product;
import com.product.app.service.ProductServiceImpl;


@SpringBootTest(properties = "spring.main.lazy-initialization=true",
classes = {ProductServiceImpl.class})
public class ProductTest {

//	@InjectMocks
//	ProductController productController;
//	
//	@Mock
//	ProductServiceImpl produServiceImpl;
//	
//	Product product;
//	
//	Category category;
//	
//	List<Product> productlist;
//	
//	private final String productId = "786";
//	
//	private final String merchantId="user1";
//	private final String merchantName="user";
//	
//	private final String producttype= "premium jewellery";
//	
//	private final String productName="Tanishq Gold";
//	
//
//	
//	@BeforeEach
//	void setUp() {
//		MockitoAnnotations.openMocks(this);
//		product = new Product();
//		
//		//category = new Category("category1","Women Fashion");
//		
//		List<String> image = new ArrayList<>();
//		image.add("url1");
//		
//		product.setProductType("premium jewellery");
//		product.setProductName("Tanishq Gold");
//		product.setCategory(category);
//		product.setDescription("Made by 24 carat gold");
//		product.setMerchantName(merchantName);
//		Map<String,String> specifications=new HashMap<>();
//		specifications.put("Caratage", "24 carat is pure gold with no other metals");
//		product.setSpecification(specifications);
//		product.setPrice(50000);
//		product.setImage(image);
//		productlist = new ArrayList<Product>();
//		productlist.add(product);
//		
//		
//	}
//	
//	@Test
//	@Order(1)
//	void addProduct() {
//		// first check that all the required parameters are in the product class
//		assertNotNull(product, "product is null");
//		
//	}
//	
//	@Test
//	@Order(2)
//	void addProductNotNull() {
//		// first check that all the required parameters are in the product class
//		
//		assertNotNull(product, "product is null");
//	}
//	
//	@Test
//	@Order(3)
//	void addProductProductTypeNotNull() {
//		assertNotNull(product.getProductType(), "Product type is required");
//	}
//	
//	@Test
//
//	void addProductProductSpecificationNotNull() {
//		assertNotNull(product.getSpecification(), "Specifications of product is required");
//	}
//	
//	@Test
//
//	void addProductProductMerchantNameNotNull() {
//		assertNotNull(product.getMerchantName(), "Merchant name is required");
//	}
//	
//	
//	@Test
//	@Order(4)
//	void addProductProductNameNotNull() {
//		assertNotNull(product.getProductName(), "Product Name is required");
//	}
//	
//	
//	@Test
//	@Disabled 
//	@Order(5)
//	void addProductCategoryNotNull() {
//		assertNotNull(product.getCategory(), "product category is required");
//	}
//	
//	
//	@Test
//	@Order(6)
//	void addProductDescriptionNotNull() {
//		assertNotNull(product.getDescription(), "product description is required");
//	}
//	
//	@Test
//	@Order(7)
//	void addProductPriceNotNull() {
//		assertNotNull(product.getPrice(), "product price is required");
//	}
//	
//	@Test
//	@Order(8)
//	void addProductImageNotNull() {
//		assertNotNull(product.getImage(), "Product image is required");
//	}
//	
//	@Test
//	@Order(9)
//	void getAllProducts() {
//		
//		when(produServiceImpl.getAllProducts()).thenReturn(productlist);
//		assertEquals(1,produServiceImpl.getAllProducts().size() );
//	}
//	
//	@Test
//	@Disabled 
//	@Order(10)
//	void addProductCheck() {
//		when(produServiceImpl.addProduct(product, merchantId,category.getCategoryName())).thenReturn(product);
//		
//		Product productRest = produServiceImpl.addProduct(product, merchantId,category.getCategoryName());
//		
//		assertNotNull(productRest);
//	}
//	
//	@Test
//	@Disabled 
//	@Order(11)
//	void addProductProductNameCheck() {
//		when(produServiceImpl.addProduct(product, merchantId,category.getCategoryName())).thenReturn(product);
//		
//		Product productRest = productController.addProduct(product, merchantId,category.getCategoryName());
//		
//		assertEquals(product.getProductName(), productRest.getProductName());
//	}
//	
//	@Test
//	@Disabled 
//	@Order(12)
//	void addProductProductCategoryCheck() {
//		when(produServiceImpl.addProduct(product, merchantId,category.getCategoryName())).thenReturn(product);
//		
//		Product productRest = productController.addProduct(product, merchantId,category.getCategoryName());
//		
//		assertEquals(product.getCategory().getCategoryName(), productRest.getCategory().getCategoryName());
//	}
//	
//	@Test
//	@Disabled 
//	@Order(13)
//	void addProductProductTypeCheck() {
//		when(produServiceImpl.addProduct(product, merchantId,category.getCategoryName())).thenReturn(product);
//		
//		Product productRest = productController.addProduct(product, merchantId,category.getCategoryName());
//		
//		assertEquals(product.getProductType(), productRest.getProductType());
//	}
//	
//	
//	@Test
//	@Disabled 
//	@Order(14)
//	void addProductProductDescriptionCheck() {
//		when(produServiceImpl.addProduct(product, merchantId,category.getCategoryName())).thenReturn(product);
//		
//		Product productRest = productController.addProduct(product, merchantId,category.getCategoryName());
//		
//		assertEquals(product.getDescription(), productRest.getDescription());
//	}
//	
//	
//	
//	@Test
//	@Disabled 
//	@Order(15)
//	void addProductProductPriceCheck() {
//		when(produServiceImpl.addProduct(product, merchantId,category.getCategoryName())).thenReturn(product);
//		
//		Product productRest = productController.addProduct(product, merchantId,category.getCategoryName());
//		
//		assertEquals(product.getPrice(), productRest.getPrice());
//	}
//	
//	@Test
//	@Disabled 
//	@Order(16)
//	
//	void addProductProductImageCheck() {
//		when(produServiceImpl.addProduct(product, merchantId,category.getCategoryName())).thenReturn(product);
//		
//		Product productRest = productController.addProduct(product, merchantId,category.getCategoryName());
//		
//		assertEquals(product.getImage().size(), productRest.getImage().size());
//	}
//	
//	@Test
//	@Order(17)
//	void getProductById() {
//		when(produServiceImpl.getProductById(productId)).thenReturn(product);
//		
//		Product productRest=productController.getProductById(productId);
//		
//		assertNotNull(productRest, "Product not avalable in db");
//		
//		assertEquals(product.getProductid(), productRest.getProductid());
//		
//		
//		
//	}
//	
//	@Test
//	@Order(18)
//	void getProductByType() {
//		when(produServiceImpl.getProductByType(producttype)).thenReturn(productlist);
//		
//		productlist = productController.getProductByType(producttype);
//		
//		assertNotNull(product);
//		
//		assertEquals(product.getProductType(), "premium jewellery");
//		
//		
//	}
//	
//	@Test
//	@Order(19)
//	void getProductByName() {
//		when(produServiceImpl.getProductByName(productName)).thenReturn(product);
//		
//		product= productController.getProductByName(productName);
//		
//		assertNotNull(product);
//		
//		assertEquals(product.getProductName(),"Tanishq Gold");
//	}
//	
//	
//	@Test
//	@Disabled 
//	@Order(20)
//	void getProductByCategory() {
//		
//		when(produServiceImpl.getProductByCategory(category.getCategoryName())).thenReturn(productlist);
//		
//		productlist= productController.getProductByCategory(category.getCategoryName());
//		
//		assertNotNull(product);
//		
//		assertEquals(product.getCategory().getCategoryName(),"Women Fashion");
//	}
//	
//
//	@Test
//	@Order(21)
//	void deleteProductById() {
//		
//		when(produServiceImpl.deleteProductById(productId)).thenReturn("Deleted Succesfully ");
//		
//		when(produServiceImpl.getProductById(productId)).thenReturn(product);
//		
//		String delete = productController.deleteProductById(productId);
//		
//		assertEquals("Deleted Succesfully ", delete ,"Product not avalable in db");
//		
//	}
	
}