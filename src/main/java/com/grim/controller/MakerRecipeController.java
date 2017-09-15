package com.grim.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.grim.beans.MyContext;
import com.grim.db.models.Category;
import com.grim.db.models.Recipe;
import com.grim.db.models.Type;
import com.grim.db.models.User;

@ManagedBean(name = "makerRecipe", eager = true)
@ViewScoped
public class MakerRecipeController {
	
	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;

	String name, time, explanation, types, category;
	
	
	

	public MakerRecipeController() {
		// TODO Auto-generated constructor stub
	}
	
	public void maker() {
		
		Recipe recipe = new Recipe();
		recipe.setName(name);
		recipe.setTime(time);
		recipe.setRecipeType(types);
		recipe.setCategory(category);
		recipe.setExplanation(explanation);
		
		
		
		Recipe newRecipe = (Recipe)myContext.getRepository().create(recipe);
		
		System.out.println(name + time + types + category + explanation);
		
		
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the explanationn
	 */
	public String getExplanationn() {
		return explanation;
	}

	/**
	 * @param explanationn the explanationn to set
	 */
	public void setExplanationn(String explanationn) {
		this.explanation = explanationn;
	}

	/**
	 * @return the types
	 */
	public String getTypes() {
		return types;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(String types) {
		this.types = types;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * @return the explanation
	 */
	public String getExplanation() {
		return explanation;
	}

	/**
	 * @param explanation the explanation to set
	 */
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	
	




	
	
}
