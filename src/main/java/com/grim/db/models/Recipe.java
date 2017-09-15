package com.grim.db.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	private int category;

	@Lob
	private String explanation;

	private String name;

	@Column(name="recipe_autheur")
	private int recipeAutheur;

	@Column(name="recipe_type")
	private int recipeType;

	private String time;

	//bi-directional many-to-one association to Ingredient
	@ManyToOne
	@JoinColumn(name="ingredient")
	private Ingredient ingredientBean;

	//bi-directional many-to-many association to Category
	@ManyToMany
	@JoinTable(
		name="recipe_category"
		, joinColumns={
			@JoinColumn(name="idrecipe")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idcategory")
			}
		)
	private List<Category> categories;

	//bi-directional many-to-many association to Type
	@ManyToMany
	@JoinTable(
		name="recipe_type"
		, joinColumns={
			@JoinColumn(name="id_recipe")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_type")
			}
		)
	private List<Type> types;

	public Recipe() {
	}

	public int getRecipeId() {
		return this.recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public int getCategory() {
		return this.category;
	}

	public void setCategory(int category) {
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

	public int getRecipeType() {
		return this.recipeType;
	}

	public void setRecipeType(int recipeType) {
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

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Type> getTypes() {
		return this.types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

}