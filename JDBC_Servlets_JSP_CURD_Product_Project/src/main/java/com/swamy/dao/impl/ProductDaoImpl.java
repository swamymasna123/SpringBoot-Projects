package com.swamy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.swamy.dao.IProductDao;
import com.swamy.model.Product;
import com.swamy.util.ConnectionUtil;

public class ProductDaoImpl implements IProductDao {
	private static final String SAVE_PRODUCTS_SQL = " INSERT INTO PRODUCTS(PNAME,PCOST,PDESC) VALUES(?,?,?) ";
	private static final String FETCH_PRODUCTS_SQL = " SELECT * FROM PRODUCTS ";
	private static final String DELETE_PRODUCT_SQL = " DELETE FROM PRODUCTS WHERE PID=?";
	private static final String GET_ONE_PRODUCT_SQL = " SELECT * FROM PRODUCTS WHERE PID=?";
	private static final String UPDATE_PRODUCTS_SQL = " UPDATE PRODUCTS SET PNAME=?,PCOST=?,PDESC=? WHERE PID=? ";
	
	public Integer saveProduct(Product product) {
		Integer count = null;
		try {
			Connection con = ConnectionUtil.getCon();
			PreparedStatement pstmt = con.prepareStatement(SAVE_PRODUCTS_SQL);
			pstmt.setString(1, product.getPname());
			pstmt.setDouble(2, product.getPcost());
			pstmt.setString(3, product.getPdesc());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<Product> getAllProducts() {
		List<Product>list = null;
		try {
			Connection con = ConnectionUtil.getCon();
			PreparedStatement pstmt = con.prepareStatement(FETCH_PRODUCTS_SQL);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<Product>();
			while(rs.next()) {
				list.add(new Product
							( rs.getInt("pid"), 
								rs.getString("pname"), 
								rs.getDouble("pcost"), 
								rs.getString("pdesc"))
							);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public boolean deleteProduct(Integer id) {
		boolean flag = false;
		try {
			Connection con = ConnectionUtil.getCon();
			PreparedStatement pstmt = con.prepareStatement(DELETE_PRODUCT_SQL);
			pstmt.setInt(1, id);
			int count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public Product getOneProduct(Integer id) {
		Product product = null;
		try {
			Connection con = ConnectionUtil.getCon();
			PreparedStatement pstmt = con.prepareStatement(GET_ONE_PRODUCT_SQL);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				product = new Product
							(rs.getInt("pid"), 
								rs.getString("pname"), 
								rs.getDouble("pcost"), 
								rs.getString("pdesc")
							 );		
							}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	public void updateProduct(Product product) {
		try {
			Connection con = ConnectionUtil.getCon();
			PreparedStatement pstmt = con.prepareStatement(UPDATE_PRODUCTS_SQL);
			pstmt.setString(1, product.getPname());
			pstmt.setDouble(2, product.getPcost());
			pstmt.setString(3, product.getPdesc());
			pstmt.setInt(4, product.getPid());
			int count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

