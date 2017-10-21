package model;

import java.io.Serializable;

public class Clother implements Serializable {
	private String id;
	private String jeans;
	private String shirt;
	private String coat;
	
	
	
	public Clother() {
		this("","","","");
	}



	public Clother(String id, String jeans, String shirt, String coat) {
		super();
		this.id = id;
		this.jeans = jeans;
		this.shirt = shirt;
		this.coat = coat;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getJeans() {
		return jeans;
	}



	public void setJeans(String jeans) {
		this.jeans = jeans;
	}



	public String getShirt() {
		return shirt;
	}



	public void setShirt(String shirt) {
		this.shirt = shirt;
	}



	public String getCoat() {
		return coat;
	}



	public void setCoat(String coat) {
		this.coat = coat;
	}



	@Override
	public String toString() {
		return "Clother [id=" + id + ", jeans=" + jeans + ", shirt=" + shirt + ", coat=" + coat + "]";
	}
	
	
	
	

}
