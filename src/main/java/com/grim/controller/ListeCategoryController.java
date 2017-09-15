package com.grim.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.grim.beans.MyContext;
import com.grim.db.models.Category;

@ManagedBean(name = "listeCategory", eager = true)
@ViewScoped
public class ListeCategoryController {
	
	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;


	private List<Category> category;
	
	public ListeCategoryController() {
		
		
		
	}
	
	

	/**
	 * @return the category
	 */
	public List<Category> getCategory() {
		category = (List<Category>) myContext.getRepository().queryList("Category.findAll", null); 
		System.out.println(category);
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	
	/**
	 * @return the myContext
	 */
	public MyContext getMyContext() {
		return myContext;
	}




	/**
	 * @param myContext the myContext to set
	 */
	public void setMyContext(MyContext myContext) {
		this.myContext = myContext;
	}



	
	
}
