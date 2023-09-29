package com.product.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.product.app.model.Category;
import com.product.app.model.Product;
import com.product.app.model.UserProfile;
import com.product.app.repository.CategoryRepository;
import com.product.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryServiceImpl catServiceImpl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//add product 
	public Product addProduct(Product product, int merchantId,int categoryId) {
		UserProfile profile = restTemplate.getForObject("http://localhost:8095/api/user/"+merchantId, UserProfile.class);
		product.setMerchantId(merchantId);
		product.setMerchantName(profile.getFullName());
		Category category = catServiceImpl.getCategoryById(categoryId);
		
		product.setCategoryId(categoryId);
		product.setCategory(category);
        
		if(profile.getRole().equalsIgnoreCase("Merchant"))
			return productRepository.save(product);
		
		return null;
	}
	
	//get all products
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	//get product by id
	public Product getProductById(int productid) {
		Optional<Product> productOptional=	productRepository.findById(productid);
		return productOptional.get();
	}
	
	
	//delete product by id
	public String deleteProductById(int productid) {
		productRepository.deleteById(productid);
		return "Deleted Succesfully";
	}
	
	//Update Product 
	public Product updateProducts(Product product, int productId) {
		
		Product productDb = productRepository.findById(productId).get();
		
		if(product.getProductType() !=null) {
			productDb.setProductType(product.getProductType());
		}
		if(product.getProductName() !=null) {
			productDb.setProductName(product.getProductName());
		}
		if(product.getCategory()!=null) {
			productDb.setCategory(product.getCategory());
		}
		
	
		if(product.getImage() !=null) {
			productDb.setImage(product.getImage());
		}
		
		if(product.getPrice() != 0) {
			productDb.setPrice(product.getPrice());
		}
		
		if(product.getDescription() !=null) {
			productDb.setDescription(product.getDescription());
			
		}
		
		if(product.getSpecification() !=null) {
			productDb.setSpecification(product.getSpecification());
			
		}
		return productRepository.save(product);
		
		
	}
	
	//get Product By category
	public List<Product> getProductByCategory( String category){
		return productRepository.findByCategory(category);
	}
	
	//get Product By Name
	public Product getProductByName( String productName){
		return productRepository.findByProductName(productName);
	}
	
	//get Product By Type 
	public List<Product> getProductByType(String producttype){
		return productRepository.findByProductType(producttype);
	}
	
	//get product by merchant id 
	public List<Product> getProductByMerchantId(int merchantId) {
		return productRepository.findByMerchantId(merchantId);
	}
	
	//get Product By categoryId
	@Transactional
	public List<Product> getProductByCategoryId(int categoryId){
		return productRepository.findByCategoryId(categoryId);
	}

	@Override
	public List<Product> addAllProducts(List<Product> product, int merchantId, int categoryId) {
		List<Product> lst = new ArrayList<>();
		product.forEach(p->{
			int x = getCategory(p); 
			lst.add(addProduct(p, merchantId, x));
		});
		return lst;
	}
	
	
	private int getCategory(Product product) {
		
		Category category = categoryRepository.findByCategoryName(product.getCategory().getCategoryName());
		
		if(category==null) {
			category = categoryRepository.save(product.getCategory());
		}
		
		return category.getCategoryId();
		
	}



		
	}
	
	
	


