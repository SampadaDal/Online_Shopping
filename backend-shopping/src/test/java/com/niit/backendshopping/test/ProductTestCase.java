package com.niit.backendshopping.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backendshopping.dao.ProductDAO;
import com.niit.backendshopping.entity.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass // To initialize the variable!!
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backendshopping");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	/*
	 * * @Test public void testAddProduct() {
	 * 
	 * product = new Product();
	 * 
	 * product.setName("Watches"); product.setBrand("Casio Erifice");
	 * product.setDesc("Big for his wrist "); product.setPrice(2000);
	 * product.setQuantity(1); product.setActive(true);
	 * 
	 * assertEquals("Failed to add a new Product!!",true,productDAO.add(product)
	 * ); }
	 * 
	 * 
	 * 
	 * @Test public void testGetProduct() { product = productDAO.get(4); try {
	 * System.out.println("Product name:"+product.getName());
	 * assertEquals("Failed to get the product!!","Watches",product.getName());
	 * //assertEquals("Failed to get the product!!","Shirts",product.getName());
	 * } catch(Exception ex) { //ex.printStackTrace();
	 * System.out.println("No product fetched!!"); } }
	 * 
	 * 
	 * 
	 * @Test public void testUpdateProduct() { product = productDAO.get(2); try
	 * { System.out.println("Product name:" + product.getName());
	 * product.setName("Wrist Watches");
	 * assertEquals("Failed to update the product!!",true,
	 * productDAO.update(product)); // assertEquals("Failed to get the //
	 * product!!","Shirts",product.getName());
	 * 
	 * } catch (Exception ex) { // ex.printStackTrace();
	 * System.out.println("No product fetched!!"); } }
	 * 
	 * 
	 * 
	 * @Test public void testDeleteProduct() { product = productDAO.get(1); try
	 * { System.out.println("Product name:" + product.getName());
	 * assertEquals("Failed to delete the product!!",true,
	 * productDAO.delete(product)); //
	 * assertEquals("Failed to get the product!!","Dummy",product.getName());
	 * 
	 * } catch (Exception ex) { // ex.printStackTrace();
	 * System.out.println("No product fetched!!"); } }
	 * 
	 * 
	 * 
	 * @Test public void testListOfProducts() {
	 * 
	 * assertEquals("failed to get the List of products",4,productDAO.list().
	 * size());
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test public void testCRUDOperation() {
	 * 
	 * // Adding new products!! product = new Product();
	 * 
	 * product.setCategoryId(1); product.setName("Nikon 530P Coolpix");
	 * product.setBrand("Nikon"); product.setDescription("This is an SLR");
	 * product.setPrice(15000); product.setUserId(1); product.setActive(true);
	 * 
	 * assertEquals("Failed to add a new Product!!", true,
	 * productDAO.add(product));
	 * 
	 * // Fetch and update a Category product = productDAO.get(1);
	 * 
	 * try { System.out.println("Product name:" + product.getName());
	 * product.setName("Titan Raga");
	 * 
	 * assertEquals("Failed to update the product!!", true,
	 * productDAO.update(product));
	 * 
	 * 
	 * } catch (Exception ex) { // ex.printStackTrace();
	 * System.out.println("No product fetched!!"); }
	 * 
	 * //Delete this product assertEquals("Failed to delete the product!!",true,
	 * productDAO.delete(product));
	 * 
	 * //Get all the products
	 * assertEquals("failed to get the List of products",2,productDAO.list().
	 * size());
	 * 
	 * }
	 */

	@Test
	public void testListOfActiveProducts() {

		assertEquals("failed to get the List of active products", 1, productDAO.listOfActiveProducts().size());
	}

	@Test
	public void testListOfActiveProductsByCategory() {

		assertEquals("failed to get the List of active products by CategoryId 3", 0,
				productDAO.listOfActiveProductsByCategory(3).size());

		assertEquals("failed to get the List of active products by CategoryId 1", 1,
				productDAO.listOfActiveProductsByCategory(1).size());
	}

	@Test
	public void testLatestActiveProducts() {

		assertEquals("failed to get the Latest active products", 1, productDAO.getLatestActiveProducts(1).size());
	}
}
