package com.demo.hibernate;
import java.util.*;


public class Cart
{   
	public int number = 0;
	private List<CartItem> ct = new ArrayList<CartItem>();
	private double price = 0;
	
	//i��ʾ���빺�ﳵ�е���Ŀ��
	
	
	//�ڷ��빺�ﳵ��Ʒ��ʱ����Զ�����۸��
	public void setCartItems(List<CartItem> c,int k)
	{   
        //����һ�����ﳵ��Ʒ�б���Ȼ����뵱ǰ���ﳵ��
		int currentPrice = 0;
		ct = c;
		for (int i=0; i<c.size(); i++)
		{
			currentPrice += c.get(i).getprice();
		}
		price = currentPrice;
      	
	}
	
	//�ж�ĳ����ı���Ƿ��ڹ��ﳵ�ڴ���
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
	
 	//������Ʒȡ����Ӧ�Ĺ��ﳵ��Ʒ
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
	
	
	//�޸Ĺ��ﳵĳһ��ƽ����,������item�����ã���Ϊitem�����飬����equals����û������
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
			//���������ͬ��ŵ���Ʒ����ô����������
		
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
			//���������ͬ��ŵ���Ʒ����ô����������
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
		//ȡ�����ﳵ��Ʒ����һ���
		for (int i=0; i<ct.size(); i++)
		{
		ct.get(i).printCartItemInfo();
		}
		System.out.println("�������������Ʒ���ܼ����£�");
		this.calTotalPrice();
		
		
	}

	public List<CartItem> getCt() {
		return ct;
	}

	public void setCt(List<CartItem> ct) {
		this.ct = ct;
	}
	
	
}