package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Shop
 *
 */
@Entity

public class Shop implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private GovermentEnum goverment;
	@OneToOne
	private Delegation delegation;
	private String adress;
	private String phone;
	private String imageShop ;
	private String libelle; 
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public GovermentEnum getGoverment() {
		return goverment;
	}

	public void setGoverment(GovermentEnum goverment) {
		this.goverment = goverment;
	}



	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Shop() {
		super();
	}

	public Delegation getDelegation() {
		return delegation;
	}

	public void setDelegation(Delegation delegation) {
		this.delegation = delegation;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getImageShop() {
		return imageShop;
	}

	public void setImageShop(String imageShop) {
		this.imageShop = imageShop;
	}
	
	
   
}
