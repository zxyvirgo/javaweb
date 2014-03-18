package com.demo.hibernate;

/**
 * AbstractItem entity provides the base persistence definition of the Item
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractItem implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Double price;
	private String description;

	// Constructors

	/** default constructor */
	public AbstractItem() {
	}

	/** minimal constructor */
	public AbstractItem(Integer id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	/** full constructor */
	public AbstractItem(Integer id, String name, Double price,
			String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}