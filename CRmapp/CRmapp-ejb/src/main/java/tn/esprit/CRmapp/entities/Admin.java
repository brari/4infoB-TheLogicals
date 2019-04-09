package tn.esprit.CRmapp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
@Entity
public class Admin extends User implements Serializable{
	
	
	private int cin ;

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String email, String password, String address, String phoneNumber,int cin) {
	
		super(email, password, address, phoneNumber);
		this.cin=cin;
		// TODO Auto-generated constructor stub
	}
	
	
	
	  public Admin(String email, String password, String address, String phoneNumber) {
		super(email, password, address, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	    public String toString(){
	        return super.toString() + "cin: " + cin;
	    }

}

