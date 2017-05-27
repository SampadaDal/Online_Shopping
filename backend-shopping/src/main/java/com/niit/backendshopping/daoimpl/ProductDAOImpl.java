package com.niit.backendshopping.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendshopping.dao.ProductDAO;
import com.niit.backendshopping.entity.Product;

@Repository("productDAO")
@Transactional // it should run under Transactional Manager!!
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> list() {

		return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();

	}

	@Override
	public boolean add(Product product) {

		try {
			// add the new product to the DB table!!
			sessionFactory.getCurrentSession().persist(product);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override // Getting single Product based on the given id!!
	public Product get(int id) {
		System.out.println("Product class is: " + Product.class);

		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Product product) {
		try {
			// Update the new product to the DB table!!
			// using the update method instead of persist method, that's the
			// only change!!
			sessionFactory.getCurrentSession().update(product);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {

		product.setActive(false);

		try {
			// Update the new product to the DB table!!
			// using the update method instead of persist method, that's the
			// only change!!
			// sessionFactory.getCurrentSession().update(product);
			// return true;

			// Returns the current product
			return this.update(product);

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Product> listOfActiveProducts() {

		String selectActiveProducts = "FROM Product WHERE isActive = :active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class)
				.setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listOfActiveProductsByCategory(int categoryId) {
		
		String selectActiveProductsByCategory = "FROM Product WHERE isActive = :active AND categoryId = :categoryId";
		return sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveProductsByCategory,Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
			}

	@Override
	public List<Product> getLatestActiveProducts(int count) {

		return sessionFactory
				.getCurrentSession()
				.createQuery("FROM Product WHERE isActive = :active ORDER BY id",Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}
}