package com.niit.backendshopping.entity;

import java.util.UUID;

//Hibernate uses Persistence API
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * To let Hibernate know that this is our Entity class that will transfer the
 * object to relational DB
 */

@Entity
public class Product {

	@Id // @Id means that this is the primary key in the DB table.
	@GeneratedValue(strategy = GenerationType.IDENTITY) /*
														 * this will specify
														 * that id field must
														 * auto increment
														 */
	private int id;
	private String code;
	private String name;
	private String brand;

	/*
	 * @Column(name = "description") if the field names are diff in the java
	 * class n the sql table then we specify it using @Column annotation!!
	 */
	@JsonIgnore
	private String description;
	private double price;
	private int quantity;

	@JsonIgnore
	@Column(name = "is_active")
	private boolean isActive;

	@JsonIgnore
	@Column(name = "category_id")
	private int categoryId;

	@JsonIgnore
	@Column(name = "user_id")
	private int userId;
	private int purchases;
	private int views;

	// Product constructor to initialize the value of code to unique characters

	public Product() {

		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPurchases() {
		return purchases;
	}

	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", price=" + price + ", quantity=" + quantity + ", isActive=" + isActive
				+ ", categoryId=" + categoryId + ", userId=" + userId + ", purchases=" + purchases + ", views=" + views
				+ "]";
	}

}
