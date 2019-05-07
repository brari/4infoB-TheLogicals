package tn.esprit.CRmapp.presentation.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.CRmapp.entities.Client;
import tn.esprit.CRmapp.services.adminService;
import tn.esprit.CRmapp.services.userService;

@ManagedBean
@SessionScoped
public class UserBean {
	
	
	private String email;
	private String password;
	private String address;
	private String phoneNumber;
	private int fidelity_pt;
	private List<Client> ClientList;
	private int id;
	


@EJB
userService userService;
adminService userService1;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

	public List<Client> getClientList() {
		ClientList=userService.findAllUsers();
		return ClientList;
	}

	public void setClientList(List<Client> clientList) {
		ClientList = clientList;
	}

	public int getFidelity_pt() {
		return fidelity_pt;
	}

	public void setFidelity_pt(int fidelity_pt) {
		this.fidelity_pt = fidelity_pt;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
public UserBean(String email, String password, String address, String phoneNumber, int fidelity_pt) {
		super();
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.fidelity_pt = fidelity_pt;
	}

public UserBean(String email, String password, String address, String phoneNumber) {
		super();
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
public UserBean() {
		super();
	}

public String ajouterUser(){
	userService.addUser(new Client(email,password,address,phoneNumber));
String url="ClientList?faces-redirect=true";
	
	return url;
	}



public void supprimerClient(int ide){
	
	userService.removeUser(ide);
	 
	
}
public void miseajour_client(){
	userService.updateUser(new Client(email,password,address,phoneNumber,fidelity_pt),id);
}

public void modifier_client(Client clt){
	this.setEmail(clt.getEmail());
	this.setPassword(clt.getPassword());
	this.setAddress(clt.getAddress());
	this.setPhoneNumber(clt.getPhoneNumber());
	this.setFidelity_pt(clt.getFidelity_pt());
	this.setId(clt.getIdUser());
	
	
	
	
}
}
