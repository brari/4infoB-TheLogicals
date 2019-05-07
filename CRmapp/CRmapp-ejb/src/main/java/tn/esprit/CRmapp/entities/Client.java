package tn.esprit.CRmapp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="Client")
public class Client extends User implements Serializable{
	
	private int fidelity_pt;

	public int getFidelity_pt() {
		return fidelity_pt;
	}

	public void setFidelity_pt(int fidelity_pt) {
		this.fidelity_pt = fidelity_pt;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String email, String password, String address, String phoneNumber,int fidelity_pt) {
		super(email, password, address, phoneNumber);
		this.fidelity_pt=0;
		
		// TODO Auto-generated constructor stub
		
		
	}
	

	 public Client(String email, String password, String address, String phoneNumber) {
		super(email, password, address, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	    public String toString(){
	        return super.toString() + "fid: " + fidelity_pt;
	    }

	}

	
	

	
	
	
	
	
	


