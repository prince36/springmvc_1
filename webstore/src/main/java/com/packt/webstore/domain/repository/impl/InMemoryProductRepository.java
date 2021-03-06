package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository{
	
	private List<Product> listOfProducts = new ArrayList<Product>();

	public List<Product> getProductsByCategory(String category) {
		List<Product> productsByCategory = new ArrayList<Product>();
		for(Product product: listOfProducts) {
			if(category.equalsIgnoreCase(product.getCategory())){
				productsByCategory.add(product);
			}
		}
		return productsByCategory;
	}

	public Set<Product> getProductsByFIlter(Map<String, List<String>> filterParams) {
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();
		if(criterias.contains("brand")) {
			for(String brandName: filterParams.get("brand")) {
				for(Product product: listOfProducts) {
					if(brandName.equalsIgnoreCase(product.getManufacturer())){
						productsByBrand.add(product);
					}
				}
			}
		}
		if(criterias.contains("category")) {
			for(String category: filterParams.get("category")) {
				productsByCategory.addAll(this.getProductsByCategory(category));
			}
		}
		productsByCategory.retainAll(productsByBrand);
		return productsByCategory;
	}

	public InMemoryProductRepository() {
	Product iphone = new Product("P1234","iPhone 5s", new BigDecimal(500));
    iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym ekranem o rozdzielczości 640×1136 i 8-megapikselowym aparatem");
    iphone.setCategory("smartfon");
    iphone.setManufacturer("Apple");
    iphone.setUnitsInStock(1000);

    Product laptop_dell = new Product("P1235","Dell Inspiron", new BigDecimal(700));
    laptop_dell.setDescription("Dell Inspiron, 14-calowy laptop (czarny) z procesorami Intel Core 3. generacji");
    laptop_dell.setCategory("laptop");
    laptop_dell.setManufacturer("Dell");
    laptop_dell.setUnitsInStock(1000);

    Product tablet_Nexus = new Product("P1236","Nexus 7", new BigDecimal(300));
    tablet_Nexus.setDescription("Google Nexus 7 jest najlżejszym 7-calowym tabletem z 4-rdzeniowym procesorem Qualcomm Snapdragon S4 Pro");
    tablet_Nexus.setCategory("tablet");
    tablet_Nexus.setManufacturer("Google");
    tablet_Nexus.setUnitsInStock(1000);

    Product samsung = new Product("P1237","Samsung s7", new BigDecimal(500));
	samsung.setDescription("Samsung S7, smartfon z 5-calowym ekranem o rozdzielczości 640×1136 i 13-megapikselowym aparatem");
	samsung.setCategory("smartfon");
	samsung.setManufacturer("Samsung");
	samsung.setUnitsInStock(1000);

	Product samsung1 = new Product("P1238","Samsung s8", new BigDecimal(1100));
	samsung1.setDescription("Samsung S8, smartfon z 6-calowym ekranem o rozdzielczości 640×1136 i 20 megapikselowym aparatem");
	samsung1.setCategory("smartfon");
	samsung1.setManufacturer("Samsung");
	samsung1.setUnitsInStock(1000);

    listOfProducts.add(iphone);
    listOfProducts.add(laptop_dell);
    listOfProducts.add(tablet_Nexus);
    listOfProducts.add(samsung);
    listOfProducts.add(samsung1);
	}

	public List<Product> getAllProducts() {
		return listOfProducts;
	}

	public Product getProductById(String productId) {
		Product productById = null;
		
		for(Product product : listOfProducts) {
			if(product!=null && product.getProductId()!=null && product.getProductId().equals(productId)){
				productById = product;
				break;
			}
		}
		
		if(productById == null){
			throw new IllegalArgumentException("Brak produktu o wskazanym id: "+ productId);
		}
		
		return productById;
	}
	public void addProduct(Product product) {
		listOfProducts.add(product);
	}
}
