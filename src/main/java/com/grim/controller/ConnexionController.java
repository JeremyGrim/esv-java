package com.grim.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.grim.beans.MyContext;
import com.grim.db.models.User;




@ManagedBean
@ViewScoped
public class ConnexionController {
	
	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;
	
	String login;
	String password;
	

	public ConnexionController() {
		
	}
	
	public void login() {
		
		System.out.println("test *********************************");

		Map<String, Object> prop = new HashMap<String, Object>();
		prop.put("login", login);
		Object obj = myContext.getRepository().queryObject("User.findByEmailOrUserName", prop);
		
        if (obj!=null && ((User)obj).getPassword().equals(password)) {
        
        	User user =  (User)obj;
        	
        	FacesContext facesContext = FacesContext.getCurrentInstance(); 
        	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        	
        	session.setAttribute("user", user);
        	
        	
        	try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("In/recipe.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
        	
            //FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Congratulations! You've successfully logged in.");
            //FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
 
        } else {
        	
        	
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "That's the wrong password. Hint: BootsFaces rocks!");
            FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
                        
        }
	}
	
	public void forgotPassword() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default user name: BootsFaces");
        FacesContext.getCurrentInstance().addMessage("loginForm:username", msg);
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default password: rocks!");
        FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
    }

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
