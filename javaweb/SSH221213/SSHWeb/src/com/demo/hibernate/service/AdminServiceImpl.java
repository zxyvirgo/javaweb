package com.demo.hibernate.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.demo.hibernate.Item;
import com.demo.hibernate.ItemDAO;

public class AdminServiceImpl implements AdminService{
	
	public void insert(Item item){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//	Configuration cig = new Configuration().
			ItemDAO itemDao = (ItemDAO)ctx.getBean("ItemDAO");
		    itemDao.save(item);
		
	}
	
	
	
    	public List<Item> getAll(){
//				  ApplicationContext ctx = new FileSystemXmlApplicationContext("file:F:\\SSH221213\\SSHWeb\\src\\applicationContext.xml");
				  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

					//	Configuration cig = new Configuration().
				  ItemDAO itemDao = (ItemDAO)ctx.getBean("ItemDAO");
				  List<Item> list = itemDao.findAll();
				  list.get(0).printItemInfo();
				  return list;
	 }
    	

    	public List<Item> getPart(int i, int j){
//				  ApplicationContext ctx = new FileSystemXmlApplicationContext("file:F:\\SSH221213\\SSHWeb\\src\\applicationContext.xml");
				  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

					//	Configuration cig = new Configuration().
				  ItemDAO itemDao = (ItemDAO)ctx.getBean("ItemDAO");
				  List<Item> list = itemDao.findPart(i, j);
				  list.get(0).printItemInfo();
				  return list;
	 }    
    	
    	   public int getTotalNum(){
   	    	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

   			//	Configuration cig = new Configuration().
   		     ItemDAO itemDao = (ItemDAO)ctx.getBean("ItemDAO");
   		      int  count  = itemDao.getTotalNum();
   		      return count;
   	    }
	
	public void delete(int i){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ItemDAO itemDao = (ItemDAO)ctx.getBean("ItemDAO");
		 Item item = itemDao.findById(i);
		 itemDao.delete(item);
		
	}
	
	public void update(Item item){
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ItemDAO itemDao = (ItemDAO)ctx.getBean("ItemDAO");
		 itemDao.update(item);
	}
    
	public static void main(String[] arg){
		AdminService service = new AdminServiceImpl();
		/*Item item = new Item();
		item.setId(10);
		item.setName("ÄÌ²è");
		item.setPrice(4.00);
		item.setDescription("ËáÌð¿É¿Ú");*/
		//service.insert(item);
		service.delete(11);
	}
	
}
