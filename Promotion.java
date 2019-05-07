package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Promotion
 *
 */
@Entity

public class Promotion implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Double promotionRate;
	@OneToOne
	private Product product;
	private Date dateStart;
	private Date dateEnd;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Double getPromotionRate() {
		return promotionRate;
	}


	public void setPromotionRate(Double promotionRate) {
		this.promotionRate = promotionRate;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Date getDateStart() {
		return dateStart;
	}


	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}


	public Date getDateEnd() {
		return dateEnd;
	}


	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}


	public Promotion() {
		super();
		this.dateStart=new Date();
		
	}


	@Override
	public String toString() {
		return "Promotion [id=" + id + ", promotionRate=" + promotionRate + ", product=" + product + ", dateStart="
				+ dateStart + ", dateEnd=" + dateEnd + "]";
	}
	
	
	
   
}
