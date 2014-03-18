package com.demo.hibernate;

@SuppressWarnings("serial")
public class Food extends Item
{
	private String bestBefore;
	private String origin;

	public void setbestBefore(String bestBefore)
	{
		this.bestBefore = bestBefore;
	}
	
	public String getbestBefore()
	{
		return bestBefore;
	}
	
	public void setorigin(String origin)
	{
		this.origin = origin;
	}
	
	public String getorigin()
	{
		return origin;
	}
	
	public void printprintItemInfo()
	{
		super.printItemInfo();
		System.out.println(bestBefore);
		
	}

}
