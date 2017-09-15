package com.grim.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.grim.beans.MyContext;
import com.grim.db.models.Recipe;
import com.grim.db.models.Type;

@ManagedBean(name = "recipeList", eager = true)
@ViewScoped
public class RecipeScreenController {
	
	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;

	private List<Recipe> recipes;
	
	
	public RecipeScreenController() {
		
		
		
	}


	/**
	 * @return the recipes
	 */
	public List<Recipe> getRecipes() {
		recipes = (List<Recipe>) myContext.getRepository().queryList("Recipe.findAll", null); 
		System.out.println(recipes);
		return recipes;
	}


	/**
	 * @param recipes the recipes to set
	 */
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
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
