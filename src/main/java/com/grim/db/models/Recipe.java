package com.grim.db.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the recipe database table.
 * 
 */
@Entity
@NamedQuery(name="Recipe.findAll", query="SELECT r FROM Recipe r")
public class Recipe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="recipe_id")
	private int recipeId;

	private String category;

	@Lob
	private String explanation;

	private String name;

	@Column(name="recipe_autheur")
	private int recipeAutheur;

	@Column(name="recipe_type")
	private String recipeType;

	private String time;

	//bi-directional many-to-one association to Ingredient
	@ManyToOne
	@JoinColumn(name="ingredient")
	private Ingredient ingredientBean;

	public Recipe() {
	}

	public int getRecipeId() {
		return this.recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getExplanation() {
		return this.explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRecipeAutheur() {
		return this.recipeAutheur;
	}

	public void setRecipeAutheur(int recipeAutheur) {
		this.recipeAutheur = recipeAutheur;
	}

	public String getRecipeType() {
		return this.recipeType;
	}

	public void setRecipeType(String recipeType) {
		this.recipeType = recipeType;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Ingredient getIngredientBean() {
		return this.ingredientBean;
	}

	public void setIngredientBean(Ingredient ingredientBean) {
		this.ingredientBean = ingredientBean;
	}

}