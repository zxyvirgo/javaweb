package com.demo.hibernate;
import java.util.*;


public class Cart
{   
	public int number = 0;
	private List<CartItem> ct = new ArrayList<CartItem>();
	private double price = 0;
	
	//i表示放入购物车中的条目数
	
	
	//在放入购物车物品的时候会自动计算价格的
	public void setCartItems(List<CartItem> c,int k)
	{   
        //传入一个购物车物品列表，然后放入当前购物车内
		int currentPrice = 0;
		ct = c;
		for (int i=0; i<c.size(); i++)
		{
			currentPrice += c.get(i).getprice();
		}
		price = currentPrice;
      	
	}
	
	//判断某输入的编号是否在购物车内存在
	public boolean getCartItemNum(int num)
	{
		for (int i=0; i<ct.size(); i++)
		{
			if (ct.get(i).getitem().getId() == num)
			{
				return true;
			}
			
		}
		return false;
	}
	
 	//根据商品取出对应的购物车物品
	public CartItem getCartItem(int num)
	{
			
		return ct.get(num);
	}
	

   public CartItem getCartItem(Item item)
   {    
	   int num = -1;
		for (int i=0; i<ct.size(); i++)
		{
			if (ct.get(i).getitem() == item)
			{
				num = i;
			}
			
		}
		return ct.get(num);
   }
	
	public double getPrice()
	{
		return price;
	}
	
	public void calTotalPrice()
	{   
		price = 0;
		for (int i=0; i<ct.size(); i++)
		{
			price += ct.get(i).getprice();
		}
		
		System.out.println(price);
	}
	
	
	//修改购物车某一武平数量,传的是item的引用，因为item是数组，所以equals方法没有问题
	public void changeQuantity(Item c,int k)
	{   
		int num = -1;
		for(int i=0; i<ct.size(); i++)
		{
			if(ct.get(i).getitem().equals(c))
			{
				num = i;
			}
		}
		ct.get(num).setquantity(k);
		this.calTotalPrice();
	}
	
	
	public void changeQuantity(int num,int k)
	{   
	
		ct.get(num).setquantity(k);
		this.calTotalPrice();
	}
	
	
    
	
	public void Sort()
	{
		int j = ct.size(), change=1,i;
		while (j>0 && (boolean)(change==1))
		{ 
			change = 0;
			for (i=0; i<j; i++)
			{
			if (ct.get(i).getitem().getPrice() < ct.get(i+1).getitem().getPrice())
			{   
				CartItem first = ct.get(i);
				CartItem second = ct.get(i+1);
				ct.set(i,second);
				ct.set(i+1, first);
                change = 1;
			}
			j--;
			}
		}
	}
	
	public void  addCartItem(CartItem c)
	{
		         ct.add(c);	
			     price += c.getprice();
			     number++;
			 //    this.Sort();
	}
	
	
	public void  deleteCartItem(Item c)
	{
			//如果出现相同编号的商品，那么就有问题了
		
	    int num = -1;
		for(int i=0; i<ct.size(); i++)
		{
			if(ct.get(i).getitem().equals(c))
			{
				num = i;
			}
		}
		
		   price -= ct.get(num).getprice();	
		   ct.remove(ct.get(num));
		   number--;
		   
	}
	
	public void  deleteCartItem(int num)
	{
			//如果出现相同编号的商品，那么就有问题了
		   if (ct.size()<=0)return;
		   price -= ct.get(num).getprice();	
		   ct.remove(num);
		   number--;
	}
	
	
	
	
	public void clearCartItem()
	{  
		ct.clear();
		price = 0;
		number = 0;
		
	}
	
	
	public void printCartInfo()
	{
		//取出购物车物品类逐一输出
		for (int i=0; i<ct.size(); i++)
		{
		ct.get(i).printCartItemInfo();
		}
		System.out.println("您所买的所有物品的总价如下：");
		this.calTotalPrice();
		
		
	}

	public List<CartItem> getCt() {
		return ct;
	}

	public void setCt(List<CartItem> ct) {
		this.ct = ct;
	}
	
	
}
