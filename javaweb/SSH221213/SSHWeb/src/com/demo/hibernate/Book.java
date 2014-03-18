package com.demo.hibernate;

public class Book extends Item
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ISDN;
	public Book(int id, String name, double price, String description,String ISDN)
	{
	//	super(id,name,price,description);
		this.ISDN = ISDN;
		
	}
	
	public void setISDN(String ISDN)
	{
		this.ISDN = ISDN;
	}
	
	public String getISDN()
	{
		return ISDN;
	}
	
	public void printprintItemInfo()
	{
		super.printItemInfo();
		System.out.println(ISDN);
	}

}
