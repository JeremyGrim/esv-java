package com.grim.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.grim.beans.MyContext;
import com.grim.db.models.Category;
import com.grim.db.models.Type;

@ManagedBean(name = "listeType", eager = true)
@ViewScoped
public class ListeTypeController {
	
	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;


	private List<Type> types;
	
	public ListeTypeController() {
		
		
		
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
	 * @return the types
	 */
	public List<Type> getTypes() {
		types = (List<Type>) myContext.getRepository().queryList("Type.findAll", null); 
		System.out.println(types);
		return types;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(List<Type> types) {
		this.types = types;
	}
	
	





	
	
}
