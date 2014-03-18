package com.demo.hibernate;
//���ﳵ��Ʒ��
public class CartItem
{
	private Item item;
	private int quantity = 0;
	private double price = 0;
	
	//constructor 
	public CartItem(Item item, int quantity)
	{
		this.item = item;
		this.quantity = quantity;
		this.price = item.getPrice()*quantity;	
	}
	
	//get()��set()��Ϊ�˵���ȡ��Ա��ֵ
	
	public void setitem(Item item)
	{
		this.item = item;
		
	}
	
	
	//�ı��������Զ��ı�۸�
	public void setquantity(int quantity)
	{   
		this.quantity = quantity;
		price = item.getPrice()*quantity;	
	}
	
	
	public Item getitem()
	{
		return item;
	}
	
	public int getquantity()
	{
		return quantity;
	}
	
	public double getprice()
	{
		return price;
	}
	
	//������ﳵ��Ʒ����Ϣ
	
	
	public void printCartItemInfo()
	{
		
		   item.printItemInfo();
		   print("��������:"+ quantity+" ");
		   print("���ﳵ��Ʒ���ܼ�:" + price+" ");
		   System.out.println();
     }  

	private void print(Object o) 
	{
			// TODO Auto-generated method stub
			System.out.print(o);
			
	}
}
