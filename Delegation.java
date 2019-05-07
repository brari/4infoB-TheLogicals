package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Delegation
 *
 */
@Entity

public class Delegation implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private GovermentEnum goverment;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public GovermentEnum getGoverment() {
		return goverment;
	}


	public void setGoverment(GovermentEnum goverment) {
		this.goverment = goverment;
	}


	public Delegation() {
		super();
	}


	@Override
	public String toString() {
		return  id + "   "+ name ;
	}
	
}
