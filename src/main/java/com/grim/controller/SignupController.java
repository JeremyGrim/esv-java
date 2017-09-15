package com.grim.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


import com.grim.beans.MyContext;
import com.grim.db.models.User;

@ManagedBean(name = "signup", eager = true)
@ViewScoped
public class SignupController {
	
	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;
	
	String pseudo;
	String password;
	String password2;
	String email;
	
	
	public SignupController() {
		// TODO Auto-generated constructor stub
	}
	

	public void submit() {
			
		User user = new User();
		user.setEmail(email);
		user.setUserPassword(password);
		user.setUsername(pseudo);
		
		User sessionUser = (User)myContext.getRepository().create(user);
		
		if (sessionUser != null) {
			FacesContext facesContext = FacesContext.getCurrentInstance(); 
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			
			session.setAttribute("user", sessionUser);
			
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("In/recipe.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
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
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}


	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the password2
	 */
	public String getPassword2() {
		return password2;
	}


	/**
	 * @param password2 the password2 to set
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	
	
	

	
	
}