package com.demo.hibernate.service;


import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.demo.hibernate.Item;
import com.demo.hibernate.ItemDAO;

public class test {

	public static void main(String[] args){
		//Session session = null;
		try{
			//String path = test.class.getResource("applicationContext.xml").getPath();
			//System.out.println("path = " +path);
			//session = HibernateSessionFactory.getSession();
		//	ApplicationContext ctx = new FileSystemXmlApplicationContext("file:F:\\SSH221213\\SSHWeb\\src\\applicationContext.xml");
		//	Configuration cig = new Configuration().
			/*ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			ItemDAO itemDao = (ItemDAO)ctx.getBean("ItemDAO");
			*/
			Item item = new Item();
			item.setId(9);
			item.setName("ÄûÃÊ²è");
			item.setPrice(4.00);
			item.setDescription("½â¿Ê");
			
			/*int i = itemDao.findById(1).getId();
			
			//System.out.println(i);
			List<Item> list = itemDao.findAll();
			list.get(0).printItemInfo();*/
			
			 AdminService itemService = new AdminServiceImpl();
			 int num = itemService.getTotalNum();
	          System.out.print(num);
			//System.out.print(item.getId());			
		//	 itemDao.save(item);
			//Item persistentInstance = item;
			//itemDao.delete(item);
		//	System.out.println(itemDao.findById(1).getId());
		//	System.out.println(itemDao.findById(1).getName());
			
		}catch(BeansException e){
			System.out.println(e.getMessage());
		}
		catch(Exception ee){
			System.out.println(ee.getMessage());
		}
	}
	
}
