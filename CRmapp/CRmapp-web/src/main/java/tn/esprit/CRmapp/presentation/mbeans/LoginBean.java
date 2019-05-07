package tn.esprit.CRmapp.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.CRmapp.entities.Admin;
import tn.esprit.CRmapp.services.adminService;

@ManagedBean
@SessionScoped

public class LoginBean {
	
	private String login;
	private String password;
	private Admin admin;
	private boolean logged;
	private boolean cred;
	
	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isLogged() {
		return logged;
	}


	public void setLogged(boolean logged) {
		this.logged = logged;
	}


	public boolean isCred() {
		return cred;
	}


	public void setCred(boolean cred) {
		this.cred = cred;
	}


	@EJB
	
	adminService adminserverice;
	
	public String Logg(){
	String navigateTo="null";
	cred=adminserverice.authentifier(login, password);
	if (cred==true){
		navigateTo="ClientList?faces-redirect=true";
		logged=true;
	}
	else{
		
		FacesContext.getCurrentInstance().addMessage("form:btn",new FacesMessage("bad credentials"));
	}
	return navigateTo;

	}
	
	
	public String logout(){
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		
		return "login?faces-redirect=true";
	}
	
}
