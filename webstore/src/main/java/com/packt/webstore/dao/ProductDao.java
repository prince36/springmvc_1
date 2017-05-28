package com.packt.webstore.dao;

import com.packt.webstore.models.Product;

import java.util.List;

/**
 * Created by Ja on 28.05.2017.
 */
public interface ProductDao {

    Product findById(int id);

    List<Product> findAllProducts();


}
