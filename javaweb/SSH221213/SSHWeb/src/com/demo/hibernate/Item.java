package com.demo.hibernate;

/**
 * Item entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
public class Item extends AbstractItem implements java.io.Serializable {

	// Constructors

	private int id;
	private String name;
	private double price;
	private String description;
	/** default constructor */
	public Item() {
	}

	/** minimal constructor */
	public Item(Integer id, String name, Double price) {
		super(id, name, price);
	}

	/** full constructor */
	public Item(Integer id, String name, Double price, String description) {
		super(id, name, price, description);
	}
    
	
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	
	public Item getItem(){
		return this;
	}
	public void setDescription(String description) {
		this.description = description;
	}
     
   /*     public String getItem()
	{
		return (id+","+name+","+price+","+description);
	}*/
	
	public void printItemInfo()
	{  
	   System.out.printf("%-8d %-15.12s % 10.2f %10s",id,name,price,description);
	 
	   System.out.println();
	}
}
