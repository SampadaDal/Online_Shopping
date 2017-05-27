package com.niit.backendshopping.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catID;
	private String catName;
	private String catDescription;
	private String catImageURL;
	private boolean catIsActive = true;

	public int getCatID() {
		return catID;
	}

	public void setCatID(int catID) {
		this.catID = catID;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatDescription() {
		return catDescription;
	}

	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}

	public boolean isCatIsActive() {
		return catIsActive;
	}

	public void setCatIsActive(boolean catIsActive) {
		this.catIsActive = catIsActive;
	}

	public String getCatImageURL() {
		return catImageURL;
	}

	public void setCatImageURL(String catImageURL) {
		this.catImageURL = catImageURL;
	}

	@Override
	public String toString() {
		return "Category [catID=" + catID + ", catName=" + catName + ", catDescription=" + catDescription
				+ ", catImageURL=" + catImageURL + ", catIsActive=" + catIsActive + "]";
	}

}
