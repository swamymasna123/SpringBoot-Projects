package com.swamy.service.impl;

import java.util.List;

import com.swamy.dao.IProductDao;
import com.swamy.dao.impl.ProductDaoImpl;
import com.swamy.model.Product;
import com.swamy.service.IProductService;

public class ProductServiceImpl implements IProductService {

	//Create Dao Object
	IProductDao dao = new ProductDaoImpl();
	
	public Integer saveProduct(Product product) {
		Integer count = null;
		count = dao.saveProduct(product);
		return count;
	}

	public List<Product> getAllProducts() {
		List<Product>list = null;
		list = dao.getAllProducts();
		return list;
	}

	public boolean deleteProduct(Integer id) {
		boolean flag = false;
		flag = dao.deleteProduct(id);
		return flag;
	}

	public Product getOneProduct(Integer id) {
		Product product = null;
		product = dao.getOneProduct(id);
		return product;
	}

	public void updateProduct(Product product) {
		dao.updateProduct(product);
	}

}

