package com.niit.backendshopping.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendshopping.dao.CategoryDAO;
import com.niit.backendshopping.entity.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> getList() {

		String selectActiveCategory = "FROM Category where catIsActive =:active";
		Query<Category> query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory,Category.class);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public boolean addCategory(Category category) {
		try {
			// Add the new Category to the DB table!!
			sessionFactory.getCurrentSession().persist(category);
			System.out.println("Category added successfully!!");
			return true;
		} catch (Exception ex) {
			System.out.println("Category addition failed!!");
			ex.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean updateCategory(Category category) {
		try {
			// Update a Category in the DB table!!
			sessionFactory.getCurrentSession().update(category);
			System.out.println("Category updated successfully!!");
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Category updation failed!!");
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		try {
			// Delete a Category from the DB table!!
			category.setCatIsActive(false);
			sessionFactory.getCurrentSession().update(category);
			System.out.println("Category deactivated!!");
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Category deletion failed!!");
			return false;
		}

	}

	@Override
	public List<Category> list() {
		return null;

	}

	@Override
	public Category getCategory(int catID) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(catID));
	
	}

}