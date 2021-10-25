package com.swamy.service;

import java.util.List;

import com.swamy.model.Product;

public interface IProductService {

	public Integer saveProduct(Product product);
	public List<Product>getAllProducts();
	public void deleteProduct(Integer id);
	public Product getOneProduct(Integer id);
	public void updateProduct(Product product);
}
