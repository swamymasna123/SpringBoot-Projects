package com.swamy.dao;

import java.util.List;

import com.swamy.model.Product;

public interface IProductDao {

	public Integer saveProduct(Product product);
	public List<Product>getAllProducts();
	public void deleteProduct(Integer id);
	public Product getOneProduct(Integer id);
	public void updateProduct(Product product);
}
