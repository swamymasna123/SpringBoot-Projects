package com.swamy.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.swamy.dao.IProductDao;
import com.swamy.model.Product;
import com.swamy.util.HibernateUtil;

public class ProductDaoImpl implements IProductDao {

	@Override
	public Integer saveProduct(Product product) {
		Integer count = null;
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses){
			tx = ses.beginTransaction();
			count = (Integer)ses.save(product);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		List<Product>list=null;
		Session ses=HibernateUtil.getSf().openSession();
		String hql=" from com.swamy.model.Product ";
		try(ses){
			list=(List<Product>) ses.createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void deleteProduct(Integer id) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses){
			tx = ses.beginTransaction();
			Product p = new Product();
			p.setPid(id);
			ses.delete(p);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public Product getOneProduct(Integer id) {
		Product product=null;
		Session ses=HibernateUtil.getSf().openSession();
		try {
			product=ses.get(Product.class, id);
			System.out.println(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public void updateProduct(Product product) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses){
			tx = ses.beginTransaction();
			ses.update(product);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
